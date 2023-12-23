package com.prodemy.model;

public class ModelMahasiswa {
    private String mhsnim;
    private String mhsnm;
    private String mhsaddr;
    private String prodkd;

    public ModelMahasiswa() {
    }

    public ModelMahasiswa(String mhsnim, String mhsnm, String mhsaddr, String prodkd) {
        this.mhsnim = mhsnim;
        this.mhsnm = mhsnm;
        this.mhsaddr = mhsaddr;
        this.prodkd = prodkd;
    }

    public String getMhsnim() {
        return mhsnim;
    }

    public void setMhsnim(String mhsnim) {
        this.mhsnim = mhsnim;
    }

    public String getMhsnm() {
        return mhsnm;
    }

    public void setMhsnm(String mhsnm) {
        this.mhsnm = mhsnm;
    }

    public String getMhsaddr() {
        return mhsaddr;
    }

    public void setMhsaddr(String mhsaddr) {
        this.mhsaddr = mhsaddr;
    }

    public String getProdkd() {
        return prodkd;
    }

    public void setProdkd(String prodkd) {
        this.prodkd = prodkd;
    }
}
