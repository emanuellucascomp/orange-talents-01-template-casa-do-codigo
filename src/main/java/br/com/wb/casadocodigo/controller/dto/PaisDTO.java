package br.com.wb.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Pais;

public class PaisDTO {
	
	private Long id;
	private String nome;
	
	public PaisDTO(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static Page<PaisDTO> converter(Page<Pais> paises){
		return paises.map(PaisDTO::new);
	}
}
