package com.gestion.ecole.backend;

import com.gestion.ecole.backend.models.securityModels.Utilisateur;
import com.gestion.ecole.backend.service.securityService.CompteService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class GestionEcoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEcoleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	/*@Bean
	CommandLineRunner runner(CompteService compteService){
		return args -> {
			compteService.AddUser(new Utilisateur(null,"professeur",,new ArrayList<>()));
			compteService.AddUser(new Utilisateur(null,"professeur2",,new ArrayList<>()));
			compteService.AddUser(new Utilisateur(null,"admin",,new ArrayList<>()));
			compteService.AddUser(new Utilisateur(null,"etudiant",,new ArrayList<>()));
		};
	}*/

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
