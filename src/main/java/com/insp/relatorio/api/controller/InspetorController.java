package com.insp.relatorio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insp.relatorio.api.model.Inspetor;
import com.insp.relatorio.api.service.InspetorService;

@RestController
@RequestMapping("/inspetores")
public class InspetorController {

	@Autowired
	private InspetorService inspetorService;
	
	// METODO DE SALVAR: FUNCIONANDO
	@PostMapping
	public ResponseEntity<Inspetor> saveRest(@Valid @RequestBody Inspetor inspetor){
		Inspetor insptSalvo = inspetorService.save(inspetor);
		System.out.println(inspetor);
		return ResponseEntity.ok().body(insptSalvo);
	}
	
	// METODO DE BUSCAR TODOS: FUNCIONANDO
	@GetMapping
	public ResponseEntity<List<Inspetor>> listAll(){
		List<Inspetor> listInspt = inspetorService.findInspAll();
		return ResponseEntity.ok().body(listInspt);
	}
	
	// METODO DE BUSCAR UM: FUNCIONNAO
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Inspetor>> findOneInsptById(@PathVariable Long id){
		Optional<Inspetor> inspetor = inspetorService.findInspById(id);
		return ResponseEntity.ok().body(inspetor);
	}
	
	// METODO DE REMOVER: 
	@DeleteMapping("/{id}")
	public void deleteInsptById(@PathVariable Long id) {
		inspetorService.deleteInsp(id);
	}
	
	// METODO DE ALTERAR:
	@PutMapping("/{id}")
	public ResponseEntity<Inspetor> updateInspt(@PathVariable Long id, @RequestBody Inspetor inspetorResquest){
		inspetorResquest.setId(id);
		Inspetor inspetorSaved = inspetorService.save(inspetorResquest);
		return ResponseEntity.ok().body(inspetorSaved);
	}
	
	
}
