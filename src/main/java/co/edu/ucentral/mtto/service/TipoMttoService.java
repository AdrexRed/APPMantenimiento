package co.edu.ucentral.mtto.service;

import java.util.List;

import co.edu.ucentral.mtto.model.Tipo_mtto;

public interface TipoMttoService {

	public List<Tipo_mtto> listar();
	public void guardaTipo_mtto(Tipo_mtto tipo_mtto);
	public void modificarTipo_mtto(Tipo_mtto tipo_mtto);
	public Tipo_mtto buscarTipo_mttoPorId(Long id);
	public void eliminarTipo_mtto(Long id);
	
}
