package com.prodemy.viewmodel;

import java.util.List;

public class ViewModelFakultas {
    String faknm;
    List<ViewModelProdi> prodi;

    public ViewModelFakultas() {
    }

    public ViewModelFakultas(String faknm, List<ViewModelProdi> prodi) {
        this.faknm = faknm;
        this.prodi = prodi;
    }

    public String getFaknm() {
        return faknm;
    }

    public void setFaknm(String faknm) {
        this.faknm = faknm;
    }

    public List<ViewModelProdi> getProdi() {
        return prodi;
    }

    public void setProdi(List<ViewModelProdi> prodi) {
        this.prodi = prodi;
    }

    public void setSingleProdi(ViewModelProdi prod) {
        this.prodi.add(prod);
    }

}
