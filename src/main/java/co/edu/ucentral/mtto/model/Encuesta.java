package co.edu.ucentral.mtto.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "encuesta")
public class Encuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_encuesta;
	private int calificacion;
	@OneToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name = "soporte")
	private Soporte soporte;
	public long getId_encuesta() {
		return id_encuesta;
	}
	public void setId_encuesta(long id_encuesta) {
		this.id_encuesta = id_encuesta;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public Soporte getSoporte() {
		return soporte;
	}
	public void setSoporte(Soporte soporte) {
		this.soporte = soporte;
	}
	
	
	
}
