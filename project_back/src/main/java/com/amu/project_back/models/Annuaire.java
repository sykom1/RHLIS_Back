package com.amu.project_back.models;

import com.amu.project_back.models.enume.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the annuaire database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@NamedQuery(name="Annuaire.findAll", query="SELECT a FROM Annuaire a")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "annId")
public class Annuaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ann_id")
	private Long annId;

	@Lob
	@Column(name="ann_adr_perso")
	private String annAdrPerso;

	@Lob
	@Column(name="ann_adr_pro")
	private String annAdrPro;

	@Column(name="ann_civ")
	@Enumerated(EnumType.STRING)
	private Civ annCiv;

	@Column(name="ann_comp_gen_hal")
	private String annCompGenHal;

	@Column(name="ann_comp_gen_lk")
	private String annCompGenLk;

	@Column(name="ann_comp_gen_url")
	private String annCompGenUrl;

	@Column(name="ann_courriel")
	private String annCourriel;

	@Column(name="ann_courriel_perso")
	private String annCourrielPerso;

	@Column(name="ann_courriel2")
	private String annCourriel2;

	@Column(name="ann_hdr")
	private byte annHdr;

	@Column(name="ann_ldap_uid")
	private String annLdapUid;

	@Column(name="ann_lis_composantes")
	@Enumerated(EnumType.STRING)
	private Component annLisComposantes;

	@Column(name="ann_lis_etat")
	@Enumerated(EnumType.STRING)
	private State annLisEtat;

	@Column(name="ann_lis_sites")
	@Enumerated(EnumType.STRING)
	private Site annLisSites;

	@Column(name="ann_lis_tutelles")
	@Enumerated(EnumType.STRING)
	private Tutelles annLisTutelles;

	@Column(name="ann_quotite_travail")
	private byte annQuotiteTravail;

	@Column(name="ann_section_cnrs")
	@Enumerated(EnumType.STRING)
	private Cnrs annSectionCnrs;

	@Column(name="ann_section_cnu")
	@Enumerated(EnumType.STRING)
	private Cnu annSectionCnu;

	@Column(name="ann_tel_perso")
	private String annTelPerso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "referent")
	private Annuaire referent;

	@OneToMany(mappedBy = "referent")
	private List<Annuaire> personnels;

	private int titulaire;

	//bi-directional many-to-one association to LisBatiment
	@ManyToOne
	@JoinColumn(name="ann_lis_bat_id")
	private LisBatiment lisBatiment;

	//bi-directional many-to-one association to LisPay
	@ManyToOne
	@JoinColumn(name="ann_lis_pays_id")
	private LisPay lisPay;



	//bi-directional many-to-one association to AnnuaireEquipe
	@JsonIgnore
	@OneToMany(mappedBy="annuaire")
	private List<AnnuaireEquipe> annuaireEquipes;

	//bi-directional many-to-many association to LisComite
	@ManyToMany(mappedBy="annuaires")
	private List<LisComite> lisComites;



	@OneToOne
	private Utilisateur user;


	public void setAnnuaire(Annuaire annuaire) {
		this.annId = annuaire.annId;
		this.annAdrPerso = annuaire.annAdrPerso;
		this.annAdrPro = annuaire.annAdrPro;
		this.annCiv = annuaire.annCiv;
		this.annCompGenHal = annuaire.annCompGenHal;
		this.annCompGenLk = annuaire.annCompGenLk;
		this.annCompGenUrl = annuaire.annCompGenUrl;
		this.annCourriel = annuaire.annCourriel;
		this.annCourrielPerso = annuaire.annCourrielPerso;
		this.annCourriel2 = annuaire.annCourriel2;
		this.annHdr = annuaire.annHdr;
		this.annLdapUid = annuaire.annLdapUid;
		this.annLisComposantes = annuaire.annLisComposantes;
		this.annLisEtat = annuaire.annLisEtat;
		this.annLisSites = annuaire.annLisSites;
		this.annLisTutelles = annuaire.annLisTutelles;
		this.annQuotiteTravail = annuaire.annQuotiteTravail;
		this.annSectionCnrs = annuaire.annSectionCnrs;
		this.annSectionCnu = annuaire.annSectionCnu;
		this.annTelPerso = annuaire.annTelPerso;
		this.referent = annuaire.referent;
		this.titulaire = annuaire.titulaire;
		this.lisBatiment = annuaire.lisBatiment;
		this.lisPay = annuaire.lisPay;
		this.annuaireEquipes = annuaire.annuaireEquipes;
		this.lisComites = annuaire.lisComites;
	}
}