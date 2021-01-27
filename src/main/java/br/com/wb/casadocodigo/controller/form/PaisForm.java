package br.com.wb.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.wb.casadocodigo.config.validacao.UniqueValue;
import br.com.wb.casadocodigo.model.Pais;

public class PaisForm {
	
	@NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Nome deve ser único")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}
}
