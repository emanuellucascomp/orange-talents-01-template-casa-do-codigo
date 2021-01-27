package br.com.wb.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.wb.casadocodigo.config.validacao.UniqueValue;
import br.com.wb.casadocodigo.model.Estado;
import br.com.wb.casadocodigo.model.Pais;
import br.com.wb.casadocodigo.repository.PaisRepository;

public class EstadoForm {
	
	@NotBlank @UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Nome deve ser único")
	private String nome;
	@NotNull
	private Long paisId;
	
	public String getNome() {
		return nome;
	}
	public Long getPaisId() {
		return paisId;
	}
	
	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.getOne(paisId);
		return new Estado(nome, pais);
	}
	
}
