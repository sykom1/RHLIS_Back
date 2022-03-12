package com.amu.project_back.controllers;

import com.amu.project_back.dto.AnnuaireDTO;
import com.amu.project_back.models.Annuaire;
import com.amu.project_back.repository.DirectoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class DirectoryController {


    @Autowired
    DirectoryRepository repo;


    @GetMapping(value = "/directories")
    public Iterable<Annuaire> getAnnuaire() {
        return repo.findAll();
    }


    //@GetMapping(value = "/directories/{id}")
    /*public Annuaire getAnnuaire(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    } */


    @PutMapping(value = "/directories/{id}")
    public Annuaire modifyAnnuaire(@PathVariable Integer id, @RequestBody AnnuaireDTO annuaireDTO) {
        ModelMapper mapper = new ModelMapper();
        Annuaire newAnnuaire = mapper.map(annuaireDTO, Annuaire.class);
        Annuaire oldAnnuaire = repo.findById(Long.valueOf(id)).get();
        oldAnnuaire.setAnnuaire(newAnnuaire);
        return repo.save(oldAnnuaire);
    }



    @PostMapping(value = "/directories")
    public Annuaire saveAnnuaire(@RequestBody AnnuaireDTO annuaireDTO) {
        ModelMapper mapper = new ModelMapper();
        Annuaire annuaire = mapper.map(annuaireDTO, Annuaire.class);
        return repo.save(annuaire);
    }


    @GetMapping("/directories/{id}")
    public Annuaire getAnnuaireById(@PathVariable Long id) {
        return repo.findById(id).get();
    }



    @DeleteMapping("/directories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAnnuaire(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
