package com.prodemy.viewmodel;

public class ViewModelMahasiswa {
    private String mhsnim;
    private String mhsnm;
    private String mhsaddr;
    private String prodnm;
    private String faknm;

    public ViewModelMahasiswa() {

    }

    public ViewModelMahasiswa(String mhsnim, String mhsnm, String mhsaddr, String prodnm, String faknm) {
        this.mhsnim = mhsnim;
        this.mhsnm = mhsnm;
        this.mhsaddr = mhsaddr;
        this.prodnm = prodnm;
        this.faknm = faknm;
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
