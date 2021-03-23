package com.insp.relatorio.api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insp.relatorio.api.model.Inspetor;
import com.insp.relatorio.api.model.Servico;
import com.insp.relatorio.api.model.relacional.PassarServico;
import com.insp.relatorio.api.repository.InspetorRepository;
import com.insp.relatorio.api.repository.PassarServicoRepositoy;
import com.insp.relatorio.api.repository.ServicoRepository;
import com.insp.relatorio.api.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService{
	
	@Autowired
	private ServicoRepository serviceRepository;
	
	@Autowired
	private PassarServicoRepositoy passarServicoRepository;
	
	@Autowired
	private InspetorRepository inspetorRepository;

	// Esse end-point: Está errado pq só consigo passar um Inspetor!
	@Override
	public Servico save(Servico servico, Long idInpetor) {
		Servico servicoSalvo = serviceRepository.save(servico);
		Optional<Inspetor> inpBuscado = inspetorRepository.findById(idInpetor);
		String test = "Testando Relação";
		// Essa Passagem de Servico não pode ficar assim hardcode
		/*
		 * Tenho que criar um service de PassarServico
		 * Depois posso injetar aqui ???
		 */
		PassarServico ps = new PassarServico(inpBuscado.get(), servicoSalvo, test);
		PassarServico psSalvo = passarServicoRepository.save(ps);
		return servicoSalvo;
				
	}

	@Override
	public Optional<Servico> findServicoById(Long id) {		
		Optional<Servico> servicoEncontrado = serviceRepository.findById(id);
		return servicoEncontrado;
	}

	// Esse metodo está entrando em lopping: Arruamr isso!
	@Override
	public List<Servico> findServicoAll() {	
		return serviceRepository.findAll();
	}

	@Override
	public Servico updateServico(Servico servicoRequest, Long id) {
		servicoRequest.setId(id);
		return serviceRepository.save(servicoRequest);
	}

	@Override
	public void deleteServico(Long id) {
		serviceRepository.deleteById(id);
	}
	
}
