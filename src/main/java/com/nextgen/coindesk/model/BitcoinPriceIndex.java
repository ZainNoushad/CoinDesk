package com.nextgen.coindesk.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "bitcoin_price_index")
public class BitcoinPriceIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String disclaimer;

    @Column(name = "chart_name")
    private String chartName;

    @Column
    private ZonedDateTime updated;

    @OneToMany(mappedBy = "bitcoinPriceIndex", cascade = CascadeType.ALL)
    private List<BpiRate> bpiRates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ZonedDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(ZonedDateTime updated) {
        this.updated = updated;
    }

    public List<BpiRate> getBpiRates() {
        return bpiRates;
    }

    public void setBpiRates(List<BpiRate> bpiRates) {
        this.bpiRates = bpiRates;
    }
}