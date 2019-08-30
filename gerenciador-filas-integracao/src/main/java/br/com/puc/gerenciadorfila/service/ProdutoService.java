package br.com.puc.gerenciadorfila.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import br.com.puc.gerenciadorfila.model.Produto;
import br.com.puc.gerenciadorfila.repository.ProdutoRepository;

/**
* <p>
* 
* <strong>Descricao: </strong>
* Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
* Curso: Arquitetura de Solucoes
* 
* @author Julivan Barbosa da Silva
**/
@Service
public class ProdutoService {
	
	private static Logger log = LoggerFactory.getLogger(ProdutoService.class);
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		log.info("Executando Metodo: salvar()");
		return produtoRepository.save(produto);
	}

	public Produto atualizar(Long codigo, Produto produto) {
		log.info("Executando Metodo: atualizar()");		
		
		StopWatch sw = new StopWatch("TempoDeExecucaoMetodoAtualizarProduto");		
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);		
		
		log.info("Realizando copia de dados do Bean salvo para o Bean da memoria");
		BeanUtils.copyProperties(produto, produtoSalvo, "codigo");
		
		log.info("Salvando as informacoes do Produto na base de dados...");
		sw.stop();
		
		log.info(sw.prettyPrint());
		return produtoRepository.save(produtoSalvo);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		log.info("Executando Metodo: atualizarPropriedadeAtivo()");
		
		StopWatch sw = new StopWatch("TempoDeExecucaoMetodoAtualizarPropriedadeAtivo");
		
		Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
		produtoSalvo.setAtivo(ativo);
		produtoRepository.save(produtoSalvo);
		
		sw.stop();		
		log.info(sw.prettyPrint());
	}
	
	public Produto buscarProdutoPeloCodigo(Long codigo) {
		log.info("Executando Metodo: buscarProdutoPeloCodigo()");
		
		StopWatch sw = new StopWatch("TempoDeExecucaoMetodoBuscarProdutoPeloCodigo");
		Optional<Produto> produtoSalva = produtoRepository.findById(codigo);
		if (!produtoSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		sw.stop();
		log.info(sw.prettyPrint());
		
		return produtoSalva.get();
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
}
