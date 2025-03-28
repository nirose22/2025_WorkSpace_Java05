package com.example2;

public enum Branch {
    Taipei("NT$"), London("£"), Tokyo("¥"), NewYork("$");

    private String currency;

    Branch(String currency) {
        this.currency = currency;
    }
    public String getCurrency() {
        return currency;
    }
}
