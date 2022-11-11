package co.edu.ucentral.mtto.service;

import java.util.List;

import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Usuarios;

public interface EquipoService {

	public List<Equipo> listar();
	public void guardaEquipo(Equipo equipo);
	public void modificarEquipo(Equipo equipo);
	public Equipo buscarEquipoPorId(Long id);
	public void eliminarEquipo(Long id);
	public List<Equipo> equiposPorUsuario(Usuarios usuario);
	
}
