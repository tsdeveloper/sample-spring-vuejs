package com.tsdeveloper.github.samplespringvuejs;

import com.tsdeveloper.github.samplespringvuejs.config.CustomUserDetails;
import com.tsdeveloper.github.samplespringvuejs.entities.Role;
import com.tsdeveloper.github.samplespringvuejs.entities.User;
import com.tsdeveloper.github.samplespringvuejs.repositories.UserRepository;
import com.tsdeveloper.github.samplespringvuejs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SampleSpringVuejsApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringVuejsApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository, UserService userService) throws Exception{

		if(userRepository.count() == 0)
			userService.insert(new User("user","password", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));

		builder.userDetailsService(userDetailsService(userRepository)).passwordEncoder(passwordEncoder);
	}

	private UserDetailsService userDetailsService(final UserRepository userRepository) {
		return username -> new CustomUserDetails(userRepository.findByUserName(username));
	}

//	private
}
