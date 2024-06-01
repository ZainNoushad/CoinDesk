package com.nextgen.coindesk.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bpi_rates")
public class BpiRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bpi_id", referencedColumnName = "id")
    private BitcoinPriceIndex bitcoinPriceIndex;

    @Column
    private String code;

    @Column
    private String symbol;

    @Column(name = "rate_str")
    private String rateStr;

    @Column
    private String description;

    @Column
    private Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BitcoinPriceIndex getBitcoinPriceIndex() {
        return bitcoinPriceIndex;
    }

    public void setBitcoinPriceIndex(BitcoinPriceIndex bitcoinPriceIndex) {
        this.bitcoinPriceIndex = bitcoinPriceIndex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRateStr() {
        return rateStr;
    }

    public void setRateStr(String rateStr) {
        this.rateStr = rateStr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
