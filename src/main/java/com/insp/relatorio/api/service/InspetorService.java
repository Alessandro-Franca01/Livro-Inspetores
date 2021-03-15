package com.insp.relatorio.api.service;

import java.util.List;
import java.util.Optional;

import com.insp.relatorio.api.model.Inspetor;

public interface InspetorService {
	
	public Inspetor save(Inspetor inspetor);
	
	public Optional<Inspetor> findInspById(Long id);
	
	public List<Inspetor> findInspAll(); 
	
	public Inspetor updateInsp(Inspetor inspetorRequest, Long id);
	
	public void deleteInsp(Long id); 

}
