package com.github.handler;

import com.github.controllers.UserControllers;
import com.github.dto.TournamentCreationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;
import com.github.exceptions.BadRequest;
import com.github.exceptions.NotFound;
import com.github.payload.Token;
import com.github.service.UsersService;
import com.github.utils.JsonHelper;
import com.github.utils.TokenProvider;
import com.github.utils.TransferObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.stream.Collectors;


public class UsersHandlers extends HttpServlet {

    private final UserControllers userControllers;

    public UsersHandlers(UserControllers userControllers) {
        this.userControllers = userControllers;
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SERVICE");
        try {
            super.service(req, resp);
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
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(204);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DO GET");
        PrintWriter out = resp.getWriter();
        if (!req.getHeader("Content-Type").contains("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
        } else {
            String url = req.getRequestURI();
            System.out.println(url);
            if (url.contains("/account")) {
                String token = req.getHeader("Authorization");
                Token t = TokenProvider.decode(token);
                if (Objects.isNull(t)) {
                    resp.setStatus(400);
                    out.write(JsonHelper.toFormat("Token is null").get());
                } else {
                    long exp = t.getExpireIn();
                    if (exp > System.currentTimeMillis()) {
                        User user = this.userControllers.findUser(t.getNickname());
                        resp.setContentType("application/json");
                        out.write(JsonHelper.toFormat(user).get());
                    } else {
                        resp.setStatus(400);
                        out.write(JsonHelper.toFormat("Token is expired.").get());
                    }
                }
                out.flush();
                out.close();

            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DO POST");
        String body = req.getReader().lines().collect(Collectors.joining());
        System.out.println(req.getHeader("Content-Type"));
        PrintWriter out = resp.getWriter();
        if (!req.getHeader("Content-Type").contains("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
        } else {
            String url = req.getRequestURI();
            System.out.println("Body : " + body);
            System.out.println(url);
            if (url.contains("/auth")) {
                System.out.println("AUTH");
                UserAuthorizationDto payload = JsonHelper.fromFormat(body, UserAuthorizationDto.class)
                        .orElseThrow(BadRequest::new);
                User user = TransferObject.toUser(payload);
                String result = this.userControllers.auth(payload);
                if (!Objects.isNull(result)) {
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                    resp.addHeader("Authorization", result);
                    resp.setContentType("application/json");
                    out.write(JsonHelper.toFormat(user.getRole()).get());
                } else {
                    resp.setStatus(403);
                }
                out.flush();
                out.close();
            }

            if (url.contains("/registration")) {
                System.out.println("REG");
                UserRegistrationDto payload = JsonHelper.fromFormat(body, UserRegistrationDto.class)
                        .orElseThrow(BadRequest::new);
                boolean status = this.userControllers.reg(payload);
                if (status) {
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                } else {
                    System.out.println("BAD REQ");
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
            }

            if (url.contains("/createtournament")) {
                System.out.println("Create");
                TournamentCreationDto payload = JsonHelper.fromFormat(body, TournamentCreationDto.class)
                        .orElseThrow(BadRequest::new);
                boolean status = this.userControllers.createTournament(payload);
                if (status) {
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                } else {
                    System.out.println("BAD REQ");
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
            }
        }
    }
}
