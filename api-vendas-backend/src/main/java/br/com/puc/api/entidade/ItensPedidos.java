package br.com.puc.api.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe Entidade de ItensPedidos.
 * 
 * @author Julivan Barbosa da Silva
 */
public class ItensPedidos {
	
	@NotNull
	@Column(name = "valor")
	private BigDecimal precoUnitario;
	
	@NotNull
	@Column(name = "quantidade")
	private Integer qtd;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_pedido")
	private Pedido pedido;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_produto")
	private Produto produto;
	
	public ItensPedidos() {
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItensPedidos [precoUnitario=" + precoUnitario + ", qtd=" + qtd + ", pedido=" + pedido + ", produto="
				+ produto + "]";
	}
}
