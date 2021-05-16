package com.github.config;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerRunner {

//    private final Logger logger = LoggerFactory.getLogger(ServerRunner.class);

    private final Tomcat tomcat;

    private final Context ctx;

    public ServerRunner(Tomcat tomcat, Context ctx) {
        this.tomcat = tomcat;
        this.ctx = ctx;
    }

    public void run() {
        try {
            this.tomcat.start();
            this.tomcat.getServer().await();
        } catch (LifecycleException e) {
//            logger.warn("Enter {}", e.getMessage());
        }
    }

}
