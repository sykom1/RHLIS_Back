package com.amu.project_back.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the utilisateurs database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="utilisateurs")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	private Annuaire directory;


	public Utilisateur(@NotBlank(message = "L'email est obligatoire !") String email,
					   @NotBlank(message = "Le mot de passe est obligatoire !") String password, UserRole role,
					   @NotBlank(message = "Le nom est obligatoire !") String lastname,
					   @NotBlank(message = "Le prenom est obligatoire !") String firstname, Date birthday,
					   @Pattern(regexp = "(^$|[0-9]{10})", message = "le numéro de téléphone doit contenir 10 chiffres") @NotBlank(message = "Le numero de telephone est obligatoire !") String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}


	public void setUser(Utilisateur user){
		this.id = user.id;
		this.email = user.email;
		this.password = user.password;
		this.banned = user.banned;
		this.role = user.role;
	}

}