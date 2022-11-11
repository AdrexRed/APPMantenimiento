package co.edu.ucentral.mtto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Usuarios;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

	List<Equipo> findByAsignado(Usuarios usuario);

}
