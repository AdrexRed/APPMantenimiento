package co.edu.ucentral.mtto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.mtto.dtos.DtoMasAreasSolicitud;
import co.edu.ucentral.mtto.model.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
	@Query("SELECT new co.edu.ucentral.mtto.dtos.DtoMasAreasSolicitud(area.nom_area, count(*)) FROM Area area inner join Usuarios users ON (area.id_area = users.area) "
       		+ "inner join Equipo equipo ON (equipo.asignado = users.id_usuario) inner join Soporte soporte "
       		+ "ON (soporte.equipo = equipo.id_equipo) group by area.nom_area order by count(*)  desc")
	public List<DtoMasAreasSolicitud> findByMas();
}
