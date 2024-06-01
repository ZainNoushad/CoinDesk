package com.nextgen.coindesk.service.impl;

import com.nextgen.coindesk.dto.CoinDeskCurrentPriceResponse;
import com.nextgen.coindesk.helper.EntityDTOMapper;
import com.nextgen.coindesk.repository.BitcoinPriceIndexRepository;
import com.nextgen.coindesk.rest.CoinDeskRestClient;
import com.nextgen.coindesk.service.CoinDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinDeskServiceImpl implements CoinDeskService {

    @Autowired
    private CoinDeskRestClient coinDeskRestClient;

    @Autowired
    private BitcoinPriceIndexRepository bitcoinPriceIndexRepository;

    @Override
    public void persistCurrentPriceToDB() {
        CoinDeskCurrentPriceResponse currentBPI = coinDeskRestClient.getCurrentBPI();
        bitcoinPriceIndexRepository.save(EntityDTOMapper.mapCoinDeskResponseToBPIEntity(currentBPI));
    }
}
