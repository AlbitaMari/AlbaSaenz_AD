package com.ad.gestionOfertas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ad.gestionOfertas.constant.ViewConstant;
import com.ad.gestionOfertas.entities.Ofertas;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.models.UsuariosModel;
import com.ad.gestionOfertas.services.OfertasService;
import com.ad.gestionOfertas.services.UsuariosService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private OfertasService ofertasService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/editUser")
	public String userUpdateForm(HttpSession session,Authentication auth,Model model)throws Exception {
		LOG.info("METHOD: editUserForm()");
		String email = auth.getName();
		Usuarios usuario = usuariosService.findUserByEmail(email);
		session.setAttribute("usuario",usuario);
		model.addAttribute("usuario",usuario);
		model.addAttribute("editMode",true);
		
		return ViewConstant.CONTACT_FORM;
	}
	
	@PostMapping("/editUser/edit")
	public String editUser(@Valid @ModelAttribute("usuario") Usuarios usuario,Model model)throws Exception {
		LOG.info("METHOD: editUser() -- PARAMS: " + usuario.toString());
		usuario.setEnabled(true);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuariosService.editUser(usuariosService.transform(usuario));
		
		return "redirect:/public/index";
	}
	
	@GetMapping("/ofertas")
	public String listOfertas(Model model,Authentication auth, HttpSession session) {
		LOG.info("METHOD: listOfertas()");
		String username = auth.getName();
		Usuarios usuario = usuariosService.findUserByEmail(username);
		session.setAttribute("usuario", usuario);
		
		model.addAttribute("ofertas",ofertasService.listAllOfertasByRrhh(usuariosService.transform(usuario)));
		return ViewConstant.OFERTAS;
	}
}
