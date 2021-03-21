package com.insp.relatorio.api.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.insp.relatorio.api.model.relacional.PassarServico;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_SERVICO")
public class Servico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Erro nas Data: Funcionou !!!	
	private LocalDateTime inicio;
	
	private LocalDateTime fim;
	
	private String observacao;
	
	// Deu erro por causa de uma "letra maiuscula"
	@OneToMany(mappedBy = "id.servicoId")
	private Set<PassarServico> passarServico = new HashSet<>();
	
	// Ainda não deu certo!!
	public Servico(Long id, LocalDateTime inicio, LocalDateTime fim, String observacao, Set<PassarServico> passarServico) {
		super();
		this.id = null;		
		this.observacao = observacao;
		this.passarServico = passarServico;
		this.inicio = inicio;
		this.fim = fim;
	}

	@Override 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

}
