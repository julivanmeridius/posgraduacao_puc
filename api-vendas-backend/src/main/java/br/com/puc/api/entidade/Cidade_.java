package br.com.puc.api.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * <p>
 * 
 * <strong>Descricao: </strong>
 * Trabalho de Conclusao de Curso - Especializacao PUC MINAS<br>
 * Curso: Arquitetura de Solucoes<br>
 * 
 * <b>Nota:</b> Classe de MetaModel da Cidade para reduzir os erros de run-time errors.
 * 
 * @author Julivan Barbosa da Silva
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cidade.class)
public abstract class Cidade_ {
	public static volatile SingularAttribute<Cidade, Long> codigo;
	public static volatile SingularAttribute<Cidade, Estado> estado;
	public static volatile SingularAttribute<Cidade, String> nome;
}

