package com.amu.project_back.controllers;

import com.amu.project_back.models.LisPole;
import com.amu.project_back.repository.LisPoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class LisPoleController {

    @Autowired
    LisPoleRepository repo;



    @GetMapping("/poles")
    public Iterable<LisPole> getPoles(){
       return repo.findAll();
    }

    @GetMapping("/poles/{id}")
    public LisPole getPole(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    }
}
