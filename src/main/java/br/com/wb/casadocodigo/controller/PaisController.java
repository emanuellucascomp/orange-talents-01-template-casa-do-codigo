package br.com.wb.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.PaisDTO;
import br.com.wb.casadocodigo.controller.form.PaisForm;
import br.com.wb.casadocodigo.model.Pais;
import br.com.wb.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/api/v1/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDTO> cadastrar(@RequestBody @Valid PaisForm paisForm){
		Pais pais = paisForm.converter();
		paisRepository.save(pais);
		
		return ResponseEntity.ok().body(new PaisDTO(pais));
	}

}
