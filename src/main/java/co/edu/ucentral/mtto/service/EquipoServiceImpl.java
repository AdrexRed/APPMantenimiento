package co.edu.ucentral.mtto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Usuarios;
import co.edu.ucentral.mtto.repository.EquipoRepository;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoRepository repo;
	
	@Override
	public List<Equipo> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaEquipo(Equipo equipo) {
		repo.save(equipo);
	}

	@Override
	public void modificarEquipo(Equipo equipo) {

	}

	@Override
	public Equipo buscarEquipoPorId(Long id) {
		Optional<Equipo> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarEquipo(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Equipo> equiposPorUsuario(Usuarios usuario) {
		return repo.findByAsignado(usuario);
	}

}
