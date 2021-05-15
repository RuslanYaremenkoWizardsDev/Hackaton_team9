package com.github.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.websocket.server.WsContextListener;

import javax.servlet.ServletException;
import java.io.File;

public class ServerConfig {

    public static ServerRunner tomcat() throws ServletException {
        Tomcat tomcat = new Tomcat();
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080"; //TODO - make 5432
        }
        tomcat.setPort(Integer.parseInt(webPort));
        Context ctx = tomcat.addWebapp("/login", new File(".").getAbsolutePath());
        ctx.addApplicationListener(WsContextListener.class.getName());
        tomcat.addServlet(ctx, "UsersHandlers", HandlerConfig.usersHandlers());
        ctx.addServletMappingDecoded("/*", "UsersHandlers");
        return new ServerRunner(tomcat, ctx);
    }


}
