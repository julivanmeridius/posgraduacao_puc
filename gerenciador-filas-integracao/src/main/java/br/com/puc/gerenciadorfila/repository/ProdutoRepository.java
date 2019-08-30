package br.com.puc.gerenciadorfila.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.gerenciadorfila.model.Produto;

/**
* <p>
* 
* <strong>Descricao: </strong>
* Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
* Curso: Arquitetura de Solucoes
* 
* @author Julivan Barbosa da Silva
**/
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Page<Produto> findByNomeContaining(String nome, Pageable pageable);
	
}