package co.edu.ucentral.mtto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "area")
@NamedQueries({
	   @NamedQuery(name="area.MasSolicitudes",
	               query="SELECT area.nom_area AS nom_area, count(*) AS cantidad FROM Area area inner join Usuarios users ON (area.id_area = users.area) "
	               		+ "inner join Equipo equipo ON (equipo.asignado = users.id_usuario) inner join Soporte soporte "
	               		+ "ON (soporte.equipo = equipo.id_equipo) group by area.nom_area order by count(*)  desc")
	})
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_area;
	private String nom_area;
	public long getId_area() {
		return id_area;
	}
	public void setId_area(long id_area) {
		this.id_area = id_area;
	}
	public String getNom_area() {
		return nom_area;
	}
	public void setNom_area(String nom_area) {
		this.nom_area = nom_area;
	}
	

}
