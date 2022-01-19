package com.ad.gestionOfertas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ad.gestionOfertas.entities.Usuarios;
import com.ad.gestionOfertas.repositories.UsuariosRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	@Qualifier("usuariosRepository")
	private UsuariosRepository usuariosRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 Usuarios usuario = usuariosRepository.findUserByEmail(email);
			UserBuilder builder = null;

			if(usuario != null) {
				builder = User.withUsername(email);
				builder.disabled(false);
				builder.password(usuario.getPassword());
				builder.authorities(usuario.getRole());
			}else {
				throw new UsernameNotFoundException("Usuario no encontrado");
			}
			return builder.build();
		}
}
