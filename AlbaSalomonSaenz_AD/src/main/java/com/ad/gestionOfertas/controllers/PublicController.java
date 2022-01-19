package com.ad.gestionOfertas.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ad.gestionOfertas.constant.ViewConstant;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.services.UsuariosService;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping("/index")
	public String index(Authentication auth, HttpSession session) {
		
		String email = auth.getName();
		
		if(session.getAttribute("usuario")==null) {
			Usuarios usuario = usuariosService.findUserByEmail(email);
			usuario.setPassword(null);
			session.setAttribute("usuario",usuario);
		}
		return ViewConstant.INDEX;
	}
	
	@GetMapping("/logout")
	public String logoutUser() {
		return ViewConstant.LOGOUT;
	}

	
}
