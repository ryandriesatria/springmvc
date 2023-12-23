package com.prodemy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.prodemy.dao.FakultasDao;
import com.prodemy.dao.MahasiswaDao;
import com.prodemy.dao.ProdiDao;
import com.prodemy.model.ModelMahasiswa;
import com.prodemy.model.ModelProdi;
import com.prodemy.viewmodel.ViewModelMahasiswa;

@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaDao mhsDao;

    @Autowired
    private ProdiDao prodiDao;

    public List<ViewModelMahasiswa> getAllMahasiswa() {

        return mhsDao.getAllMahasiswa();
    }

    public ViewModelMahasiswa getMahasiswaByNim(String nim) {

        return mhsDao.getMahasiswaByNim(nim);
    }

    public boolean deleteMahasiswaByNim(String nim) {
        return mhsDao.deleteMahasiswaByNim(nim);
    }

    public boolean addMahasiswa(String mhsnm, String mhsaddr, String prodnm) {

        ModelProdi prod = prodiDao.getProdByProdnm(prodnm);

        String prodkd = prod.getProdkd().substring(prod.getProdkd().length() - 3);

        String fakkd = prod.getFakkd().substring(prod.getFakkd().length() - 3);

        String lastNim = mhsDao.getLastMhsnmByProdkd(prod.getProdkd());

        String lastFourDigit;
        if (lastNim == null) {
            lastFourDigit = "0000";
        } else {
            lastFourDigit = lastNim.substring(lastNim.length() - 4);
        }

        String mhsnim = generateMhsnim(fakkd, prodkd, lastFourDigit);

        ModelMahasiswa mhs = new ModelMahasiswa(mhsnim, mhsnm, mhsaddr, prod.getProdkd());

        return mhsDao.addMahasiswa(mhs);
    }

    public boolean updateMahasiswa(String mhsnim, String mhsnm, String mhsaddr, String prodnm) {

        ViewModelMahasiswa mhs = mhsDao.getMahasiswaByNim(mhsnim);

        ModelProdi prod = prodiDao.getProdByProdnm(prodnm);

        String prodkd = prod.getProdkd().substring(prod.getProdkd().length() - 3);

        String fakkd = prod.getFakkd().substring(prod.getFakkd().length() - 3);

        String newMhsnim = mhsnim;

        if (!mhs.getProdnm().equals(prodnm)) {

            String lastNim = mhsDao.getLastMhsnmByProdkd(prod.getProdkd());

            String lastFourDigit;
            if (lastNim == null) {
                lastFourDigit = "0000";
            } else {
                lastFourDigit = lastNim.substring(lastNim.length() - 4);
            }

            newMhsnim = generateMhsnim(fakkd, prodkd, lastFourDigit);
        }

        ModelMahasiswa updatedMhs = new ModelMahasiswa(newMhsnim, mhsnm, mhsaddr, prod.getProdkd());

        return mhsDao.updateMahasiswa(mhsnim, updatedMhs);
    }

    private static String generateMhsnim(String fakkd, String prodkd, String lastFourDigit) {

        int lastDigit = Integer.parseInt(lastFourDigit);

        lastDigit++;

        lastFourDigit = String.format("%04d", lastDigit);

        String nim = fakkd + prodkd + lastFourDigit;

        return nim;
    }

}
