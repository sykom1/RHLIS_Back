package com.amu.project_back.models;

import com.amu.project_back.models.enume.Civ;
import com.amu.project_back.models.enume.LisStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnuaireEquipeBit {
	
	private Long id ;
    private String name;
    private Civ civ;
    private String email;
    private String phone;
    private String equipe;
    private LisStatus statut;
    private String arrive;
    private String leave;
    private Long userId;

}
