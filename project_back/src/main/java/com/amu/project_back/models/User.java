package com.amu.project_back.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "utilisateurs")
@Data
public class User {

    @Id
    @GeneratedValue
    @Column(name = "uti_id")
    private long id;

    @Column(name = "uti_login")
    @NotBlank(message = "L'email est obligatoire !")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire !")
    @Column(name= "uti_pass")
    private String password;

    @Column(name = "uti_banni")
    private boolean banned;

    @Column(name = "uti_role")
    private UserRole role;


    public void setUser(User user){
        this.id = user.id;
        this.email = user.email;
        this.password = user.password;
        this.banned = user.banned;
        this.role = user.role;
    }



}
