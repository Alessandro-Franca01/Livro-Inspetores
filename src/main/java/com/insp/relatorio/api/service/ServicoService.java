package com.insp.relatorio.api.service;

import java.util.List;
import java.util.Optional;

import com.insp.relatorio.api.model.Servico;

public interface ServicoService {
	
	public Servico save(Servico servico, Long idInpetor);
	
	public Optional<Servico> findServicoById(Long id);
	
	public List<Servico> findServicoAll(); 
	
	public Servico updateServico(Servico servicoRequest, Long id);
	
	public void deleteServico(Long id); 

}
