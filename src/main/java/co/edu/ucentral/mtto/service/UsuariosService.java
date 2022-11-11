package co.edu.ucentral.mtto.service;

import java.util.List;

import co.edu.ucentral.mtto.model.Usuarios;

public interface UsuariosService {

	public List<Usuarios> listar();
	public void guardaUsuarios(Usuarios usuarios);
	public void modificarUsuarios(Usuarios usuarios);
	public Usuarios buscarUsuariosPorId(Long id);
	public void eliminarUsuarios(Long id);
	public Usuarios buscarUsuarioPorUsername(String username);
	
}
