package br.com.wb.casadocodigo.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.DetalheLivroDTO;
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
	
	@GetMapping
	public Page<LivroDTO> lista(@RequestParam(required = false) String titulo, 
			@PageableDefault(sort = "id", 
			direction = Direction.ASC, 
			page = 0,
			size = 10) Pageable paginacao){
		if(titulo != null) {
			Page<Livro> livros = livroRepository.findByTituloContaining(titulo, paginacao);
			return LivroDTO.converter(livros);
		}
		Page<Livro> livros = livroRepository.findAll(paginacao);
		return LivroDTO.converter(livros);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);
		
		return ResponseEntity.ok().body(new LivroDTO(livro));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDTO> detalhar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent()) {
			return ResponseEntity.ok().body(new DetalheLivroDTO(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
