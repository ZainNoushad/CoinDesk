package com.nextgen.coindesk.rest;

import com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CoinDeskRestClient {

    @Autowired
    @Qualifier("coinDeskWebClient")
    private WebClient coinDeskWebClient;

    @Value("${coindesk.bpi.currentprice.base.path}")
    private String coinDeskBasePath;

    public CoinDeskCurrentPriceResponse getCurrentBPI(){
        return coinDeskWebClient
                .get()
                .uri(coinDeskBasePath)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> Mono.just(new Exception("An Error Occurred Getting BPI")))
                .bodyToMono(CoinDeskCurrentPriceResponse.class)
                .block();
    }

}
