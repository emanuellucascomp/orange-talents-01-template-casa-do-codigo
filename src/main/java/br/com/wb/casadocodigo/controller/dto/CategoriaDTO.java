package br.com.wb.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Categoria;

public class CategoriaDTO {
	
	private Long id;
	private String nome;
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static Page<CategoriaDTO> converter(Page<Categoria> categorias){
		return categorias.map(CategoriaDTO::new);
	}

}
