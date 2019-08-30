package br.com.puc.api.service;

import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.puc.api.entidade.Produto;
import br.com.puc.api.repository.ProdutoRepository;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe Service que sera utilizada para atividades de Produto.
 * 
 * @author Julivan Barbosa da Silva
 */
@Service
public class ProdutoService {
	
	private final Logger logger = LogManager.getLogger(ProdutoService.class);
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		logger.info("Executando Metodo: salvar() --> Produto: " + produto);
		return produtoRepository.save(produto);
	}

	public Produto atualizar(Long codigo, Produto produto) {
		logger.info("Executando Metodo: atualizar() --> Codigo: " + codigo + " Produto: " + produto);
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);		
		BeanUtils.copyProperties(produto, produtoSalvo, "codigo");
		return produtoRepository.save(produtoSalvo);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		logger.info("Executando Metodo: atualizarPropriedadeAtivo() --> Codigo: " + codigo + " Boolean: " + ativo);
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
		produtoSalvo.setAtivo(ativo);
		produtoRepository.save(produtoSalvo);
	}
	
	public Produto buscarProdutoPeloCodigo(Long codigo) {
		logger.info("Executando Metodo: buscarProdutoPeloCodigo() --> Codigo: " + codigo);
		Optional<Produto> produtoSalva = produtoRepository.findById(codigo);
		if (!produtoSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalva.get();
	}
}