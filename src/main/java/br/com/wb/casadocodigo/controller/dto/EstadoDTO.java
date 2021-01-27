package br.com.wb.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Estado;

public class EstadoDTO {
	
	private Long id;
	private String nome;
	private String pais;
	
	public EstadoDTO(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = estado.getPais().getNome();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}
	
	public static Page<EstadoDTO> converter(Page<Estado> estados){
		return estados.map(EstadoDTO::new);
	}
}
