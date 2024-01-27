package com.muthu.news.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.muthu.news.SecretManager;

@Configuration
@EnableWebSecurity
public class MuthuNewsSecurityConfig {

	@Autowired
	private SecretManager manager;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(manager.getAdSec()).password(passwordEncoder().encode(manager.getAdPs()))
				.roles("ADMIN");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
	        .authorizeHttpRequests((requests) -> requests
	            .requestMatchers(new AntPathRequestMatcher("/loginpage")).permitAll()
	            .requestMatchers(new AntPathRequestMatcher("/login**")).permitAll()
	            .requestMatchers(new AntPathRequestMatcher("/pay/**")).permitAll()
	            .requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
	            .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
	            .anyRequest().authenticated()) //other URLs are only allowed authenticated users.
	     /*   .logout(logout -> logout
	                .logoutUrl("/admin/logout")
	                .addLogoutHandler(new SecurityContextLogoutHandler())
	              ) */
	        .httpBasic();
		// http.sessionManagement(httpSecuritySessionManagementConfigurer -> 
         //httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
	    return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
