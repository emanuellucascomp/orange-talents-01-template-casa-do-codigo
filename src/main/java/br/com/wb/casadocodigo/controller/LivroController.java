package br.com.wb.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.LivroDTO;
import br.com.wb.casadocodigo.controller.form.LivroForm;
import br.com.wb.casadocodigo.model.Livro;
import br.com.wb.casadocodigo.repository.AutorRepository;
import br.com.wb.casadocodigo.repository.CategoriaRepository;
import br.com.wb.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);
		
		return ResponseEntity.ok().body(new LivroDTO(livro));
		
	}

}
