package com.github.handler;

import com.github.controllers.UserControllers;
import com.github.dto.TournamentCreationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.Tournament;
import com.github.entity.User;
import com.github.exceptions.BadRequest;
import com.github.exceptions.NotFound;
import com.github.payload.Token;
import com.github.utils.JsonHelper;
import com.github.utils.TokenProvider;
import com.github.utils.TransferObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Handler extends HttpServlet {

    private final UserControllers userControllers;

    public Handler(UserControllers userControllers) {
        this.userControllers = userControllers;
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SERVICE");
        try {
            super.service(req, resp);
            setAccessHeaders(resp);
            System.out.println(req.getRequestURI());
        } catch (BadRequest e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid body.");
        } catch (NotFound e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found.");
        }
    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DO OPTIONS");
        setAccessHeaders(resp);
        resp.setStatus(204);
        setAccessHeaders(resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String url = req.getRequestURI();
        if (url.contains("/account")) {
            Token t = checkTokenInRequest(req, resp);
            User user = this.userControllers.findUser(t.getNickname());
            resp.setContentType("application/json");
            out.write(JsonHelper.toFormat(user).get());
        }
        if(url.contains("/gettournaments")) {
            Token t = checkTokenInRequest(req, resp);
            List<Tournament> list = this.userControllers.getAllTournaments();
            resp.setContentType("application/json");
            out.write(JsonHelper.toFormat(list).get());
        }
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        setAccessHeaders(resp);
        String body = req.getReader().lines().collect(Collectors.joining());
        PrintWriter out = resp.getWriter();
        if (!req.getHeader("Content-Type").contains("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
        } else {
            String url = req.getRequestURI();
            if (url.contains("/auth")) {
                UserAuthorizationDto payload = JsonHelper.fromFormat(body, UserAuthorizationDto.class)
                        .orElseThrow(BadRequest::new);
                String result = this.userControllers.auth(payload);
                if (!Objects.isNull(result)) {
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                    resp.addHeader("Authorization", result);
                    out.write(result);
                } else {
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    out.write("No such user");
                }
            }
            if (url.contains("/registration")) {
                UserRegistrationDto payload = JsonHelper.fromFormat(body, UserRegistrationDto.class)
                        .orElseThrow(BadRequest::new);
                boolean status = this.userControllers.reg(payload);
                if (status) {
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Problems with registration");
                }
            }
            if (url.contains("/createtournament")) {
                checkTokenInRequest(req, resp);
                TournamentCreationDto payload = JsonHelper.fromFormat(body, TournamentCreationDto.class)
                        .orElseThrow(BadRequest::new);
                boolean status = this.userControllers.createTournament(payload);
                if (status) {
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Problems with creation");
                }
            }
            out.flush();
            out.close();
        }
    }

    private Token checkTokenInRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String in = req.getHeader("Authorization");
        Token token = TokenProvider.decode(in);
        if (!TokenProvider.checkToken(token)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Token is invalid");
        }
        return token;
    }

    private void setAccessHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }
}
