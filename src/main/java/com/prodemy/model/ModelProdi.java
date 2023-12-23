package com.prodemy.model;

public class ModelProdi {
    String prodkd;
    String prodnm;
    String fakkd;

    public ModelProdi(String prodkd, String prodnm, String fakkd) {
        this.prodkd = prodkd;
        this.prodnm = prodnm;
        this.fakkd = fakkd;
    }

    public String getProdkd() {
        return prodkd;
    }

    public void setProdkd(String prodkd) {
        this.prodkd = prodkd;
    }

    public String getProdnm() {
        return prodnm;
    }

    public void setProdnm(String prodnm) {
        this.prodnm = prodnm;
    }

    public String getFakkd() {
        return fakkd;
    }

    public void setFakkd(String fakkd) {
        this.fakkd = fakkd;
    }
}
