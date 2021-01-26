package br.com.wb.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.CategoriaDTO;
import br.com.wb.casadocodigo.controller.form.CategoriaForm;
import br.com.wb.casadocodigo.model.Categoria;
import br.com.wb.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDTO> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm){
		Categoria categoria = categoriaForm.converter();
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok().body(new CategoriaDTO(categoria));
	}

}







