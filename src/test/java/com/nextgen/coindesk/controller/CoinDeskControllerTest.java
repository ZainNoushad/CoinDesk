package com.nextgen.coindesk.controller;


import com.nextgen.coindesk.service.CoinDeskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class CoinDeskControllerTest {
    @Mock
    private CoinDeskService coinDeskService;

    @InjectMocks
    private CoinDeskController coinDeskController;

    @Test
    void testSaveCurrentPrice() {
        doNothing().when(coinDeskService).persistCurrentPriceToDB();

        ResponseEntity<String> response = coinDeskController.saveCurrentPrice();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("data saved successfully", response.getBody());
    }

}
