package com.insp.relatorio.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insp.relatorio.api.model.Servico;
import com.insp.relatorio.api.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	
	// Poderia ter os dois paths: Um para salvar um unico servico e outro para salvar um servico com inspetor ??
	@PostMapping("/{id}") // exemplo Path: "/servicos/{id}
	public ResponseEntity<Servico> saveRest(@Valid @RequestBody Servico servico, @PathVariable Long id){		
		Servico servicoSalvo = servicoService.save(servico, id);
		return ResponseEntity.ok().body(servicoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Servico>> findRest(@PathVariable Long id){
		Optional<Servico> servicoEncontrado = servicoService.findServicoById(id);
		return ResponseEntity.ok().body(servicoEncontrado);
	}
	
	@GetMapping
	public ResponseEntity<List<Servico>> findAllRest(){
		List<Servico> listServico = servicoService.findServicoAll();
		return ResponseEntity.ok().body(listServico);
	}
		
	// Depois ver como fazer fazer a lógica de alterar Servico
	
	// Não fazer por enquanto o Delete
	
		
}
