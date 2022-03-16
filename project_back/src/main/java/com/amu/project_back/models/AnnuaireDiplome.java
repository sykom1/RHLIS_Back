package com.amu.project_back.models;

import com.amu.project_back.models.enume.LisDefense;
import com.amu.project_back.models.enume.LisDiploma;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the annuaire_diplome database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="annuaire_diplome")
@NamedQuery(name="AnnuaireDiplome.findAll", query="SELECT a FROM AnnuaireDiplome a")
public class AnnuaireDiplome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ann_diplome_id")
	private String annDiplomeId;

	@Column(name="ann_diplome_ann_id")
	private BigInteger annDiplomeAnnId;

	@Column(name="ann_diplome_annee")
	private int annDiplomeAnnee;

	@Lob
	@Column(name="ann_diplome_commentaire")
	private String annDiplomeCommentaire;

	@Column(name="ann_diplome_lieu")
	private String annDiplomeLieu;

	@Column(name="ann_diplome_titre")
	private String annDiplomeTitre;

	@Column(name="ann_diplome_type_diplome_id")
	private BigInteger annDiplomeTypeDiplomeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ann_sout_date")
	private Date annSoutDate;

	@Lob
	@Column(name="ann_sout_en")
	private String annSoutEn;

	@Lob
	@Column(name="ann_sout_fr")
	private String annSoutFr;

	@Column(name="ann_sout_titre")
	private String annSoutTitre;

	@Column(name="lis_diplome")
	private LisDiploma lisDiplome;

	@Column(name="lis_soutenance")
	private LisDefense lisSoutenance;

	//bi-directional many-to-one association to Annuaire
	@OneToMany(mappedBy="annuaireDiplome")
	private List<Annuaire> annuaires;


}