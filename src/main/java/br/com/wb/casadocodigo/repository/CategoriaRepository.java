package br.com.wb.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wb.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
