package com.insp.relatorio.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insp.relatorio.api.model.relacional.PassarServico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_inspetor")
public class Inspetor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// AQUI: Vou ter que criar as DTOs(Response/Request)
	// Fazer os deletes logicos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	// Esse campo ainda pode receber Strings vazias
	@Column(nullable = false, name = "CK_MATRICULA", length = 6, unique= true)
	private String matricula;
	
	@Column(nullable = false, name = "NOME")
	private String nome;
	
	@Column(name = "TELEFONE", length = 11)
	private String telefone;
	
	//@NotNull e @NotBlank NAO FUNCIONARAM!!! Depois dá uma olhada nisso.
	private String email;
	
	private String turno;
	
	@OneToMany(mappedBy = "inspetor")
	private List<Guarnicao> guarnicao = new ArrayList<>();
	
	@JsonIgnore // Testar Amanha!!!
	@OneToMany(mappedBy = "id.inspetorId")
	private Set<PassarServico> passarServico = new HashSet<>();
	
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
		Inspetor other = (Inspetor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
