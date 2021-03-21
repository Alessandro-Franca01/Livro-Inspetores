package com.insp.relatorio.api.model.relacional;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.insp.relatorio.api.model.Inspetor;
import com.insp.relatorio.api.model.Servico;
import com.insp.relatorio.api.model.relacional.pks.PassarServicoPk;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBR_PASSAR_SERVICO")
public class PassarServico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PassarServicoPk id = new PassarServicoPk();
	
	private String descricao;
	
	public PassarServico(Inspetor inspetor, Servico servico, String descricao) {
		id.setInspetorId(inspetor);
		id.setServicoId(servico);
		this.descricao = descricao;
	}

}
