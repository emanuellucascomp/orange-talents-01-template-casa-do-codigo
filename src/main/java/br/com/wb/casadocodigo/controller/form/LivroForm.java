package br.com.wb.casadocodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import br.com.wb.casadocodigo.config.validacao.UniqueValue;
import br.com.wb.casadocodigo.model.Autor;
import br.com.wb.casadocodigo.model.Categoria;
import br.com.wb.casadocodigo.model.Livro;
import br.com.wb.casadocodigo.repository.AutorRepository;
import br.com.wb.casadocodigo.repository.CategoriaRepository;

public class LivroForm {
	
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título deve ser único")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private Integer paginas;
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN deve ser único")
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataEntrada;
	@NotNull
	private Long categoriaId;
	@NotNull
	private Long autorId;
	
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
	public Integer getPaginas() {
		return paginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public Long getAutorId() {
		return autorId;
	}
	
	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		@NotNull Categoria categoria = categoriaRepository.getOne(categoriaId);
		@NotNull Autor autor = autorRepository.getOne(autorId);
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataEntrada, categoria, autor);
	}
	
	
}








