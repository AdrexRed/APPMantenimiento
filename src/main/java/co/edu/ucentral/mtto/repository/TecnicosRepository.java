package co.edu.ucentral.mtto.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Usuarios;

public interface TecnicosRepository extends JpaRepository<Tecnicos, Long> {
	public List<Tecnicos> findByDisponible(Boolean disponible);
	public Tecnicos findByUsuario(Usuarios usuario);
}
