package com.insp.relatorio.api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insp.relatorio.api.model.Inspetor;
import com.insp.relatorio.api.repository.InspetorRepository;
import com.insp.relatorio.api.service.InspetorService;

@Service
public class InspetorServiceImpl implements InspetorService{
	
	@Autowired
	private InspetorRepository inspetorRepository;

	@Override
	public Inspetor save(Inspetor inspetor) {
		return inspetorRepository.save(inspetor);
	}

	@Override
	public Optional<Inspetor> findInspById(Long id) {		
		Optional<Inspetor> inspEncontrado = inspetorRepository.findById(id);
		return inspEncontrado;
	}

	@Override
	public List<Inspetor> findInspAll() {	
		return inspetorRepository.findAll();
	}

	@Override
	public Inspetor updateInsp(Inspetor inspetorRequest, Long id) {
		inspetorRequest.setId(id);
		// Tem que fazer a validação ainda!!!
		return inspetorRepository.save(inspetorRequest);
	}

	@Override
	public void deleteInsp(Long id) {
		inspetorRepository.deleteById(id);
	}
	
}
