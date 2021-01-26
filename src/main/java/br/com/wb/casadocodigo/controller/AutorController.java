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
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.wb.casadocodigo.config.validacao.AutorValidator;
import br.com.wb.casadocodigo.controller.dto.AutorDTO;
import br.com.wb.casadocodigo.controller.form.AutorForm;
import br.com.wb.casadocodigo.model.Autor;
import br.com.wb.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
	
	//TODO verificar uso com entity manager
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private AutorValidator autorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(autorValidator);
	}
	
	@GetMapping
	public Page<AutorDTO> lista(@RequestParam(required = false) String nome, 
			@PageableDefault(sort = "id", 
			direction = Direction.ASC, 
			page = 0,
			size = 10) Pageable paginacao){
		if(nome != null) {
			Page<Autor> autores = autorRepository.findByNomeContaining(nome, paginacao);
			return AutorDTO.converter(autores);
		}
		Page<Autor> autores = autorRepository.findAll(paginacao);
		return AutorDTO.converter(autores);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
		//TODO verificar unicidade do email
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		
		return ResponseEntity.ok().body(new AutorDTO(autor));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> detalhar(@PathVariable Long id){
		Optional<Autor> autor = autorRepository.findById(id);
		if(autor.isPresent()) {
			return ResponseEntity.ok(new AutorDTO(autor.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Autor> autor = autorRepository.findById(id);
		if(autor.isPresent()) {
			autorRepository.deleteById(autor.get().getId());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	

}






