package com.prodemy.viewmodel;

public class ViewModelProdi {
    String prodkd;
    String prodnm;
    String faknm;

    public ViewModelProdi() {
    }

    public ViewModelProdi(String prodkd, String prodnm, String faknm) {
        this.prodkd = prodkd;
        this.prodnm = prodnm;
        this.faknm = faknm;
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

    public String getFaknm() {
        return faknm;
    }

    public void setFaknm(String faknm) {
        this.faknm = faknm;
    }
}
