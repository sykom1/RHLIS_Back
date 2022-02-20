package com.amu.project_back.models;

import com.amu.project_back.models.enume.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "annuaire")
@Data
public class Directory {

    @Id
    @GeneratedValue
    @Column(name = "ann_id")
    private long id;

    @Column(name= "ann_ldap_uid")
    private String ildapId;

    // ou ID
    @Column(name= "ann_lis_pays_id")
    private transient Country country;

    @Column(name= "ann_nom")
    @NotBlank(message = "Le nom est obligatoire !")
    private String lastname;

    @Column(name= "ann_prenom")
    @NotBlank(message = "Le prenom est obligatoire !")
    private String firstname;

    @Column(name= "ann_naissance")
    private Date birthday;

    @Column(name= "ann_tel_perso")
    @Pattern(regexp="(^$|[0-9]{10})",message = "le numéro de téléphone doit contenir 10 chiffres")
    @NotBlank(message = "Le numero de telephone est obligatoire !")
    private String phoneNumber;

    @Column(name= "ann_courriel")
    private String email;

    @Column(name= "ann_courriel2")
    private String email2;

    @Column(name= "ann_courriel_perso")
    private String privateEmail;

    @Column(name= "ann_lis_tutelles")
    private Guardianship guardianship;

    @Column(name= "ann_lis_composantes")
    private Component component;

    @Column(name= "ann_lis_sites")
    private Site site;

    @Column(name= "ann_lis_etat")
    private State lisState;

    @Column(name= "ann_etat")
    private int state;

    @Column(name= "ann_quotite_travail")
    private int amountWork;

    @Column(name= "ann_hdr")
    private int hdr;

    @Column(name= "ann_hdr_date")
    private Date hdrDate;

    @Column(name= "ann_emerite")
    private int emerite;

    @Column(name= "ann_emerite_date")
    private Date emeriteDate;

    @Column(name= "ann_adr_pro")
    private String ProAddress;

    @Column(name= "ann_adr_perso")
    private String persoAddress;

    @Column(name= "ann_section_cnu")
    private int cnu;

    @Column(name= "ann_section_cnrs")
    private int cnrs;

    // ou ID
    @Column(name= "ann_lis_bat_id")
    private transient Building building;

    @Column(name= "ann_civ")
    private Civ civ;

    @Column(name= "section_cnu")
    private Cnu sectionCnu;

    @Column(name= "section_cnrs")
    private Cnrs sectionCnrs;

    @Column(name= "referent")
    private String referent;

    @Column(name= "referent_courriel")
    private String RefEmail;

    @Column(name= "type")
    private AnnType type;

    @Column(name= "remarque")
    private String remarks;

    @Column(name= "titulaire")
    private int titulaire;

    @Column(name= "ann_comp_gen_url")
    private String url;

    @Column(name= "ann_comp_gen_hal")
    private String hal;

    @Column(name= "ann_comp_gen_photo")
    private String photo;

    @Column(name= "ann_comp_gen_diffusion")
    private int diff;

    @Column(name= "ann_comp_gen_reseda")
    private String reseda;

    @Column(name= "ann_comp_gen_orcid")
    private String orcid;

    @Column(name= "ann_comp_gen_lk")
    private String lk;

    @Column(name= "droits")
    private UserRole role;

    // ou ID
    @Column(name= "annuaire_diplome_ann_diplome_id")
    private transient Diploma diploma;




    public void setDirectory(Directory directory){

    }


}
