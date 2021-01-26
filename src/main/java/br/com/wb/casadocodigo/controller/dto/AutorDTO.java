package br.com.wb.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Autor;

public class AutorDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	
	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Page<AutorDTO> converter(Page<Autor> autores){
		return autores.map(AutorDTO::new);
	}

}
