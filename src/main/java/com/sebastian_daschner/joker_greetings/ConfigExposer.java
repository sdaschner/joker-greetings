package com.sebastian_daschner.joker_greetings;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.Converter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class ConfigExposer {

    private Properties properties = new Properties();

    @PostConstruct
    private void initConfig() throws IOException {
        try (InputStream input = new FileInputStream("/app-config/application.properties")) {
            properties.load(input);
        }
    }

    @Produces
    @Config("")
    public String exposeConfig(InjectionPoint injectionPoint) {
        Config config = injectionPoint.getAnnotated().getAnnotation(Config.class);
        String key = config.value();
        return properties.getProperty(key);
    }

}
