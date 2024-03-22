package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebConfig {

	@Bean
	UserDetailsManager userDetailsManager() {
		UserDetails user1 = User
				.withUsername("admin")
				.password(encoder().encode("admin"))
				.roles("ADMIN","USER")
				.build();
		UserDetails user2 = User
				.withUsername("Hemu")
				.password(encoder().encode("hemu"))
				.roles("ADMIN")
				.build();
	   return  new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception{
		return http
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests((auth)-> auth
						.requestMatchers("/api/user/**").hasAnyRole("USER","ADMIN")
						.requestMatchers("/api/admin/**").hasAnyRole("ADMIN")
						.anyRequest().authenticated()
				)
				.sessionManagement(sess->sess.sessionCreationPolicy(
						SessionCreationPolicy.STATELESS))
						.httpBasic(Customizer.withDefaults())
						.build();
	}
}
    