package br.com.wb.casadocodigo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wb.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	Page<Autor> findByNomeContaining(String nome, Pageable paginacao);
}
