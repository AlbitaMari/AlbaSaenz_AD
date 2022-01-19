package com.ad.gestionOfertas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**","/assets/**","/css/**","/js/**","/public/**","/auth/**","/logout").permitAll().anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/auth/login").usernameParameter("email").defaultSuccessUrl("/public/index",true).failureUrl("/auth/login?error")
				.loginProcessingUrl("/auth/login-post").permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/public/logout")
			.and()
				.logout().logoutSuccessUrl("/public?logout");	
	}	

}
