package com.nextgen.coindesk.rest;

import com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CoinDeskRestClientTest {

    @Mock
    private WebClient.Builder webClientBuilder;
    @Mock
    private WebClient webClient;
    @Mock
    private WebClient.ResponseSpec responseSpec;
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    @InjectMocks
    private CoinDeskRestClient coinDeskRestClient;
    private static final String BPI_API_URL = "/v1/currentprice.json";

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(coinDeskRestClient, "coinDeskBasePath", BPI_API_URL);
    }

    @Test
    void testGetCurrentBPISuccess() {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.accept(MediaType.APPLICATION_JSON)).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(CoinDeskCurrentPriceResponse.class)).thenReturn(Mono.just(new CoinDeskCurrentPriceResponse()));
        CoinDeskCurrentPriceResponse actualResponse = coinDeskRestClient.getCurrentBPI();

    }
    @Test
    public void testGetCurrentBPIFailure() {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.accept(MediaType.APPLICATION_JSON)).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(CoinDeskCurrentPriceResponse.class)).thenReturn(Mono.error(new RuntimeException("Error occurred")));
        assertThrows(RuntimeException.class, () -> coinDeskRestClient.getCurrentBPI());
    }
}
