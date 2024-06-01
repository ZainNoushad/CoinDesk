package com.nextgen.coindesk.helper;

import com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse;
import com.nextgen.coindesk.model.BitcoinPriceIndex;
import com.nextgen.coindesk.model.BpiRate;

import java.util.List;
import java.util.stream.Collectors;

import static com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse.Currency;

public class EntityDTOMapper {

    public static BitcoinPriceIndex mapCoinDeskResponseToBPIEntity(CoinDeskCurrentPriceResponse coinDeskCurrentPriceResponse) {
        BitcoinPriceIndex bitcoinPriceIndex = new BitcoinPriceIndex();
        bitcoinPriceIndex.setDisclaimer(coinDeskCurrentPriceResponse.getDisclaimer());
        bitcoinPriceIndex.setChartName(coinDeskCurrentPriceResponse.getChartName());
        bitcoinPriceIndex.setUpdated(coinDeskCurrentPriceResponse.getTime().getUpdated());

        List<BpiRate> bpiRates = coinDeskCurrentPriceResponse.getBpi().entrySet().stream().map(currencyRates -> {
            Currency rate = currencyRates.getValue();

            BpiRate bpiRate = new BpiRate();
            bpiRate.setCode(rate.getCode());
            bpiRate.setDescription(rate.getCurrencyDescription());
            bpiRate.setRateStr(rate.getRate());
            bpiRate.setRate(rate.getRateFloat());
            bpiRate.setSymbol(rate.getSymbol());
            bpiRate.setBitcoinPriceIndex(bitcoinPriceIndex);
            return bpiRate;
        }).collect(Collectors.toList());

        bitcoinPriceIndex.setBpiRates(bpiRates);

        return bitcoinPriceIndex;
    }
}
