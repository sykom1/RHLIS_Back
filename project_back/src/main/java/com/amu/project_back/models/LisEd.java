package com.amu.project_back.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lis_ed database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="lis_ed")
@NamedQuery(name="LisEd.findAll", query="SELECT l FROM LisEd l")
public class LisEd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lis_ed_id")
	private String lisEdId;

	@Column(name="lis_ed_code_etablissement")
	private String lisEdCodeEtablissement;

	@Column(name="lis_ed_etablissement")
	private String lisEdEtablissement;

	@Column(name="lis_ed_libelle")
	private String lisEdLibelle;

	@Column(name="lis_ed_numero")
	private int lisEdNumero;

	@Column(name="lis_ed_sigle")
	private String lisEdSigle;

	//bi-directional many-to-one association to AnnuaireComplementDoctorant
	@OneToMany(mappedBy="lisEd")
	private List<AnnuaireComplementDoctorant> annuaireComplementDoctorants;



}