package br.com.puc.gerenciadorfila.util;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

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
* <b>Nota: Classe Geradora do SchemaXSD</b>
* 
* @author Julivan Barbosa da Silva
**/
public class GeradorSchemaXSD {
	
	private static Logger log = LoggerFactory.getLogger(GeradorSchemaXSD.class);
	
	public static void main(String[] args) throws Exception {
		
		JAXBContext ctx = JAXBContext.newInstance(Produto.class);
		ctx.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName)
					throws IOException 
			{
				log.info("Executando Metodo: createOutput()");
				return new StreamResult (new File("Produto.xsd"));
			}
		});
	}
}
