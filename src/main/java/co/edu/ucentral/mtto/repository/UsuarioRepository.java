package co.edu.ucentral.mtto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.mtto.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	public Usuarios findByUsername(String username);
}
