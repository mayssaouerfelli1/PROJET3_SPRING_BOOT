package com.mayssa.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Artiste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArtiste;
	private String nomArtiste;
	private String nationaliteArtiste;
	
	@OneToMany(mappedBy="artiste")
	@JsonIgnore
	private List<chanson> chansons;
	public Artiste() {}
	public Artiste(String nomArtiste, String nationaliteArtiste, List<chanson> chansons) {
		super();
		this.nomArtiste = nomArtiste;
		this.nationaliteArtiste = nationaliteArtiste;
		this.chansons = chansons;
	}
	public Long getIdArtiste() {
		return idArtiste;
	}
	public void setIdArtiste(Long idArtiste) {
		this.idArtiste = idArtiste;
	}
	public String getNom() {
		return nomArtiste;
	}
	public void setNom(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}
	public String getNationaliteArtiste() {
		return nationaliteArtiste;
	}
	public void setNationaliteArtiste(String nationaliteArtiste) {
		this.nationaliteArtiste = nationaliteArtiste;
	}
	public List<chanson> getChansons() {
		return chansons;
	}
	public void setChansons(List<chanson> chansons) {
		this.chansons = chansons;
	}
	@Override
	public String toString() {
		return "Artiste [idArtiste=" + idArtiste + ", nomArtiste=" + nomArtiste + ", nationaliteArtiste="
				+ nationaliteArtiste + ", chansons=" + chansons + "]";
	}
	

}
