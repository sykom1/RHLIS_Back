package com.amu.project_back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amu.project_back.models.LisPay;
import com.amu.project_back.repository.LisPaysRepository;

@RequestMapping("/api")
@RestController
public class LisPaysController {
	
	@Autowired
    LisPaysRepository repo;



    @GetMapping("/pays")
    public Iterable<LisPay> getPoles(){
       return repo.findAll();
    }

}
