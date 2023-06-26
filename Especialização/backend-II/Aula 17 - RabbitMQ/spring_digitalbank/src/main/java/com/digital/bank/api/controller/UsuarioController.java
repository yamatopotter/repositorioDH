package com.digital.bank.api.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@EnableDiscoveryClient
@RestController
@CrossOrigin (value = "*")
public class UsuarioController {

	@Value("${queue.mail}")
	private String queue;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/usuarios")
	public ResponseEntity<List<String>> getUsuarios() {
		return ResponseEntity.ok().body(Arrays.asList("Jesus", "Maria", "José"));
	}

	@GetMapping("/mail/{user}")
	public void sendMail(){
		rabbitTemplate.convertAndSend(queue, "Nova mensagem");
	}
}
