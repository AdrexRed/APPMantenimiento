package co.edu.ucentral.mtto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.mtto.model.Encuesta;
import co.edu.ucentral.mtto.repository.EncuestaRepository;



@Service
public class EncuestaServiceImpl implements EncuestaService {

	@Autowired
	private EncuestaRepository repo;
	
	@Override
	public void guardaEncuesta(Encuesta encuesta) {
		repo.save(encuesta);
		
	}

}
