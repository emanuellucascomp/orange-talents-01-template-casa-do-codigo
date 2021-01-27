package br.com.wb.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wb.casadocodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
