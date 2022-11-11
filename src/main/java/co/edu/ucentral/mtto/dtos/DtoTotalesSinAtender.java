package co.edu.ucentral.mtto.dtos;

import java.util.List;

import co.edu.ucentral.mtto.model.Soporte;

public class DtoTotalesSinAtender {
	
	private List<Soporte> sinAtender;
	private int totales;
	public List<Soporte> getSinAtender() {
		return sinAtender;
	}
	public void setSinAtender(List<Soporte> sinAtender) {
		this.sinAtender = sinAtender;
	}
	public int getTotales() {
		return totales;
	}
	public void setTotales(int totales) {
		this.totales = totales;
	}
	
	

}
