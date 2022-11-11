package co.edu.ucentral.mtto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ucentral.mtto.dtos.DtoCantidadTipos;
import co.edu.ucentral.mtto.dtos.DtoRango;
import co.edu.ucentral.mtto.dtos.DtoTotalesSinAtender;
import co.edu.ucentral.mtto.model.Equipo;
import co.edu.ucentral.mtto.model.Estado;
import co.edu.ucentral.mtto.model.Soporte;
import co.edu.ucentral.mtto.model.Tecnicos;
import co.edu.ucentral.mtto.model.Tipo_mtto;
import co.edu.ucentral.mtto.service.EquipoService;
import co.edu.ucentral.mtto.service.EstadoService;
import co.edu.ucentral.mtto.service.SoporteService;
import co.edu.ucentral.mtto.service.TecnicosService;

@RequestMapping("soporte/admin")
@Controller
public class AdminController {

	@Autowired
	private SoporteService soporteService;

	@Autowired
	private EquipoService equipoService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private TecnicosService tecnicosService;

	@PostMapping("asignarTecnico/{id}")
	public String asignar(@PathVariable Long id, Soporte soporte) {

		// Consulto y guardo el soporte
		Soporte tempSoporte = soporteService.buscarSoportePorId(id);

		Estado abierto = new Estado();
		abierto.setId_estado(2);

		tempSoporte.setTecnico(soporte.getTecnico());

		tempSoporte.setEstado(abierto);
		soporteService.guardaSoporte(tempSoporte);

		Tecnicos tecnico = tecnicosService.buscarTecnicosPorId(soporte.getTecnico().getId_tecnico());
		tecnico.setCasos_asignados(tecnico.getCasos_asignados() + 1);

		tecnicosService.guardaTecnicos(tecnico);

		return "redirect:/";
	}

	@GetMapping("asignarTecnico/{id}")
	public String asignar(@PathVariable Long id, Soporte soporte, Model model) {
		Soporte soporteEncontrado = soporteService.buscarSoportePorId(id);
		List<Tecnicos> tecnicos = tecnicosService.buscarTecnicosPorEstado(true);

		model.addAttribute("soporteEncontrado", soporteEncontrado);
		model.addAttribute("tecnicos", tecnicos);

		return "admin/asignarTecnico";
	}

	@GetMapping("/consultarPendientesAsignar")
	public String pendientesAsignar(Model model) {

		Estado abierto = new Estado();
		abierto.setId_estado(1);

		List<Soporte> soportes = soporteService.buscarPorEstado(abierto);

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

		return "admin/pendientesAsignar";

	}

	@GetMapping("/consultaRangos")
	public String consultaRangos(DtoRango dtoRango, Model model) {
		model.addAttribute("dtoRango", new DtoRango());
		return "admin/periodos";

	}

	@SuppressWarnings("deprecation")
	@PostMapping("/rangoTipo")
	public String consultaRangoTipo(DtoRango dtoRango, Model model) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<DtoCantidadTipos> cantidadTipos = new ArrayList<>();
		try {
			Date inicio = sdf.parse(dtoRango.getInicio());
			Date fin = sdf.parse(dtoRango.getFin());

			cantidadTipos = soporteService.buscarPorCantidadTipos(inicio, fin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("tipos", cantidadTipos);

		return "admin/RangoTipo";

	}

	@SuppressWarnings("deprecation")
	@PostMapping("/rangoRadicado")
	public String consultaRangoRadicado(DtoRango dtoRango, Model model) {

		Collection<Estado> estadosTotal = new ArrayList<>();
		Collection<Estado> estadosAbierto = new ArrayList<>();

		Estado abierto = estadoService.buscarEstadoPorId(new Long(1));
		Estado asignado = estadoService.buscarEstadoPorId(new Long(2));
		Estado esperando = estadoService.buscarEstadoPorId(new Long(3));
		Estado cerrado = estadoService.buscarEstadoPorId(new Long(4));

		estadosTotal.add(esperando);
		estadosTotal.add(asignado);
		estadosTotal.add(cerrado);
		estadosTotal.add(abierto);

		estadosAbierto.add(abierto);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List<Soporte> soportesTotalRango = new ArrayList<>();
		List<Soporte> soportesAbiertos = new ArrayList<>();
		Date inicio = null;
		Date fin = null;
		try {
			inicio = sdf.parse(dtoRango.getInicio());
			fin = sdf.parse(dtoRango.getFin());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		soportesTotalRango = soporteService.buscarPorRangoEstados(inicio, fin, estadosTotal);
		soportesAbiertos = soporteService.buscarPorRangoEstados(inicio, fin, estadosAbierto);

		DtoTotalesSinAtender totalesSinAtender = new DtoTotalesSinAtender();
		totalesSinAtender.setSinAtender(soportesAbiertos);
		totalesSinAtender.setTotales(soportesTotalRango.size());

		model.addAttribute("totalesSinAtender", totalesSinAtender);

		return "admin/RangoSinAtender";

	}

	@GetMapping("/consultarTodos")
	public String consultarTodos(Model model) {

		List<Soporte> soportes = soporteService.listar();

		for (Soporte soporte : soportes) {

			if (soporte.getEstado().getId_estado() == 4) {
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
				soporte.setTiempoDuracion(tiempo);
			}

		}
		model.addAttribute("soportes", soportes);

		return "admin/todosGenerados";

	}

	@GetMapping("/requierenArreglo")
	public String consultarArreglo(Model model) {

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

		List<Equipo> equipos = equipoService.listar();

		Tipo_mtto tipo = new Tipo_mtto();
		tipo.setId_mtto(2);

		List<Soporte> soportes = soporteService.buscarPorEquiposYEstadosYTipo(equipos, estados, tipo);

		List<Equipo> equiposDañados = new ArrayList<>();

		for (Soporte soporte : soportes) {
			Equipo equipoDañado = equipoService.buscarEquipoPorId(soporte.getEquipo().getId_equipo());
			equiposDañados.add(equipoDañado);
		}

		model.addAttribute("equipos", equiposDañados);

		return "admin/requierenArreglo";

	}

}
