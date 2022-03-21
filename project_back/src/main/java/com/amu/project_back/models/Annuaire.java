package com.amu.project_back.models;

import com.amu.project_back.models.enume.*;
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
public class Annuaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ann_id")
	private String annId;

	@Lob
	@Column(name="ann_adr_perso")
	private String annAdrPerso;

	@Lob
	@Column(name="ann_adr_pro")
	private String annAdrPro;

	@Column(name="ann_civ")
	private Civ annCiv;

	@Column(name="ann_comp_gen_diffusion")
	private byte annCompGenDiffusion;

	@Column(name="ann_comp_gen_hal")
	private String annCompGenHal;

	@Column(name="ann_comp_gen_lk")
	private String annCompGenLk;

	@Column(name="ann_comp_gen_orcid")
	private String annCompGenOrcid;

	@Column(name="ann_comp_gen_photo")
	private String annCompGenPhoto;

	@Column(name="ann_comp_gen_reseda")
	private String annCompGenReseda;

	@Column(name="ann_comp_gen_url")
	private String annCompGenUrl;

	@Column(name="ann_courriel")
	private String annCourriel;

	@Column(name="ann_courriel_perso")
	private String annCourrielPerso;

	@Column(name="ann_courriel2")
	private String annCourriel2;

	@Column(name="ann_emerite")
	private byte annEmerite;

	@Temporal(TemporalType.DATE)
	@Column(name="ann_emerite_date")
	private Date annEmeriteDate;

	@Column(name="ann_etat")
	private byte annEtat;

	@Column(name="ann_hdr")
	private byte annHdr;

	@Temporal(TemporalType.DATE)
	@Column(name="ann_hdr_date")
	private Date annHdrDate;

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
	private byte annSectionCnrs;

	@Column(name="ann_section_cnu")
	private byte annSectionCnu;

	@Column(name="ann_tel_perso")
	private String annTelPerso;


	@ManyToOne
	@JoinColumn(name = "referent")
	private Annuaire referent;

	@OneToMany(mappedBy = "referent")
	private List<Annuaire> personnels;

	@Column(name="referent_courriel")
	private String referentCourriel;

	@Lob
	private String remarques;

	@Column(name="section_cnrs")
	@Enumerated(EnumType.STRING)
	private Cnrs sectionCnrs;

	@Column(name="section_cnu")
	@Enumerated(EnumType.STRING)
	private Cnrs sectionCnu;

	private byte titulaire;

	@Column(name = "type_contrat_doc")
	@Enumerated(EnumType.STRING)
	private ContractType docType;

	@Column(name = "type_financement_doc")
	@Enumerated(EnumType.STRING)
	private TypeFinance typeFinance;

	//bi-directional many-to-one association to AnnuaireDiplome
	@ManyToOne
	@JoinColumn(name="annuaire_diplome_ann_diplome_id")
	private AnnuaireDiplome annuaireDiplome;

	//bi-directional many-to-one association to LisBatiment
	@ManyToOne
	@JoinColumn(name="ann_lis_bat_id")
	private LisBatiment lisBatiment;

	//bi-directional many-to-one association to LisPay
	@ManyToOne
	@JoinColumn(name="ann_lis_pays_id")
	private LisPay lisPay;



	//bi-directional many-to-one association to AnnuaireEquipe
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
		this.annCompGenDiffusion = annuaire.annCompGenDiffusion;
		this.annCompGenHal = annuaire.annCompGenHal;
		this.annCompGenLk = annuaire.annCompGenLk;
		this.annCompGenOrcid = annuaire.annCompGenOrcid;
		this.annCompGenPhoto = annuaire.annCompGenPhoto;
		this.annCompGenReseda = annuaire.annCompGenReseda;
		this.annCompGenUrl = annuaire.annCompGenUrl;
		this.annCourriel = annuaire.annCourriel;
		this.annCourrielPerso = annuaire.annCourrielPerso;
		this.annCourriel2 = annuaire.annCourriel2;
		this.annEmerite = annuaire.annEmerite;
		this.annEmeriteDate = annuaire.annEmeriteDate;
		this.annEtat = annuaire.annEtat;
		this.annHdr = annuaire.annHdr;
		this.annHdrDate = annuaire.annHdrDate;
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
		this.referentCourriel = annuaire.referentCourriel;
		this.remarques = annuaire.remarques;
		this.sectionCnrs = annuaire.sectionCnrs;
		this.sectionCnu = annuaire.sectionCnu;
		this.titulaire = annuaire.titulaire;
		this.annuaireDiplome = annuaire.annuaireDiplome;
		this.lisBatiment = annuaire.lisBatiment;
		this.lisPay = annuaire.lisPay;
		this.annuaireEquipes = annuaire.annuaireEquipes;
		this.lisComites = annuaire.lisComites;
	}
}