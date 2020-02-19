package com.tvh.bootcamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public MessageConfiguration createMessageConfiguration() {
        MessageConfiguration messageConfiguration = new MessageConfiguration();
        messageConfiguration.setWelcomeMessage("Welcome to the employee application from Java config");
        messageConfiguration.setDescription("This is a demo for the spring bootcamp");
        return messageConfiguration;
    }
}
