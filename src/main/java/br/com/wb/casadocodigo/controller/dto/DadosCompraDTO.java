package br.com.wb.casadocodigo.controller.dto;

import br.com.wb.casadocodigo.model.DadosCompra;

public class DadosCompraDTO {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String endereco;
	private String complemento;
	private String cidade;
	private Long paisId;
	private Long estadoId;
	private String telefone;
	private String cep;
	
	public DadosCompraDTO(DadosCompra compra) {
		this.id = compra.getId();
		this.nome = compra.getNome();
		this.sobrenome = compra.getSobrenome();
		this.endereco = compra.getEndereco();
		this.complemento = compra.getComplemento();
		this.cidade = compra.getCidade();
		this.paisId = compra.getPais().getId();
		this.estadoId = compra.getEstado().getId();
		this.telefone = compra.getTelefone();
		this.cep = compra.getCep();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}	

}












