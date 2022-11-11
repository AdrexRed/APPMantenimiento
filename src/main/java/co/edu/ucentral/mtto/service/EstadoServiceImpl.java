package co.edu.ucentral.mtto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	@Override
	public List<Estado> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaEstado(Estado estado) {
		repo.save(estado);
	}

	@Override
	public void modificarEstado(Estado estado) {

	}

	@Override
	public Estado buscarEstadoPorId(Long id) {
		Optional<Estado> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarEstado(Long id) {
		repo.deleteById(id);
	}

}
