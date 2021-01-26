package br.com.wb.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wb.casadocodigo.model.Autor;

public class AutorForm {
	
	@NotBlank @Size(max = 255)
	private String nome;
	@Email @NotBlank @Size(max = 255)
	private String email;
	@NotBlank @Size(max = 400)
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
