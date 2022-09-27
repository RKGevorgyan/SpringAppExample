package ru.stc.springbootdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public void authConfigure(AuthenticationManagerBuilder auth,
	                          UserAuthService userAuthService,
	                          PasswordEncoder encoder) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("mem_user")
				.password(encoder.encode("password"))
				.roles("ADMIN");

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userAuthService);
		provider.setPasswordEncoder(encoder);
		auth.authenticationProvider(provider);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/person/**")
				.hasRole("GUEST")
				.antMatchers("/admin/**")
				.hasAnyRole("ADMIN")
				.antMatchers("/user/**")
				.hasAnyRole("USER", "ADMIN")
				.antMatchers("/login/**")
				.anonymous()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}

	// asdsddfsss
}
