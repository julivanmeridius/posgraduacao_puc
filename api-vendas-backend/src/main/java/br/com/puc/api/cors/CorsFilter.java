package br.com.puc.api.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.puc.api.config.property.ComprasApiProperty;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes
 *  
 * @author Julivan Barbosa da Silva
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	private final Logger logger = LogManager.getLogger(CorsFilter.class);
	
	@Autowired
	private ComprasApiProperty algamoneyApiProperty;
	
	/**
	 * Implementacao de filltros de chamadas externas da aplicacao.
	 */
	@Override
	public void doFilter(ServletRequest reqParam, ServletResponse respParam, FilterChain filterChain)
			throws IOException, ServletException {
		logger.info("Executando Metodo: doFilter -- Cors");
		
		HttpServletRequest request = (HttpServletRequest) reqParam;
		HttpServletResponse response = (HttpServletResponse) respParam;
		response.setHeader("Access-Control-Allow-Origin", algamoneyApiProperty.getOriginPermitida());
        response.setHeader("Access-Control-Allow-Credentials", "true");
		
		if ("OPTIONS".equals(request.getMethod()) && algamoneyApiProperty.getOriginPermitida().equals(request.getHeader("Origin"))) {
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
        	response.setHeader("Access-Control-Max-Age", "3600");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			filterChain.doFilter(reqParam, respParam);
		}
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
