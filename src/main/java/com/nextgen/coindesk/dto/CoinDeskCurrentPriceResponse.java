package com.nextgen.coindesk.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Map;

public class CoinDeskCurrentPriceResponse {
    private Time time;
    private String disclaimer;
    private String chartName;
    private Map<String, Currency> bpi;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Map<String, Currency> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Currency> bpi) {
        this.bpi = bpi;
    }

    public static class Time {
        @JsonFormat(pattern = "MMMM d, yyyy HH:mm:ss z", locale = "en_US", timezone = "UTC")
        private ZonedDateTime updated;
        private String updatedISO;
        private String updateduk;

        public ZonedDateTime getUpdated() {
            return updated;
        }

        public void setUpdated(ZonedDateTime updated) {
            this.updated = updated;
        }

        public String getUpdatedISO() {
            return updatedISO;
        }

        public void setUpdatedISO(String updatedISO) {
            this.updatedISO = updatedISO;
        }

        public String getUpdateduk() {
            return updateduk;
        }

        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }
    }

    public static class Currency {
        private String code;
        private String symbol;
        private String rate;

        @JsonAlias("description")
        private String currencyDescription;

        @JsonProperty("rate_float")
        private double rateFloat;

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

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getCurrencyDescription() {
            return currencyDescription;
        }

        public void setCurrencyDescription(String currencyDescription) {
            this.currencyDescription = currencyDescription;
        }

        public double getRateFloat() {
            return rateFloat;
        }

        public void setRateFloat(double rateFloat) {
            this.rateFloat = rateFloat;
        }
    }
}
