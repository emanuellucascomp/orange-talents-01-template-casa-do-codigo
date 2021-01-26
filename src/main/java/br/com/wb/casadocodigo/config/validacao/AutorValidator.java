package br.com.wb.casadocodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.wb.casadocodigo.controller.form.AutorForm;
import br.com.wb.casadocodigo.model.Autor;
import br.com.wb.casadocodigo.repository.AutorRepository;

@Component
public class AutorValidator  implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm request = (AutorForm) target;
		Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
		
		if(autor.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado no sistema: " + request.getEmail());
		}
	}

}
