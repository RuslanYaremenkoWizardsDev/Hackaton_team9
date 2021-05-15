package com.github.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PropsLoader {
    private static final Logger log = LoggerFactory.getLogger(PropsLoader.class);

    private Map<String,String> properties = new HashMap<>();

    public void loadProperties(String profile){
        String pattern = String.format("application-%s,properties",profile);
        try(InputStream input=PropsLoader.class.getClassLoader().getResourceAsStream(pattern)){
            Properties prop = new Properties();
            if(input==null){
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            this.properties = prop.stringPropertyNames().stream()
                    .collect(Collectors.toMap(Function.identity(), prop::getProperty));
            log.info("Enter:{}",this.properties.toString());

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public Map<String, String> getProperties() {
        return properties;
    }
}
