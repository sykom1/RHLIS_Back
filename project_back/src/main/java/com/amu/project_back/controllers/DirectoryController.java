package com.amu.project_back.controllers;

import com.amu.project_back.models.Directory;
import com.amu.project_back.repository.DirectoryRepository;
import com.amu.project_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class DirectoryController {


    @Autowired
    DirectoryRepository repo;


    @GetMapping(value = "/directories")
    public Iterable<Directory> getDirectory() {
        return repo.findAll();
    }


    //@GetMapping(value = "/directories/{id}")
    /*public Directory getDirectory(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    } */


    @PutMapping(value = "/directories/{id}")
    public Directory modifyDirectory(@PathVariable Integer id, @RequestBody Directory newDirectory) {
        Directory oldDirectory = repo.findById(Long.valueOf(id)).get();
        oldDirectory.setDirectory(newDirectory);
        return repo.save(oldDirectory);
    }



    @PostMapping(value = "/directories")
    public Directory saveDirectory(@RequestBody Directory Directory) {

        return repo.save(Directory);
    }


    @GetMapping("/directories/{id}")
    public Directory getDirectoryById(@PathVariable Long id) {
        return repo.findById(id).get();
    }



    @DeleteMapping("/directories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDirectory(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
