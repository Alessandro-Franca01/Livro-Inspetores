package com.insp.relatorio.api.model.relacional.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.insp.relatorio.api.model.Inspetor;
import com.insp.relatorio.api.model.Servico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PassarServicoPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name ="id_inspetor") 
	private Inspetor inspetorId;
	
	@ManyToOne
	@JoinColumn(name ="id_servico")
	private Servico servicoId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inspetorId == null) ? 0 : inspetorId.hashCode());
		result = prime * result + ((servicoId == null) ? 0 : servicoId.hashCode());
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
		PassarServicoPk other = (PassarServicoPk) obj;
		if (inspetorId == null) {
			if (other.inspetorId != null)
				return false;
		} else if (!inspetorId.equals(other.inspetorId))
			return false;
		if (servicoId == null) {
			if (other.servicoId != null)
				return false;
		} else if (!servicoId.equals(other.servicoId))
			return false;
		return true;
	}
	
}
