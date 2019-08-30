package br.com.puc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.api.entidade.Categoria;

/**
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS
 * 
 * @author Julivan Barbosa da Silva
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
