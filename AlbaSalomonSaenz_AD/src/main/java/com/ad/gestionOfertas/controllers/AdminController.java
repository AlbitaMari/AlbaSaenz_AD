package com.ad.gestionOfertas.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ad.gestionOfertas.constant.ViewConstant;
import com.ad.gestionOfertas.entities.Ciclos;
import com.ad.gestionOfertas.entities.Noticias;
import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.services.CiclosService;
import com.ad.gestionOfertas.services.NoticiasService;
import com.ad.gestionOfertas.services.OfertasService;
import com.ad.gestionOfertas.services.UsuariosService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Log LOG = LogFactory.getLog(AdminController.class);
	
	@Autowired
	public UsuariosService usuariosService;
	
	@Autowired
	public CiclosService ciclosService;
	
	@Autowired
	public NoticiasService noticiasService;
	
	@Autowired
	public OfertasService ofertasService;
	
	@GetMapping("/listrrhh")
	public String listRrhh(Model model) {
		LOG.info("METHOD: listRRHH()");
		model.addAttribute("usuario", new Usuarios());
		model.addAttribute("usuarios",usuariosService.listAllUsers("ROL_RRHH"));
		return ViewConstant.RRHH;
	}
	
	@GetMapping("/listalumnos")
	public String listAlumnos(Model model) {
		LOG.info("METHOD: listAlumnos()");
		model.addAttribute("usuario", new Usuarios());
		model.addAttribute("usuarios",usuariosService.listAllUsers("ROL_ALUMNO"));
		return ViewConstant.ALUMNOS;
	}
	
	@GetMapping("/deleteuser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")int id) throws Exception {
		LOG.info("METHOD: deleteUser()");
		Usuarios usuario = usuariosService.findUserById(id);
		usuariosService.deleteUser(id);

		if(usuario.getRole().equals("ROL_RRHH")) {
			
			return "redirect:/admin/listrrhh";
		}else {
			
			return "redirect:/admin/listalumnos";
		}
		
	}
	
	@GetMapping("/updateuser/{id}")
	public String updateUserForm(Model model, @PathVariable(name="id")int id) {
		LOG.info("METHOD: updateUserForm()");
		Usuarios usuario = usuariosService.findUserById(id);
		model.addAttribute("usuario",usuario);
		model.addAttribute("editMode",true);
		return ViewConstant.UPDATE;
	}
	
	@PostMapping("/updateuser/{id}")
	public String updateUser(@Valid @ModelAttribute("usuario") Usuarios usuarios,@PathVariable(name="id")int id) {
		LOG.info("METHOD: updateUser()");
		Usuarios usuario = usuariosService.findUserById(id);
		usuarios.setEnabled(false);
		usuarios.setRole(usuarios.getRole());
		usuariosService.updateUser(usuariosService.transform(usuarios));
		if(usuarios.getRole().equals("ROL_ALUMNO")) {
			return "redirect:/admin/listalumnos";
		}else {
			return "redirect:/admin/listrrhh";
		}

	}
	
	@PostMapping("/activeuser/{id}")
	public String activeUser(Model model, @PathVariable(name="id")int id) {
		LOG.info("METHOD: activeUser()");
		Usuarios usuario = usuariosService.findUserById(id);
		model.addAttribute("usuario",usuariosService.activeUser(usuariosService.transform(usuario)));
		return "redirect:/admin/listalumnos";
	}
	
	@PostMapping("/deactiveuser/{id}")
	public String deactiveUser(Model model, @PathVariable(name="id")int id) {
		LOG.info("METHOD: deactiveUser()");
		Usuarios usuario = usuariosService.findUserById(id);
		model.addAttribute("usuario",usuariosService.deactiveUser(usuariosService.transform(usuario)));
		return "redirect:/admin/listalumnos";
	}
	
	@GetMapping("/create/{role}")
	public ModelAndView createForm(@PathVariable(name="role")String role) {
		LOG.info("METHOD: createAlumnosForm()");
		ModelAndView mav = new ModelAndView(ViewConstant.CREATEA);
		Usuarios usuario = new Usuarios();
		usuario.setRole(role);
		mav.addObject("usuario", usuario);
		return mav;
	}
	
	@PostMapping("/create")
	public String createUser(@Valid @ModelAttribute Usuarios usuario) {
		LOG.info("METHOD: createAlumnos()");
		if(usuariosService.findUserByEmail(usuario.getEmail())==null) {
			usuariosService.createUser(usuariosService.transform(usuario));
			if(usuario.getRole().equals("ROL_ALUMNO")) {
				return "redirect:/admin/listalumnos";
			}else {
				return "redirect:/admin/listrrhh";
			}
			
		}else {
			return "redirect:/admin/create";
		}
	}

	@GetMapping("/ciclos")
	public String listAllCiclos(Model model) {
		LOG.info("METHOD: listCiclos()");
		model.addAttribute("ciclo", new Ciclos());
		model.addAttribute("ciclos",ciclosService.listAllCiclos());
		return ViewConstant.CICLOS;
	}
	
	@GetMapping("/deleteciclo/{id}")
	public String deleteCiclo(Model model, @PathVariable(name="id")int id) throws Exception {
		LOG.info("METHOD: deleteCiclo()");
		Ciclos ciclo = ciclosService.findCicloById(id);
		ciclosService.deleteCiclos(id);
		return "redirect:/admin/ciclos";
		
	}
	
	@GetMapping("/updateciclo/{id}")
	public String updateCicloForm(Model model, @PathVariable(name="id")int id) {
		LOG.info("METHOD: updateCicloForm()");
		Ciclos ciclo = ciclosService.findCicloById(id);
		model.addAttribute("ciclo",ciclo);
		model.addAttribute("editMode",true);
		return ViewConstant.UPDCIC;
	}
	
	@PostMapping("/updateciclo/{id}")
	public String updateCiclos(@Valid @ModelAttribute("ciclo") Ciclos ciclos,@PathVariable(name="id")int id) {
		LOG.info("METHOD: updateCiclos()");
		Ciclos ciclo = ciclosService.findCicloById(id);
		ciclosService.updateCiclos(ciclosService.transform(ciclos));
		return "redirect:/admin/ciclos";
	}
	
	@GetMapping("/createciclo")
	public ModelAndView createCicloForm() {
		LOG.info("METHOD: createCiclosForm()");
		ModelAndView mav = new ModelAndView(ViewConstant.CREACI);
		mav.addObject("ciclo", new Ciclos());
		return mav;
	}
	
	@PostMapping("/createciclo")
	public String createCiclo(@Valid @ModelAttribute Ciclos ciclo) {
		LOG.info("METHOD: createCiclo()");
		ciclosService.createCiclo(ciclosService.transform(ciclo));
		return "redirect:/admin/ciclos";
	}
	
	@GetMapping("/noticias")
	public String listAllNoticias(Model model) {
		LOG.info("METHOD: listNoticias()");
		model.addAttribute("noticia", new Noticias());
		model.addAttribute("noticias",noticiasService.listAllNoticias());
		return ViewConstant.NOTICIAS;
	}
	
	@GetMapping("/createnoticias")
	public ModelAndView createNoticiaForm() {
		LOG.info("METHOD: createNoticiaForm()");
		ModelAndView mav = new ModelAndView(ViewConstant.CREANOT);
		mav.addObject("noticia", new Noticias());
		mav.addObject("ciclo", new Ciclos());
		mav.addObject("ciclos",ciclosService.listAllCiclos());
		return mav;
	}
	
	
	@PostMapping("/createnoticias")
	public String createNoticia(@Valid @ModelAttribute Noticias noticias, @RequestParam(name="imagen2",required=false) MultipartFile imagen) {
		LOG.info("METHOD: createNoticia()");
		if(!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static/imgs");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta,bytesImg);
				noticias.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		noticiasService.createNoticia(noticiasService.transform(noticias));
		return "redirect:/admin/noticias";
	}
	
	@GetMapping("/deletenoticia/{id}")
	public String deleteNoticia(Model model, @PathVariable(name="id")int id) throws Exception {
		LOG.info("METHOD: deleteNoticia()");
		Noticias noticia = noticiasService.findNoticiasById(id);
		noticiasService.deleteNoticias(id);
		return "redirect:/admin/noticias";
	}
	
	@GetMapping("/updatenoticia/{id}")
	public String updateNoticiaForm(Model model, @PathVariable(name="id")int id) {
		LOG.info("METHOD: updateNoticiaForm()");
		Noticias noticia = noticiasService.findNoticiasById(id);
		model.addAttribute("noticia",noticia);
		model.addAttribute("editMode",true);
		model.addAttribute("ciclos",ciclosService.listAllCiclos());
		return ViewConstant.UPDNOT;
	}

	@PostMapping("/updatenoticia/{id}")
	public String updateNoticias(@Valid @ModelAttribute("noticia") Noticias noticias,@PathVariable(name="id")int id,
			@RequestParam(name="imagen2",required=false) MultipartFile imagen) {
		LOG.info("METHOD: updateNoticias()");
		Noticias noticia = noticiasService.findNoticiasById(id);
		if(!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static/imgs");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta,bytesImg);
				noticias.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		noticiasService.updateNoticias(noticiasService.transform(noticias));
		return "redirect:/admin/noticias";
	}
	
	@GetMapping("/ofertas")
	public String listOfertas(Model model) {
		LOG.info("METHOD: listOfertas()");
		model.addAttribute("ofertas",ofertasService.listAllOfertas());
		return ViewConstant.OFERTAS;
	}
	
	@GetMapping("/deleteofertas/{id}")
	public String deleteOfertas(Model model, @PathVariable(name="id")int id) throws Exception {
		LOG.info("METHOD: deleteOfertas()");
		ofertasService.deleteOfertas(id);
		return "redirect:/admin/ofertas";
	}
	
	@GetMapping("/ofertasfilters")
	public String listOfertasFilters(Model model) {
		LOG.info("METHOD: listOfertasFilters()");
		Calendar fecha = new GregorianCalendar();
		System.out.println(fecha);
		List<Ofertas> ofertas = ofertasService.listAll();
		List<Ofertas> ofertasFilter = new ArrayList<Ofertas>();
		for(Ofertas oferta : ofertas) {
			if(fecha.after(filterDate(oferta.getFechaMax()))) {
				ofertasFilter.add(oferta);
			}
		}
		model.addAttribute("ofertas",ofertasFilter);
		return ViewConstant.OFERTAS;
	}

	public static Calendar filterDate(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
}
