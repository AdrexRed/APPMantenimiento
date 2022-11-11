package co.edu.ucentral.mtto.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.dtos.DtoCantidadTipos;
import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Soporte;
import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Tipo_mtto;
import co.edu.ucentral.mtto.repository.SoporteRepository;

@Service
public class SoporteServiceImpl implements SoporteService {

	@Autowired
	private SoporteRepository repo;
	
	@Override
	public List<Soporte> listar() {
		return repo.findAll();
	}

	@Override
	public void guardaSoporte(Soporte soporte) {
		repo.save(soporte);
	}

	@Override
	public void modificarSoporte(Soporte soporte) {
		// TODO Auto-generated method stub

	}

	@Override
	public Soporte buscarSoportePorId(Long id) {
		Optional<Soporte> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void eliminarSoporte(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Soporte> buscarPorEstado(Estado estado) {
		return repo.findByEstado(estado);
	}

	@Override
	public List<Soporte> buscarPorTecnicoYEstados(Tecnicos tecnico, Collection<Estado> estados) {
		return repo.findByTecnicoAndEstadoIn(tecnico, estados);
	}

	@Override
	public List<Soporte> buscarPendientesEvaluar(Collection<Equipo> equipos) {
		Estado estado = new Estado();
		estado.setId_estado(4);
		return repo.findByEncuestaIsNullAndEquipoInAndEstado(equipos,estado);
	}

	@Override
	public List<Soporte> buscarPorEquiposYEstados(Collection<Equipo> equipos, Collection<Estado> estados) {
		return repo.findByEquipoInAndEstadoIn(equipos, estados);
	}

	@Override
	public List<Soporte> buscarPorEquiposYEstadosYTipo(Collection<Equipo> equipos, Collection<Estado> estados,
			Tipo_mtto tipo_mtto) {
		return repo.findByEquipoInAndEstadoInAndTipMtto(equipos, estados, tipo_mtto);
	}

	@Override
	public List<DtoCantidadTipos> buscarPorCantidadTipos(Date inicio, Date fin) {
		return repo.findByRangoTipo(inicio, fin);
	}

	@Override
	public List<Soporte> buscarPorRangoEstados(Date inicio, Date fin, Collection<Estado> estados) {
		return repo.findByFechaInicioBetweenAndEstadoIn(inicio, fin, estados);
	}

}
