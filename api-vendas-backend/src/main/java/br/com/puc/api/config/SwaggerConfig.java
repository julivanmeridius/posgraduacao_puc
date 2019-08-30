package br.com.puc.api.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes
 * 
 * @author Julivan Barbosa da Silva
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

	private final ResponseMessage m200 = simpleMessage(200, "Chamada Realizada com retorno de Sucesso!");
	private final ResponseMessage m201 = simpleMessage(201, "Recurso Criado com Sucesso!");
	private final ResponseMessage m204 = simpleMessage(204, "Recurso Sem Conteúdo!");
	private final ResponseMessage m400 = simpleMessage(400, "Recurso Inexistente!");
	private final ResponseMessage m404 = simpleMessage(404, "Recurso Não Encontrado!");
	private final ResponseMessage m500 = simpleMessage(500, "Falha Interna ocorrida no Serviço!");

	@Value("${swagger.info.title}") 				private String title;
	@Value("${swagger.info.description}") 			private String description;
	@Value("${swagger.info.version}") 				private String version;
	@Value("${swagger.info.termsOfServiceUrl}")		private String termsOfServiceUrl;
	@Value("${swagger.info.contactName}")			private String contactName;
	@Value("${swagger.info.contactUrl}")			private String contactUrl;
	@Value("${swagger.info.contactEmail}")			private String contactEmail;
	@Value("${swagger.info.license}")				private String license;
	@Value("${swagger.info.licenseUrl}")			private String licenseUrl;

	@Bean
	public Docket api() {
		
		/**
		 * Criacao da parametrizacao do mapeamento de retorno esperado para cada um dos Metodos HTTP
		 */
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(m200, m400, m404, m500))
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m201, m400, m404, m500))
				.globalResponseMessage(RequestMethod.PUT, Arrays.asList(m200, m204, m400, m404, m500))
				.globalResponseMessage(RequestMethod.DELETE, Arrays.asList(m204, m400, m404, m500))
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.puc.api.resource"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ResponseMessage simpleMessage(final int code, final String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(title, description, version, termsOfServiceUrl,
				new Contact(contactName, contactUrl, contactEmail), license, licenseUrl, Collections.emptyList());
	}
}
