package br.com.wb.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.wb.casadocodigo.model.Autor;
import br.com.wb.casadocodigo.repository.AutorRepository;

public class AutorForm {
	
	@NotNull @NotEmpty @Size(min = 5, max = 255)
	private String nome;
	@Email @NotNull @NotEmpty @Size(min = 5, max = 255)
	private String email;
	@NotNull @NotEmpty @Size(min = 5, max = 400)
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public Autor converter() {
		return new Autor(nome, email, descricao);
	}	
	
}
