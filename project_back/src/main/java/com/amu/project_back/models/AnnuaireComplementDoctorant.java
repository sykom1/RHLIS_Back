package com.amu.project_back.models;

import com.amu.project_back.models.enume.ContractType;
import com.amu.project_back.models.enume.TypeFinance;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigInteger;


/**
 * The persistent class for the annuaire_complement_doctorant database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="annuaire_complement_doctorant")
@NamedQuery(name="AnnuaireComplementDoctorant.findAll", query="SELECT a FROM AnnuaireComplementDoctorant a")
public class AnnuaireComplementDoctorant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ann_comp_doc_id")
	private String annCompDocId;

	@Column(name="ann_comp_doc_ann_id")
	private BigInteger annCompDocAnnId;

	@Column(name="ann_comp_doc_codir_these_lis")
	private BigInteger annCompDocCodirTheseLis;

	@Column(name="ann_comp_doc_codir_these_nlis")
	private String annCompDocCodirTheseNlis;



	@Column(name="ann_comp_doc_dir_these_lis")
	private BigInteger annCompDocDirTheseLis;

	@Column(name="ann_comp_doc_dir_these_nlis")
	private String annCompDocDirTheseNlis;



	@Column(name="ann_comp_doc_titre_these")
	private String annCompDocTitreThese;


	@Column(name="ann_comp_doc_type_contrat_id")
	private ContractType annCompDocTypeContratId;

	@Column(name="ann_comp_doc_type_financement_id")
	private TypeFinance annCompDocTypeFinancementId;


	@Column(name = "devenir_doc")
	private String devenirDoc;

	//bi-directional many-to-one association to LisEd
	@ManyToOne
	@JoinColumn(name="lis_ed_lis_ed_id")
	private LisEd lisEd;


}