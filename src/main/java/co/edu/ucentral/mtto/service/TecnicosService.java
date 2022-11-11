package co.edu.ucentral.mtto.service;

import java.util.List;

import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Usuarios;

public interface TecnicosService {

	public List<Tecnicos> listar();
	public void guardaTecnicos(Tecnicos tecnicos);
	public void modificarTecnicos(Tecnicos tecnicos);
	public Tecnicos buscarTecnicosPorId(Long id);
	public List<Tecnicos> buscarTecnicosPorEstado(Boolean disponible);
	public Tecnicos buscarTecnicoPorUsuario(Usuarios usuarios);
	public void eliminarTecnicos(Long id);
	
}
