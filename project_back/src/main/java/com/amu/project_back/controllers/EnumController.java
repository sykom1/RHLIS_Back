package com.amu.project_back.controllers;

import com.amu.project_back.models.enume.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/enum")
public class EnumController {




    @GetMapping(value = "/cnu")
    public ResponseEntity<?> getCnu(){

        return ResponseEntity.ok(Arrays.asList(Cnu.values()));
    }
    @GetMapping(value = "/cnrs")
    public ResponseEntity<?> getCnrs(){

        return ResponseEntity.ok(Arrays.asList(Cnrs.values()));
    }

    @GetMapping(value = "/component")
    public ResponseEntity<?> getComp(){

        return ResponseEntity.ok(Arrays.asList(Component.values()));
    }

    @GetMapping(value = "/contract")
    public ResponseEntity<?> getContract(){

        return ResponseEntity.ok(Arrays.asList(ContractType.values()));
    }

    @GetMapping(value = "/diploma")
    public ResponseEntity<?> getDiploma(){

        return ResponseEntity.ok(Arrays.asList(LisDiploma.values()));
    }

    @GetMapping(value = "/status")
    public ResponseEntity<?> getStatus(){

        return ResponseEntity.ok(Arrays.asList(LisStatus.values()));
    }

    @GetMapping(value = "/state")
    public ResponseEntity<?> getState(){

        return ResponseEntity.ok(Arrays.asList(State.values()));
    }

    @GetMapping(value = "/tutelles")
    public ResponseEntity<?> getTutelles(){

        return ResponseEntity.ok(Arrays.asList(Tutelles.values()));
    }


    @GetMapping(value = "/finance")
    public ResponseEntity<?> getFinance(){

        return ResponseEntity.ok(Arrays.asList(TypeFinance.values()));
    }

}
