package co.edu.ucentral.mtto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tecnicos")
public class Tecnicos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tecnico;
	@OneToOne
	@JoinColumn(name = "usuario")
	private Usuarios usuario;
	private Integer casos_asignados;
	private Integer nivel;
	private Boolean disponible;
	
	public long getId_tecnico() {
		return id_tecnico;
	}
	public void setId_tecnico(long id_tecnico) {
		this.id_tecnico = id_tecnico;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public Integer getCasos_asignados() {
		return casos_asignados;
	}
	public void setCasos_asignados(Integer casos_asignados) {
		this.casos_asignados = casos_asignados;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	
}
