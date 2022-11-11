package co.edu.ucentral.mtto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import co.edu.ucentral.mtto.model.Encuesta;
import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Soporte;
import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Usuarios;
import co.edu.ucentral.mtto.service.EncuestaService;
import co.edu.ucentral.mtto.service.EquipoService;
import co.edu.ucentral.mtto.service.EstadoService;
import co.edu.ucentral.mtto.service.SoporteService;
import co.edu.ucentral.mtto.service.TecnicosService;
import co.edu.ucentral.mtto.service.UsuariosService;

@RequestMapping("soporte")
@Controller
public class SolicitudController {

	@Autowired
	private SoporteService soporteService;

	@Autowired
	private UsuariosService usuarioService;

	@Autowired
	private EncuestaService encuestaService;

	@Autowired
	private EquipoService equipoService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private TecnicosService tecnicosService;

	@GetMapping("usuario/misAbiertos")
	public String abiertos(Authentication authentication, HttpSession session, Model model) {

		// Obtengo el username autenticado
		String username = authentication.getName();

		// Obtengo el objeto usuario
		Usuarios usuario = usuarioService.buscarUsuarioPorUsername(username);

		// Obtengo los equipós asignados al usuario
		List<Equipo> equipos = equipoService.equiposPorUsuario(usuario);

		Collection<Estado> estados = new ArrayList<>();

		Estado abierto = new Estado();
		abierto.setId_estado(1);
		Estado asignado = new Estado();
		asignado.setId_estado(2);
		Estado esperando = new Estado();
		esperando.setId_estado(3);

		estados.add(esperando);
		estados.add(asignado);
		estados.add(abierto);

		// Obtengo los soportes asignados a estos equipo con estados abiertos (Abierto,
		// Asignado, Esperando)
		List<Soporte> soportesAbiertos = soporteService.buscarPorEquiposYEstados(equipos, estados);

		model.addAttribute("soportes", soportesAbiertos);

		return "usuario/misAbiertos";
	}

	@GetMapping("usuario/crear")
	public String crear(Authentication authentication, HttpSession session, Soporte soporte, Model model) {

		// Obtengo el username autenticado
		String username = authentication.getName();

		// Obtengo el objeto usuario
		Usuarios usuario = usuarioService.buscarUsuarioPorUsername(username);

		List<Equipo> equipos = equipoService.equiposPorUsuario(usuario);

		model.addAttribute("equipos", equipos);

		return "usuario/formSoporte";
	}

	@PostMapping("usuario/crear")
	public String crear(Soporte soporte) {

		Estado abierto = new Estado();
		abierto.setId_estado(1);

		soporte.setFechaInicio(new Date());
		soporte.setHoraInicio(LocalTime.now());
		soporte.setEstado(abierto);

		soporteService.guardaSoporte(soporte);

		return "redirect:/";
	}

	@PostMapping("/tecnico/atenderCaso/{id}")
	public String atender(@PathVariable Long id, Soporte soporte) {

		// Consulto y guardo el soporte
		Soporte tempSoporte = soporteService.buscarSoportePorId(id);

		// Si el estado es cerrado, coloco hora y fecha de finalizado
		if (soporte.getEstado().getId_estado() == 4) {
			tempSoporte.setFechaFin(new Date());
			tempSoporte.setHoraFin(LocalTime.now());
			tempSoporte.getTecnico().setCasos_asignados(tempSoporte.getTecnico().getCasos_asignados()-1);
		}

		if (tempSoporte.getAnotaciones() == null) {
			tempSoporte.setAnotaciones(tempSoporte.getTecnico().getUsuario().getNombres() + " "
					+ tempSoporte.getTecnico().getUsuario().getApellidos() + " :" + soporte.getAnotaciones() + "| ");
		} else {
			tempSoporte.setAnotaciones(tempSoporte.getAnotaciones() + tempSoporte.getTecnico().getUsuario().getNombres()
					+ " " + tempSoporte.getTecnico().getUsuario().getApellidos() + " :" + soporte.getAnotaciones()
					+ "| ");
		}

		tempSoporte.setEstado(soporte.getEstado());
		soporteService.guardaSoporte(tempSoporte);

		return "redirect:/";
	}

