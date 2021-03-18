package com.insp.relatorio.api.service;

import java.util.List;
import java.util.Optional;

import com.insp.relatorio.api.model.Guarnicao;

public interface GuarnicaoService {
	
	public Guarnicao save(Guarnicao guanicao);
	
	public Optional<Guarnicao> findGuarnicaoById(Long id);
	
	public List<Guarnicao> findGuarnicaoAll(); 
	
	public Guarnicao updateGuarnicao(Guarnicao guanicaoRequest, Long id);
	
	public void deleteGuarnicao(Long id); 

}
