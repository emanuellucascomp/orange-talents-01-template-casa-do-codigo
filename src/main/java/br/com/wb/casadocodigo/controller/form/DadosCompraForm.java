package br.com.wb.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.wb.casadocodigo.model.DadosCompra;
import br.com.wb.casadocodigo.model.Estado;
import br.com.wb.casadocodigo.model.Pais;
import br.com.wb.casadocodigo.repository.EstadoRepository;
import br.com.wb.casadocodigo.repository.PaisRepository;

public class DadosCompraForm {
	
	@NotBlank @Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	private Long paisId;
	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getDocumento() {
		return documento;
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
	
	public DadosCompra converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.getOne(paisId);
		Estado estado = estadoRepository.getOne(estadoId);
		
		return new DadosCompra(email, nome, sobrenome, documento, endereco,
			complemento, cidade, pais, estado, telefone, cep);
	}
	

}
