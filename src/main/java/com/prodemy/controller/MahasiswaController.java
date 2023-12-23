package com.prodemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.prodemy.service.MahasiswaService;
import com.prodemy.service.ProdiService;
import com.prodemy.viewmodel.ViewModelFakultas;
import com.prodemy.viewmodel.ViewModelMahasiswa;

@Controller
// @RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mhsService;
    @Autowired
    private ProdiService prodService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        List<ViewModelMahasiswa> mhs = mhsService.getAllMahasiswa();

        mv.setViewName("indexMahasiswa");
        mv.addObject("mahasiswa", mhs);

        return mv;
    }

    @RequestMapping("/{nim}")
    public ModelAndView indexByNim(@PathVariable String nim) {
        ModelAndView mv = new ModelAndView();

        ViewModelMahasiswa mhs = mhsService.getMahasiswaByNim(nim);

        if (mhs == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find Mahasiswa");
        }

        mv.setViewName("indexMahasiswaByNim");
        mv.addObject("mhs", mhs);
        return mv;

    }

    @RequestMapping("/{nim}/delete")
    public ModelAndView deleteByNim(@PathVariable String nim) {

        boolean isDeleted = mhsService.deleteMahasiswaByNim(nim);

        if (!isDeleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to delete Mahasiswa with NIM :" + nim);
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/addMahasiswa")
    public ModelAndView viewAddMahasiswa() {
        ModelAndView mv = new ModelAndView();

        List<ViewModelFakultas> fak = prodService.getAllProdiNameGroupedByFakultasName();
        mv.addObject("fakultas", fak);
        mv.setViewName("addMahasiswa");

        return mv;
    }

    @RequestMapping(value = "/addMahasiswa", method = RequestMethod.POST)
    public ModelAndView addMahasiswa(@RequestParam("mhsnm") String mhsnm, @RequestParam("mhsaddr") String mhsaddr,
            @RequestParam("prodnm") String prodnm) {

        boolean isAdded = mhsService.addMahasiswa(mhsnm, mhsaddr, prodnm);

        if (!isAdded) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to create Mahasiswa");
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/{nim}/update")
    public ModelAndView viewUpdateMahasiswa(@PathVariable String nim) {

        ModelAndView mv = new ModelAndView();

        List<ViewModelFakultas> fak = prodService.getAllProdiNameGroupedByFakultasName();
        ViewModelMahasiswa mhs = mhsService.getMahasiswaByNim(nim);
        mv.addObject("mhs", mhs);
        mv.addObject("fakultas", fak);
        mv.setViewName("updateMahasiswa");

        return mv;
    }

    @RequestMapping(value = "/{nim}/update", method = RequestMethod.POST)
    public ModelAndView updateMahasiswa(@PathVariable String nim, @RequestParam("mhsnim") String mhsnim,
            @RequestParam("mhsnm") String mhsnm, @RequestParam("mhsaddr") String mhsaddr,
            @RequestParam("prodnm") String prodnm) {

        boolean isUpdated = mhsService.updateMahasiswa(mhsnim, mhsnm, mhsaddr, prodnm);

        if (!isUpdated) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to update Mahasiswa");
        }

        return new ModelAndView("redirect:/");
    }
}
