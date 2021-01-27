package br.com.wb.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String titulo;
	@Column(nullable = false)
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@DecimalMin(value = "20.0", inclusive = true)
	private BigDecimal preco;
	@Min(100)
	private Integer paginas;
	@Column(unique = true, nullable = false)
	private String isbn;
	private LocalDate dataEntrada;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Autor autor;
	
	public Livro() {
		
	}

	public Livro(String titulo, @Size(max = 500) String resumo, String sumario,
			@DecimalMin(value = "20.0", inclusive = true) BigDecimal preco, @Min(100) Integer paginas, String isbn,
			LocalDate dataEntrada, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataEntrada = dataEntrada;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
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

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}	
	
	
}
