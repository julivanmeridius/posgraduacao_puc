package br.com.puc.gerenciadorfila.jms;

import java.math.BigDecimal;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.puc.gerenciadorfila.exception.NaoEncontradoException;
import br.com.puc.gerenciadorfila.model.Categoria;
import br.com.puc.gerenciadorfila.model.Fornecedor;
import br.com.puc.gerenciadorfila.model.Produto;
import br.com.puc.gerenciadorfila.service.ProdutoService;

/**
* <p>
* 
* <strong>Descricao: </strong>
* Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
* Curso: Arquitetura de Solucoes
* 
* @author Julivan Barbosa da Silva
**/
@Component
public class LeitorMensagemFila {
	
	@Autowired
	private EnvioMensagemFila enviarMensagem;
	
	@Autowired
	private ProdutoService produtoService;
	
	private static Logger log = LoggerFactory.getLogger(LeitorMensagemFila.class);

    @JmsListener(destination = "CadastroDeProdutos.read")
    public void receiveMessage(final Message message) throws JMSException {
    	log.info("Executando Metodo: receiveMessage()");
    	
    	String messageData = null;
    	
    	if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			messageData = textMessage.getText();			
			log.info(messageData);
    	}
    	
    	/*
    	 * As informacoes da mensagem irao vir separadas por ponto e virgula, logo, apos
    	 * o recebimento o split se faz necessario. 
    	 * 
    	 * exemplo ilustrando o cenario:  
    	 * OAuth 2.0;Proteja suas aplicações com o Spring Security OAuth2 xxxxxxxxxx;85.50;240;;;;;;;1;1
    	 * 
    	 */    	
    	log.info("Realizando tratamento da Mensagem Lida...");    	
    	if(messageData == null || messageData.isEmpty())
    	{
    		throw new NaoEncontradoException("Atenção! Mensagem recebida estava NUla ou Vazia!");    		
    	}
    	
    	String[] strMsg = messageData.split(";");
    	
    	Produto produto = criarObjetoProdutoBase(strMsg);
    	
    	criarObjetoCategoria(strMsg, produto);
    	
    	criarObjetoFornecedor(strMsg, produto);
    	
    	log.info("Ativando Produto antes da Persistencia...");
    	produto.setAtivo(true);
    	
    	log.info("Persistindo Novo Produto...");
    	produto = produtoService.salvar(produto);
    	
		enviarMensagem.send("Cadastro do Produto-->  " + produto.getNome()  + " realizado com Sucesso.");
    }
	
	private Produto criarObjetoProdutoBase(String[] strMsg) {
		log.info("Executando Metodo: criarObjetoProdutoBase()");
		
		Produto produto = new Produto();    	
		produto.setNome(strMsg[0]);
    	produto.setDescricao(strMsg[1]);
    	produto.setValor(BigDecimal.valueOf(Double.valueOf(strMsg[2])));
    	produto.setQtd(Integer.valueOf(strMsg[3]));
    	produto.setStatus("ATIVO");
		return produto;
	}
	
	private void criarObjetoCategoria(String[] strMsg, Produto produto) {
		log.info("Executando Metodo: criarObjetoCategoria()");
		
		Categoria categoria = new Categoria();
    	categoria.setCodigo(Long.valueOf(strMsg[4]));
    	produto.setCategoria(categoria);
	}
	
	private void criarObjetoFornecedor(String[] strMsg, Produto produto) {
		log.info("Executando Metodo: criarObjetoFornecedor()");
		
		Fornecedor fornecedor = new Fornecedor();
    	fornecedor.setCodigo(Long.valueOf(strMsg[5]));
    	produto.setFornecedor(fornecedor);
	}
}
