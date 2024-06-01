package com.nextgen.coindesk.service;

import com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse;
import com.nextgen.coindesk.helper.EntityDTOMapper;
import com.nextgen.coindesk.model.BitcoinPriceIndex;
import com.nextgen.coindesk.repository.BitcoinPriceIndexRepository;
import com.nextgen.coindesk.rest.CoinDeskRestClient;
import com.nextgen.coindesk.service.impl.CoinDeskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse.Currency;
import static com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse.Time;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoinDeskServiceTest {

    @Mock
    private CoinDeskRestClient coinDeskRestClient;

    @Mock
    private BitcoinPriceIndexRepository bitcoinPriceIndexRepository;

    @InjectMocks
    private CoinDeskServiceImpl coinDeskService;

    @Test
    void testPersistCurrentPriceToDB() {
        when(coinDeskRestClient.getCurrentBPI()).thenReturn(createDummyData());
        when(bitcoinPriceIndexRepository.save(any())).thenReturn(new BitcoinPriceIndex());
        coinDeskService.persistCurrentPriceToDB();
    }

    private CoinDeskCurrentPriceResponse createDummyData() {
        CoinDeskCurrentPriceResponse response = new CoinDeskCurrentPriceResponse();

        Time time = new Time();
        time.setUpdated(ZonedDateTime.now());
        time.setUpdatedISO("2024-06-01T13:44:19+00:00");
        time.setUpdateduk("Jun 1, 2024 at 14:44 BST");
        response.setTime(time);

        response.setDisclaimer("This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org");
        response.setChartName("Bitcoin");

        Map<String, Currency> bpi = new HashMap<>();
        bpi.put("USD", createCurrency("USD", "&#36;", "67,767.108", "United States Dollar", 67767.1081));
        bpi.put("GBP", createCurrency("GBP", "&pound;", "53,204.905", "British Pound Sterling", 53204.9053));
        bpi.put("EUR", createCurrency("EUR", "&euro;", "62,420.758", "Euro", 62420.7577));

        response.setBpi(bpi);

        return response;
    }

    private Currency createCurrency(String code, String symbol, String rate, String description, double rateFloat) {
        Currency currency = new Currency();
        currency.setCode(code);
        currency.setSymbol(symbol);
        currency.setRate(rate);
        currency.setCurrencyDescription(description);
        currency.setRateFloat(rateFloat);
        return currency;
    }

}
