package br.com.wb.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.EstadoDTO;
import br.com.wb.casadocodigo.controller.form.EstadoForm;
import br.com.wb.casadocodigo.model.Estado;
import br.com.wb.casadocodigo.repository.EstadoRepository;
import br.com.wb.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/api/v1/estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDTO> cadastrar(@RequestBody @Valid EstadoForm estadoForm){
		Estado estado = estadoForm.converter(paisRepository);
		estadoRepository.save(estado);
		
		return ResponseEntity.ok().body(new EstadoDTO(estado));
	}
}
