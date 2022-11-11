package co.edu.ucentral.mtto.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "soporte")
public class Soporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_soporte;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tecnico")
	private Tecnicos tecnico;
	private String descripcion;
	private String anotaciones;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	private LocalTime horaInicio;
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	private LocalTime horaFin;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mtto")
	private Tipo_mtto tipMtto;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado")
	private Estado estado;
	@JsonManagedReference
	@OneToOne(mappedBy = "soporte")
    private Encuesta encuesta;
	@Transient
	private String tiempoDuracion;
	
	@PrePersist
	public void prePersist() {
		fechaInicio = new Date();
	}
	
	public long getId_soporte() {
		return id_soporte;
	}
	public void setId_soporte(long id_soporte) {
		this.id_soporte = id_soporte;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Tecnicos getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnicos tecnico) {
		this.tecnico = tecnico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Tipo_mtto getTip_mtto() {
		return tipMtto;
	}
	public void setTip_mtto(Tipo_mtto tipMtto) {
		this.tipMtto = tipMtto;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public String getTiempoDuracion() {
		return tiempoDuracion;
	}

	public void setTiempoDuracion(String tiempoDuracion) {
		this.tiempoDuracion = tiempoDuracion;
	}
}
