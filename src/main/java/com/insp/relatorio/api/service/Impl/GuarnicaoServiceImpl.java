package com.insp.relatorio.api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insp.relatorio.api.model.Guarnicao;
import com.insp.relatorio.api.repository.GuarnicaoRepository;
import com.insp.relatorio.api.service.GuarnicaoService;

@Service
public class GuarnicaoServiceImpl implements GuarnicaoService{
	
	@Autowired
	private GuarnicaoRepository guarnicaoRepository;

	@Override
	public Guarnicao save(Guarnicao guanicao) {		
		return guarnicaoRepository.save(guanicao);
	}

	@Override
	public Optional<Guarnicao> findGuarnicaoById(Long id) {
		Optional<Guarnicao> guarnicaoEncontrada = guarnicaoRepository.findById(id); 
		return guarnicaoEncontrada;
	}

	@Override
	public List<Guarnicao> findGuarnicaoAll() {
		List<Guarnicao> listGuarnicao = guarnicaoRepository.findAll();
		return listGuarnicao;
	}

	@Override  // Depois implemento isso!
	public Guarnicao updateGuarnicao(Guarnicao guanicaoRequest, Long id) {		
		return null;
	}

	@Override  // Depois implemento isso!
	public void deleteGuarnicao(Long id) {		
		
	}

}
