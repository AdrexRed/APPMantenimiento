package co.edu.ucentral.mtto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.dtos.DtoMasAreasSolicitud;
import co.edu.ucentral.mtto.model.Area;
import co.edu.ucentral.mtto.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaRepository repo;

	@Override
	public List<Area> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaArea(Area area) {
		repo.save(area);
	}

	@Override
	public void modificarArea(Area area) {
		
	}

	@Override
	public Area buscarAreaPorId(Long id) {
		Optional<Area> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarArea(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<DtoMasAreasSolicitud> findByMas() {
		return repo.findByMas();
	}

}
