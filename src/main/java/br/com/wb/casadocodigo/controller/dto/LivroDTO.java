package br.com.wb.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Livro;

public class LivroDTO {
	
	private Long id;
	private String titulo;
	
	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public static Page<LivroDTO> converter(Page<Livro> livros){
		return livros.map(LivroDTO::new);
	}
	
	
	
}
