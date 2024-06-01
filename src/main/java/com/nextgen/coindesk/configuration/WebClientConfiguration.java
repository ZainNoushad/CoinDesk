package com.nextgen.coindesk.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${coindesk.service.host}")
    private String coinDeskServiceHost;

    @Bean
    @Qualifier("coinDeskWebClient")
    public WebClient coinDeskWebClient() {
        return WebClient
                .builder()
                .baseUrl(coinDeskServiceHost)
                .build();
    }
}
