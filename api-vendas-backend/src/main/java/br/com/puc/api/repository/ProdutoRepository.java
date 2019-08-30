package br.com.puc.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.api.entidade.Produto;

/**
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS
 * 
 * @author Julivan Barbosa da Silva
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Page<Produto> findByNomeContaining(String nome, Pageable pageable);
}