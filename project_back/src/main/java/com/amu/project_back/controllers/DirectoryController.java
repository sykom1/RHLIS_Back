package com.amu.project_back.controllers;

import com.amu.project_back.dto.AnnuaireDTO;
import com.amu.project_back.models.*;
import com.amu.project_back.models.enume.UserRole;
import com.amu.project_back.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@RestController
@RequestMapping("/api")
public class DirectoryController {


    @Autowired
    DirectoryRepository repo;

    @Autowired
    UserRepository userrepo;

    @Autowired
    LisPoleRepository polerepo;

    @Autowired
    AnnuaireEquipeRepository annrepo;

    @Autowired
    LisEquipeRepository eqrepo;




    @GetMapping(value = "/directories")
    public Iterable<Annuaire> getAnnuaire() {
        return repo.findAll();
    }



    @GetMapping("/directories/{id}")
    public Annuaire getAnnuaireById(@PathVariable Long id) {
        return repo.findById(id).get();
    }



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
        annuaire.getUser().setIsnew(false);
        return repo.save(annuaire);
    }

    @GetMapping("/search")
    public Iterable<Annuaire> getUsersBy(@PathParam("type") String type, @PathParam("name") String name ) {
        System.out.println(name);
        switch (type){

            case "role" : {
                return repo.findAllByUser_RoleLike(UserRole.valueOf(name.toUpperCase()));

            }
            case "datea" : {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.FRENCH);
                LocalDate localdate = LocalDate.parse(name, formatter);
                java.sql.Date date =  java.sql.Date.valueOf(localdate);
                return repo.findAllByDateA(date);
            }
            case "dated" : {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.FRENCH);
                LocalDate localdate = LocalDate.parse(name, formatter);
                java.sql.Date date =  java.sql.Date.valueOf(localdate);
                return repo.findAllByDateD(date);
            }
            case "team" : {
                return repo.findAllByAnnuaireEquipes_Label(name);

            }
            case "pole" : {
               return repo.findAllByAnnuairePole(name);
            }
            case "status" :{
                return repo.findAllByStatus(name);
            }
            default:
                return null;
        }

    }



    @DeleteMapping("/directories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAnnuaire(@PathVariable Long id) {
        repo.deleteById(id);
    }


}
