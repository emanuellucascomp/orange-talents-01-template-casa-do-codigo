package br.com.wb.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.AutorDTO;
import br.com.wb.casadocodigo.controller.form.AutorForm;
import br.com.wb.casadocodigo.model.Autor;
import br.com.wb.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorForm autorForm){
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		
		return ResponseEntity.ok().body(new AutorDTO(autor));
	}	

}






