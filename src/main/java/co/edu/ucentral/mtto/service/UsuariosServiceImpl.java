package co.edu.ucentral.mtto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.model.Usuarios;
import co.edu.ucentral.mtto.repository.UsuarioRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public List<Usuarios> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaUsuarios(Usuarios usuarios) {
		repo.save(usuarios);
	}

	@Override
	public void modificarUsuarios(Usuarios usuarios) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuarios buscarUsuariosPorId(Long id) {
		Optional<Usuarios> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarUsuarios(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Usuarios buscarUsuarioPorUsername(String username) {
		return repo.findByUsername(username);
	}

}
