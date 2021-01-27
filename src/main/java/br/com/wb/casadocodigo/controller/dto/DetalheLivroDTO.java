package br.com.wb.casadocodigo.controller.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import br.com.wb.casadocodigo.model.Livro;

public class DetalheLivroDTO {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Long autorId;
	private String isbn;
	private Integer paginas;

	public DetalheLivroDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.autorId = livro.getAutor().getId();
		this.isbn = livro.getIsbn();
		this.paginas = livro.getPaginas();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Long getAutorId() {
		return autorId;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getPaginas() {
		return paginas;
	}
	
	public static Page<DetalheLivroDTO> converter(Page<Livro> livros){
		return livros.map(DetalheLivroDTO::new);
	}
}
