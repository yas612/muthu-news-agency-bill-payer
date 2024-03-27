package com.muthu.news.security;

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
import com.muthu.news.constants.MuthuConstants;

@Configuration
@EnableWebSecurity
public class MuthuNewsSecurityConfig {

	@Autowired
	private SecretManager manager;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(manager.getAdSec()).password(passwordEncoder().encode(manager.getAdPs()))
				.roles(MuthuConstants.ADMIN_ROLE);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.LOGIN_PAGE_EXCLUDE)).permitAll()
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.LOGIN_PATH_EXCLUDE)).permitAll()
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.PAYMENT_PATH_EXCLUDE)).permitAll()
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.PAYMENT_VERIFY_EXCLUDE)).permitAll()
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.HOME_PATH_EXCLUDE)).permitAll()
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.RESOURCES_EXCLUDE)).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/files/**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/files/img/**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/files/img**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/files/img/loginpage.jpg")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/img/loginpage.jpg")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/files/img/logo.png")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/img/logo.png")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/img/**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/resources/img**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/img**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher("/img/**")).permitAll()
						.requestMatchers(new AntPathRequestMatcher(MuthuConstants.ADMIN_PATH))
						.hasRole(MuthuConstants.ADMIN_ROLE).anyRequest().authenticated()) // other URLs are only allowed
				.httpBasic();
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
