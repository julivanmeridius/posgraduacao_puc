package br.com.puc.gerenciadorfila.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

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
@Service
public class EnvioMensagemFila {

	private static Logger log = LoggerFactory.getLogger(EnvioMensagemFila.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "CadastroDeProdutos.write")
    public void send(Produto entidadeProduto) {
    	log.info("### Realizando o Envio do Produto...");
        log.info("### Executando Metodo: convertAndSend() para a queue <" + entidadeProduto + ">");
        
        jmsTemplate.convertAndSend("cadastrarprodutos.write", entidadeProduto);
    }
    
    public void send(String myMessage) {
    	log.info("### Realizando o Envio de uma Mensagem via String...");
    	log.info("### Executando Metodo: convertAndSend() para a queue--| " + myMessage + "|--");
    	
        jmsTemplate.convertAndSend("cadastrarprodutos.write", myMessage);
    }
}
