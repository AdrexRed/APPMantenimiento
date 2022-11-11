package co.edu.ucentral.mtto.dtos;

public class DtoMasAreasSolicitud {
	private String nom_area;
	private Long cantidad;
	public String getNom_area() {
		return nom_area;
	}
	public void setNom_area(String nom_area) {
		this.nom_area = nom_area;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public DtoMasAreasSolicitud(String nom_area, Long cantidad) {
		super();
		this.nom_area = nom_area;
		this.cantidad = cantidad;
	}
	
	
}
