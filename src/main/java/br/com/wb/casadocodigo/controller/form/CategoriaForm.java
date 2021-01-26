package br.com.wb.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wb.casadocodigo.config.validacao.UniqueValue;
import br.com.wb.casadocodigo.model.Categoria;

public class CategoriaForm {
	
	@NotBlank @Size(max = 255) @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome deve ser único")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Categoria converter() {
		return new Categoria(nome);
	}
}
