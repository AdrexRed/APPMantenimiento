package co.edu.ucentral.mtto.dtos;

public class DtoCantidadTipos {
	private Long cantidad;
	private String tipo;
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public DtoCantidadTipos(Long cantidad, String tipo) {
		super();
		this.cantidad = cantidad;
		this.tipo = tipo;
	}
	
	
}
