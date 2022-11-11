package co.edu.ucentral.mtto.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.mtto.dtos.DtoCantidadTipos;
import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Soporte;
import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Tipo_mtto;

public interface SoporteRepository extends JpaRepository<Soporte, Long> {
	
	public List<Soporte> findByEstado(Estado estado);
	public List<Soporte> findByTecnicoAndEstadoIn(Tecnicos tecnico,Collection<Estado> estados);
	public List<Soporte> findByEncuestaIsNullAndEquipoInAndEstado(Collection<Equipo> equipos, Estado estado);
	public List<Soporte> findByEquipoInAndEstadoIn(Collection<Equipo> equipos, Collection<Estado> estados);
	public List<Soporte> findByEquipoInAndEstadoInAndTipMtto(Collection<Equipo> equipos, Collection<Estado> estados,Tipo_mtto tip_mtto);
	@Query("SELECT new co.edu.ucentral.mtto.dtos.DtoCantidadTipos(count(*), tipo.nom_mtto) FROM Soporte soporte inner join Tipo_mtto tipo on (tipo.id_mtto = soporte.tipMtto) "
			+ "where soporte.fechaInicio between :inicio AND :fin "
			+ "group by tipo.nom_mtto")
	public List<DtoCantidadTipos> findByRangoTipo(Date inicio,Date fin);
	
	public List<Soporte> findByFechaInicioBetweenAndEstadoIn(Date fechaInicio,Date fechaFin, Collection<Estado> estados);
}
