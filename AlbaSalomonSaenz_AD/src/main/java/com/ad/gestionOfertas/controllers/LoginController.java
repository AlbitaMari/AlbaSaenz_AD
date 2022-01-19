package com.ad.gestionOfertas.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ad.gestionOfertas.constant.ViewConstant;
import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.services.impl.UsuariosServiceImpl;


@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@Autowired
	@Qualifier("usuariosServiceImpl")
	private UsuariosServiceImpl usuariosService;
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/auth/login";
	}
	
	@GetMapping("/auth/registro")
	public ModelAndView registerForm() {
		ModelAndView mav = new ModelAndView(ViewConstant.REGISTER);
		mav.addObject("usuario", new Usuarios());
		return mav;
	}
	
	@PostMapping("/auth/registro")
	public String registerUser(@Valid @ModelAttribute Usuarios usuarios) {
		LOG.info("METHOD: registerUser() -- PARAMS: " + usuarios.toString());
		if(usuariosService.findUserByEmail(usuarios.getEmail())==null) {
			usuarios.setEnabled(false);
			usuarios.setRole("ROL_ALUMNO");
			usuariosService.registerUser(usuariosService.transform(usuarios));
			return "redirect:/auth/login";
		}else {
			return "redirect:/auth/registro";
		}
	}
			
	@GetMapping("/auth/login")
	public String login(Model model, @RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout) {
		model.addAttribute("usuario",new Usuarios());
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		return ViewConstant.LOGIN;
	}

}
