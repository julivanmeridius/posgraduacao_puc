package br.com.puc.gerenciadorfila.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.puc.gerenciadorfila.model.Produto;

/**
* <p>
* 
* <strong>Descricao: </strong>
* Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
* Curso: Arquitetura de Solucoes
* 
* <b>Nota: Classe conversora de XML para Objetos Entidade</b>
* 
* @author Julivan Barbosa da Silva
**/
public class Unmarshal {

	private static Logger log = LoggerFactory.getLogger(Unmarshal.class);
	
	public static void main(String[] args) throws JAXBException {
		log.info("Executando Metodo: main()");
		
		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		
		Produto produto = (Produto) unmarshaller.unmarshal(new File("Produto.xml"));
		
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Qtd: " + produto.getQtd());
		System.out.println("Valor: " + produto.getValor());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Categoria - codigo: "+ produto.getCategoria().getCodigo());
		System.out.println("Fornecedor - codigo: "+ produto.getCategoria().getCodigo());
	}
}
