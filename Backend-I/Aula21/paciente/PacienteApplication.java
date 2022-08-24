package com.example.paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@RestController
public class PacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteApplication.class, args);
	}

	@GetMapping
	public HashMap<String,String> Hello(){
		Paciente p1 = new Paciente("João da Silva", "13115585742");

		HashMap<String,String> resp = new HashMap<>();
		resp.put("nome", p1.getNome());
		resp.put("cpf", p1.getCpf());

		return resp;
	}
}
