package br.com.wb.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wb.casadocodigo.controller.dto.DadosCompraDTO;
import br.com.wb.casadocodigo.controller.form.DadosCompraForm;
import br.com.wb.casadocodigo.model.DadosCompra;
import br.com.wb.casadocodigo.repository.EstadoRepository;
import br.com.wb.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/api/v1/compra")
public class DadosCompraController {
	
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosCompraDTO> cadastrar(@RequestBody @Valid DadosCompraForm compraForm){
		DadosCompra compra = compraForm.converter(paisRepository, estadoRepository);
		
		return ResponseEntity.ok().body(new DadosCompraDTO(compra));
	}

}
