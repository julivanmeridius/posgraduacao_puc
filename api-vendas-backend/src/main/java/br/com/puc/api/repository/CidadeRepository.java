package br.com.puc.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.api.entidade.Cidade;

/**
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS
 * 
 * @author Julivan Barbosa da Silva
 */
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	List<Cidade> findByEstadoCodigo(Long estadoCodigo);
}
