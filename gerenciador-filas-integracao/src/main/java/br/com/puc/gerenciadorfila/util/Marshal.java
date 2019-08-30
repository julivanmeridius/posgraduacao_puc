package br.com.puc.gerenciadorfila.util;

import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.puc.gerenciadorfila.model.Categoria;
import br.com.puc.gerenciadorfila.model.Fornecedor;
import br.com.puc.gerenciadorfila.model.Produto;

/**
* <p>
* 
* <strong>Descricao: </strong>
* Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
* Curso: Arquitetura de Solucoes
* 
* <b>Nota: Classe conversora de Objetos para XML</b>
* 
* @author Julivan Barbosa da Silva
**/
public class Marshal {
	
	private static Logger log = LoggerFactory.getLogger(Marshal.class);
	
	public static void main(String[] args) throws Exception {
		log.info("Executando Metodo: main()");
		
		Produto produto = criarObjetoProduto();
		
		criarObjetoCategoria(produto);
		
		criarObjetoFornecedor(produto);
		
		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.marshal(produto, new FileOutputStream("Produto.xml"));
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
	}
	
	private static Produto criarObjetoProduto() {
		log.info("Executando Metodo: criarObjetoProduto()");
		
		Produto produto = new Produto();
		produto.setCodigo(102L);
		produto.setNome("MongoDB");
		produto.setDescricao("Construa novas aplicações com novas tecnologias");
		produto.setValor(new BigDecimal("29.90"));
		produto.setQtd(89);
		produto.setStatus("");
		produto.setAtivo(true);
		return produto;
	}
	
	private static void criarObjetoCategoria(Produto produto) {
		log.info("Executando Metodo: criarObjetoCategoria()");
		
		Categoria categoria = new Categoria();
		categoria.setCodigo(1L);
		produto.setCategoria(categoria);
	}
	
	private static void criarObjetoFornecedor(Produto produto) {
		log.info("Executando Metodo: criarObjetoFornecedor()");
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo(1L);
		produto.setFornecedor(fornecedor);
	}
}
