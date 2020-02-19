package com.tvh.bootcamp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("employee-application")
public class MessageConfiguration {
    private String welcomeMessage;
    private String description;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(final String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
