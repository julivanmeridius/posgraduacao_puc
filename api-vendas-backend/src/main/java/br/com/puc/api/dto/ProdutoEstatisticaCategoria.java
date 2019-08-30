package br.com.puc.api.dto;

import java.math.BigDecimal;

import br.com.puc.api.entidade.Categoria;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe Dto para auxiliar na geracao de estatisticas por<br>
 * categoria dos Produtos cadastrados no Sistema.  
 * 
 * @author Julivan Barbosa da Silva
 *
 */
public class ProdutoEstatisticaCategoria {
	
	private Categoria categoria;
	
	private BigDecimal total;

	public ProdutoEstatisticaCategoria(Categoria categoria, BigDecimal total) {
		this.categoria = categoria;
		this.total = total;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProdutoEstatisticaCategoria [categoria=" + categoria + ", total=" + total + "]";
	}
}