	@GetMapping("/tecnico/atenderCaso/{id}")
	public String atender(@PathVariable Long id, Soporte soporte, Model model) {

		// Consulto el soporte
		Soporte soporteEncontrado = soporteService.buscarSoportePorId(id);
		model.addAttribute("soporteEncontrado", soporteEncontrado);

		return "tecnico/atencionCaso";
	}

	@GetMapping("/tecnico/consultarMisAsignados")
	public String misAsignados(Authentication authentication, HttpSession session, Model model) {

		Collection<Estado> estados = new ArrayList<>();

		Estado asignado = new Estado();
		asignado.setId_estado(2);
		Estado esperando = new Estado();
		esperando.setId_estado(3);

		estados.add(esperando);
		estados.add(asignado);

		// Obtengo el username autenticado
		String username = authentication.getName();

		// Obtengo el objeto usuario
		Usuarios usuario = usuarioService.buscarUsuarioPorUsername(username);

		Tecnicos tecnicos = tecnicosService.buscarTecnicoPorUsuario(usuario);
		List<Soporte> soportes = soporteService.buscarPorTecnicoYEstados(tecnicos, estados);

		for (Soporte soporte : soportes) {

			// Calculo el tiempo que se tardo en resolver

			SimpleDateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date fhInicio = null;
			try {
				fhInicio = fechaHora.parse(soporte.getFechaInicio() + " " + soporte.getHoraInicio());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DateTime start = new DateTime(fhInicio);
			DateTime end = new DateTime();

			Period period = new Period(start, end);

			String tiempo = "Dias: " + period.getDays() + " Horas: " + period.getHours() + " Minutos: "
					+ period.getMinutes();
			soporte.setTiempoDuracion(tiempo);

		}

		model.addAttribute("soportes", soportes);

		return "tecnico/misAsignados";

	}

	@PostMapping("usuario/evaluarSoporte/{id}")
	public String evaluarSoporte(@PathVariable Integer id, Encuesta encuesta) {
		Soporte soporte = new Soporte();
		soporte.setId_soporte(id);
		encuesta.setSoporte(soporte);
		encuestaService.guardaEncuesta(encuesta);

		return "redirect:/";

	}

	@GetMapping("usuario/misPendientesPorEvaluar")
	public String pendientesPorEvaluar(Authentication authentication, HttpSession session, Model model) {

		// Obtengo el username autenticado
		String username = authentication.getName();

		// Obtengo el objeto usuario
		Usuarios usuario = usuarioService.buscarUsuarioPorUsername(username);

		// Consulto mis equipos
		Collection<Equipo> equipos = equipoService.equiposPorUsuario(usuario);

		// Consulto soportes pendientes de evaluar
		List<Soporte> soportes = soporteService.buscarPendientesEvaluar(equipos);

		model.addAttribute("soportesEvaluar", soportes);

		return "usuario/misPendientesEvaluar";

	}

	@GetMapping("usuario/evaluacion/{id}")
	public String evaluarSoporte(@PathVariable Long id, Encuesta encuesta, Model model) {

		// Consulto soporte a evaluar para enviar al front
		Soporte soporte = soporteService.buscarSoportePorId(id);

		// Calculo el tiempo que se tardo en resolver

		SimpleDateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date fhInicio = null;
		Date fhFin = null;
		try {
			fhInicio = fechaHora.parse(soporte.getFechaInicio() + " " + soporte.getHoraInicio());
			fhFin = fechaHora.parse(soporte.getFechaFin() + " " + soporte.getHoraFin());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateTime start = new DateTime(fhInicio);
		DateTime end = new DateTime(fhFin);

		Period period = new Period(start, end);

		String tiempo = "Dias: " + period.getDays() + " Horas: " + period.getHours() + " Minutos: "
				+ period.getMinutes();
		model.addAttribute("soporte", soporte);
		model.addAttribute("tiempo", tiempo);

		return "usuario/evaluarSoporte";

	}

}
