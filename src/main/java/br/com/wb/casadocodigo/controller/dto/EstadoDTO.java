package br.com.wb.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Estado;

public class EstadoDTO {
	
	private Long id;
	private String nome;
	private Long paisId;
	
	public EstadoDTO(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.paisId = estado.getPais().getId();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	public static Page<EstadoDTO> converter(Page<Estado> estados){
		return estados.map(EstadoDTO::new);
	}
}
