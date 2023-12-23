package com.prodemy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodemy.dao.ProdiDao;
import com.prodemy.viewmodel.ViewModelFakultas;
import com.prodemy.viewmodel.ViewModelProdi;

@Service
public class ProdiService {

    @Autowired
    private ProdiDao prodiDao;

    public List<String> getAllProdiName() {

        List<ViewModelProdi> prod = prodiDao.getAllProdi();
        return prod.stream().map(ViewModelProdi::getProdnm).toList();
    }

    public List<ViewModelFakultas> getAllProdiNameGroupedByFakultasName() {
        List<ViewModelFakultas> fak = new ArrayList<>();
        List<ViewModelProdi> prod = prodiDao.getAllProdi();

        for (ViewModelProdi obj : prod) {
            if (!fak.stream().anyMatch(x -> x.getFaknm().equals(obj.getFaknm()))) {
                fak.add(new ViewModelFakultas(obj.getFaknm(),
                        Arrays.asList(new ViewModelProdi(obj.getProdkd(), obj.getProdnm(), obj.getFaknm()))));
            } else {
                ViewModelFakultas newFak = fak.stream().filter(x -> x.getFaknm().equals(obj.getFaknm()))
                        .collect(Collectors.toList()).get(0);
                List<ViewModelProdi> newProdi = new ArrayList<>(newFak.getProdi());

                newProdi.add(obj);
                newFak.setProdi(newProdi);
            }
        }

        return fak;
    }

}
