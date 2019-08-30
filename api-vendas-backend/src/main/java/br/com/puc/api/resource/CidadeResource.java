package br.com.puc.api.resource;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.puc.api.entidade.Cidade;
import br.com.puc.api.repository.CidadeRepository;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe Resource para tratamento de Cidade.
 * 
 * @author Julivan Barbosa da Silva
 */
@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	private final Logger logger = LogManager.getLogger(CidadeResource.class);
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public List<Cidade> pesquisar(@RequestParam Long estado) {
		logger.info("Executando Metodo: pesquisar() --> Estado: ");
		return cidadeRepository.findByEstadoCodigo(estado);
	}
}
