package co.edu.ucentral.mtto.service;

import java.util.List;

import co.edu.ucentral.mtto.model.Estado;

public interface EstadoService {

	public List<Estado> listar();
	public void guardaEstado(Estado estado);
	public void modificarEstado(Estado estado);
	public Estado buscarEstadoPorId(Long id);
	public void eliminarEstado(Long id);
	
}
