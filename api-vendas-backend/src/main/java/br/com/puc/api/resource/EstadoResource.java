package br.com.puc.api.resource;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.puc.api.entidade.Estado;
import br.com.puc.api.repository.EstadoRepository;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe Resource para tratamento de Estado.
 * 
 * @author Julivan Barbosa da Silva
 */
@RestController
@RequestMapping("/estados")
public class EstadoResource {
	
	private final Logger logger = LogManager.getLogger(EstadoResource.class);
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public List<Estado> listar() {
		logger.info("Executando Metodo: listar()");
		return estadoRepository.findAll();
	}
}
