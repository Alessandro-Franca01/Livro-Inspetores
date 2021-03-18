package com.insp.relatorio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insp.relatorio.api.model.Guarnicao;
import com.insp.relatorio.api.service.GuarnicaoService;

@RestController
@RequestMapping("/guarnicao")
public class GuarnicaoController {
	
	@Autowired
	private GuarnicaoService guarnicaoService;
	
	@PostMapping // Testar
	public ResponseEntity<Guarnicao> saveRest(@Valid @RequestBody Guarnicao guarnicaoResquet){
		Guarnicao guarnicaoSalva = guarnicaoService.save(guarnicaoResquet);
		return ResponseEntity.ok().body(guarnicaoSalva); // Mudar o status para CREATE (201)
	}
	
	@GetMapping
	public ResponseEntity<List<Guarnicao>> findGuarnicaoAll(){
		List<Guarnicao> listGuarnicao = guarnicaoService.findGuarnicaoAll();
		return ResponseEntity.ok().body(listGuarnicao);
	}

}
