package com.amu.project_back.controllers;

import com.amu.project_back.models.LisEquipe;
import com.amu.project_back.repository.LisEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class LisEquipeController {

    @Autowired
    LisEquipeRepository repo;


    @GetMapping("/equipes")
    public Iterable<LisEquipe> getTeams(){
        return repo.findAll();
    }

    @GetMapping("/equipes/{id}")
    public LisEquipe getTeam(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    }


}
