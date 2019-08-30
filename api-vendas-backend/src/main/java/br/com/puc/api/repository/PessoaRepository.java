package br.com.puc.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.api.entidade.Pessoa;

/**
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS
 * 
 * @author Julivan Barbosa da Silva
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}
