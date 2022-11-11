package co.edu.ucentral.mtto.service;

import java.util.List;

import co.edu.ucentral.mtto.dtos.DtoMasAreasSolicitud;
import co.edu.ucentral.mtto.model.Area;

public interface AreaService {

	public List<Area> listar();
	public void guardaArea(Area area);
	public void modificarArea(Area area);
	public Area buscarAreaPorId(Long id);
	public void eliminarArea(Long id);
	public List<DtoMasAreasSolicitud> findByMas();
	
}
