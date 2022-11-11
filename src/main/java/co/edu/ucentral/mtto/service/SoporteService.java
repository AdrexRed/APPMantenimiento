package co.edu.ucentral.mtto.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import co.edu.ucentral.mtto.dtos.DtoCantidadTipos;
import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Soporte;
import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Tipo_mtto;

public interface SoporteService {

	public List<Soporte> listar();
	public void guardaSoporte(Soporte soporte);
	public void modificarSoporte(Soporte soporte);
	public Soporte buscarSoportePorId(Long id);
	public void eliminarSoporte(Long id);
	public List<Soporte> buscarPorEstado(Estado estado);
	public List<Soporte> buscarPorTecnicoYEstados(Tecnicos tecnico, Collection<Estado> estados);
	public List<Soporte> buscarPendientesEvaluar(Collection<Equipo> equipos);
	public List<Soporte> buscarPorEquiposYEstados(Collection<Equipo> equipos,Collection<Estado> estados);
	public List<Soporte> buscarPorEquiposYEstadosYTipo(Collection<Equipo> equipos,Collection<Estado> estados, Tipo_mtto tipo_mtto);
	public List<DtoCantidadTipos> buscarPorCantidadTipos(Date inicio, Date fin);
	public List<Soporte> buscarPorRangoEstados(Date inicio, Date fin, Collection<Estado> estados);
	
}
