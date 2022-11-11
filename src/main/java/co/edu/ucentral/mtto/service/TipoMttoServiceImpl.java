package co.edu.ucentral.mtto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.model.Tipo_mtto;
import co.edu.ucentral.mtto.repository.TipoMttoRepository;

@Service
public class TipoMttoServiceImpl implements TipoMttoService {

	@Autowired
	private TipoMttoRepository repo;
	
	@Override
	public List<Tipo_mtto> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaTipo_mtto(Tipo_mtto tipo_mtto) {
		repo.save(tipo_mtto);
	}

	@Override
	public void modificarTipo_mtto(Tipo_mtto tipo_mtto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tipo_mtto buscarTipo_mttoPorId(Long id) {
		Optional<Tipo_mtto> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarTipo_mtto(Long id) {
		repo.deleteById(id);
	}

}
