package com.amu.project_back.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

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

    private String password;

    @Column(name = "uti_banni")
    private boolean banned;


    private UserRole role;

    @NotBlank(message = "Le nom est obligatoire !")
    private String lastname;


    @NotBlank(message = "Le prenom est obligatoire !")
    private String firstname;

    private Date birthday;

    @Pattern(regexp="(^$|[0-9]{10})",message = "le numéro de téléphone doit contenir 10 chiffres")
    @NotBlank(message = "Le numero de telephone est obligatoire !")
    private String phoneNumber;

    @OneToOne
    private Directory directory;



    public void setUser(User user){
        this.id = user.id;
        this.email = user.email;
        this.password = user.password;
        this.banned = user.banned;
        this.role = user.role;
    }



}
