package co.edu.ucentral.mtto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_mtto")
public class Tipo_mtto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_mtto;
	private String nom_mtto;
	
	public long getId_mtto() {
		return id_mtto;
	}
	public void setId_mtto(long id_mtto) {
		this.id_mtto = id_mtto;
	}
	public String getNom_mtto() {
		return nom_mtto;
	}
	public void setNom_mtto(String nom_mtto) {
		this.nom_mtto = nom_mtto;
	}
	
	

}
