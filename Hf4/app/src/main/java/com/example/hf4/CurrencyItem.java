package com.example.hf4;

public class CurrencyItem {
    private String code;
    private String name;
    private String country;
    private int flagResId;
    private double buyRate;
    private double sellRate;

    public CurrencyItem(String code, String name, String country, int flagResId, double buyRate, double sellRate) {
        this.code = code;
        this.name = name;
        this.country = country;
        this.flagResId = flagResId;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getFlagResId() {
        return flagResId;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }
}