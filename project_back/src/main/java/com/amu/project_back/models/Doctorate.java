package com.amu.project_back.models;

import com.amu.project_back.models.enume.ContractType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "annuaire_complement_doctorant")
@Data
public class Doctorate {

    @Id
    @GeneratedValue
    @Column(name = "ann_comp_doc_id")
    private long id;

    //ou ID
    @OneToOne
    @JoinColumn(name = "ann_comp_doc_ann_id")
    private transient Annuary annuary;

    @Column(name = "ann_comp_doc_titre_these    ")
    private String thesisTitle;

    @Column(name = "ann_comp_doc_sujet")
    private String subject;

    @Column(name = "ann_comp_doc_dir_these_lis")
    private long lisThesis;

    @Column(name = "ann_comp_doc_dir_these_nlis")
    private String nlisThesis;

    @Column(name = "ann_comp_doc_codir_these_lis")
    private int codeLisThesis;

    @Column(name = "ann_comp_doc_codir_these_nlis")
    private String codeNlisThesis;

    @Column(name = "type_contrat")
    private ContractType type;

    @OneToOne
    @JoinColumn(name = "lis_ed_lis_ed_id")
    // Ou ID
    private transient Institution institution;



}
