package co.edu.ucentral.mtto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Usuarios;
import co.edu.ucentral.mtto.repository.TecnicosRepository;

@Service
public class TecnicosServiceImpl implements TecnicosService {

	@Autowired
	private TecnicosRepository repo;
	
	@Override
	public List<Tecnicos> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaTecnicos(Tecnicos tecnicos) {
		repo.save(tecnicos);
	}

	@Override
	public void modificarTecnicos(Tecnicos tecnicos) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tecnicos buscarTecnicosPorId(Long id) {
		Optional<Tecnicos> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarTecnicos(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Tecnicos> buscarTecnicosPorEstado(Boolean disponible) {
		return repo.findByDisponible(disponible);
	}

	@Override
	public Tecnicos buscarTecnicoPorUsuario(Usuarios usuarios) {
		return repo.findByUsuario(usuarios);
	}

}
