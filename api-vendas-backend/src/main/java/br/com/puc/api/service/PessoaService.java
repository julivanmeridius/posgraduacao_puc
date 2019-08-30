package br.com.puc.api.service;

import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.puc.api.entidade.Pessoa;
import br.com.puc.api.repository.PessoaRepository;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe Service que sera utilizada para atividades de Pessoa.
 * 
 * @author Julivan Barbosa da Silva
 */
@Service
public class PessoaService {
	
	private final Logger logger = LogManager.getLogger(PessoaService.class);
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa pessoa) {
		logger.info("Executando Metodo: salvar() --> Pessoa: " + pessoa);
		pessoa.getContatos().forEach(c -> c.setPessoa(pessoa));
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		logger.info("Executando Metodo: atualizar() --> Codigo: " + codigo + " Pessoa: " + pessoa);
		
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);		
		pessoaSalva.getContatos().clear();
		pessoaSalva.getContatos().addAll(pessoa.getContatos());
		pessoaSalva.getContatos().forEach(c -> c.setPessoa(pessoaSalva));
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo", "contatos");
		return pessoaRepository.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		logger.info("Executando Metodo: atualizarPropriedadeAtivo() --> Codigo: " + codigo + " Boolean: " + ativo);
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		logger.info("Executando Metodo: buscarPessoaPeloCodigo() --> Codigo: " + codigo);
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		if (!pessoaSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva.get();
	}
}
