package com.insp.relatorio.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.insp.relatorio.api.model.Guarnicao;
import com.insp.relatorio.api.model.Inspetor;
import com.insp.relatorio.api.model.Servico;
import com.insp.relatorio.api.model.relacional.PassarServico;
import com.insp.relatorio.api.repository.GuarnicaoRepository;
import com.insp.relatorio.api.repository.InspetorRepository;
import com.insp.relatorio.api.repository.PassarServicoRepositoy;
import com.insp.relatorio.api.repository.ServicoRepository;

@Configuration
public class MyTestConfig implements CommandLineRunner{
	
	@Autowired
	private InspetorRepository inspetorRepository;

	@Autowired
	private GuarnicaoRepository guarnicaoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private PassarServicoRepositoy passarServicoRepository;
	
	// Nesse metodo vou salvar algun registros para testes
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Testando Command Line Runner!!");
		
		Inspetor insp1 = new Inspetor(null,"123456", "ALESSANDRO FRANCA", "83998123455", "ALE@GMAIL.COM", "DIA", null, null);
		Inspetor insp2 = new Inspetor(null,"123422", "ALEANDRO FRANCA", "83998143455", "LE@GMAIL.COM", "NOITE", null, null);
		Inspetor insp3 = new Inspetor(null,"123412", "ALISSON FRANCA", "8399812231", "ALI@GMAIL.COM", "NOITE", null, null);
		Inspetor insp4 = new Inspetor(null,"123434", "DARCILENE XAVIER", "83988323455", "DARCI@GMAIL.COM", "DIA", null, null);
		
		inspetorRepository.save(insp1);
		inspetorRepository.save(insp2);
		inspetorRepository.save(insp3);
		inspetorRepository.save(insp4);
		
		// Consigo passar a matricula limpa: Validar isso depois!
		Guarnicao g1 = new Guarnicao(null, "JOAO BATISTA", "PATRULHEIRO", "83988123300", "124358", insp1);
		
		guarnicaoRepository.save(g1);
		
		Servico s1 = new Servico(null, LocalDateTime.parse("2021-02-13T07:00:00"), LocalDateTime.parse("2021-02-13T19:00:00"), "S/A", null);
		
		servicoRepository.save(s1);
		
		PassarServico ps1 = new PassarServico(insp1, s1, "Testando");
		
		passarServicoRepository.save(ps1);
		
	}

}
