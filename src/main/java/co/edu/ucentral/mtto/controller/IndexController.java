package co.edu.ucentral.mtto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ucentral.mtto.dtos.DtoDashAdmin;
import co.edu.ucentral.mtto.dtos.DtoMasAreasSolicitud;
import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Soporte;
import co.edu.ucentral.mtto.service.AreaService;
import co.edu.ucentral.mtto.service.SoporteService;

@Controller
@RequestMapping
public class IndexController {

	@PersistenceContext protected EntityManager entityManager;
	
	@Autowired
	private SoporteService soporteService;
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping({"/","/index"})
	public String home(Model model) {
		
		Estado estado = new Estado();
		estado.setId_estado(4);
		List<Soporte> soportes = soporteService.buscarPorEstado(estado);
		Period periodSuma = new Period();
		double satisfaccion = 0;
		int contSatisfaccion = 0;
		for (Soporte soporte : soportes) {
			//Calculo el tiempo que se tardo en resolver
			
			SimpleDateFormat  fechaHora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date fhInicio = null;
			try {
				fhInicio = fechaHora.parse(soporte.getFechaInicio()+" "+soporte.getHoraInicio());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DateTime start = new DateTime(fhInicio);
			DateTime end = new DateTime();
			
			Period period = new Period(start, end);
			periodSuma = periodSuma.plus(period);
			if(soporte.getEncuesta()!=null) {
				satisfaccion = satisfaccion+soporte.getEncuesta().getCalificacion();
				contSatisfaccion++;
			}
		}
		
		String tiempo="Sin Datos";
		

		if(contSatisfaccion!=0)
		satisfaccion = satisfaccion/contSatisfaccion;
		
		if (!soportes.isEmpty()){
			periodSuma = periodSuma.multipliedBy(1/soportes.size());
			tiempo = "Dias: "+periodSuma.getDays()+" Horas: "+periodSuma.getHours()+" Minutos: "+periodSuma.getMinutes();
		}
		
		
		DtoDashAdmin dtoDashAdmin = new DtoDashAdmin();
		dtoDashAdmin.setSatisfaccion(satisfaccion);

		List<DtoMasAreasSolicitud> solicitudes
		=areaService.findByMas();
		
		if(solicitudes.isEmpty()) {
			dtoDashAdmin.setDepartamentoMasSolicitudes("Sin Datos");
		}else {
			dtoDashAdmin.setDepartamentoMasSolicitudes(solicitudes.get(0).getNom_area()+" : "+solicitudes.get(0).getCantidad());

			
		}
		
		dtoDashAdmin.setPromedioSolucion(tiempo);
		
		model.addAttribute("dtoDashAdmin", dtoDashAdmin);
		
		return "index";
	}
	
}
