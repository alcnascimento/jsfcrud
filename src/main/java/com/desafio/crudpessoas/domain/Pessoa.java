
package com.desafio.crudpessoas.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "pessoa", uniqueConstraints={@UniqueConstraint(columnNames="cpf")})
public class Pessoa implements java.io.Serializable {

	private static final long serialVersionUID = -3408989621230572803L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private Date birthDate;
	
	@CreationTimestamp
	private Date insertDate;
	
	@UpdateTimestamp
	private Date updateDate;
	
	private String gender;
	private String eMail;
	private String cityOfBirth; // Naturalidade
	private String countryOfBirth; // Nacionalidade
	
	



	public Pessoa() {
	}



	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", name=" + name + ", cpf=" + cpf + ", birthDate=" + birthDate + ", insertDate="
				+ insertDate + ", updateDate=" + updateDate + ", sex=" + gender + ", eMail=" + eMail + ", cityOfBirth="
				+ cityOfBirth + ", countryOfBirth=" + countryOfBirth + "]";
	}



	public Pessoa(Long id, String name, String cpf, Date birthDate, Date insertDate, Date updateDate, String sex,
			String eMail, String cityOfBirth, String countryOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.gender = sex;
		this.eMail = eMail;
		this.cityOfBirth = cityOfBirth;
		this.countryOfBirth = countryOfBirth;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCityOfBirth() {
		return cityOfBirth;
	}

	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
