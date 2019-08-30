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
 * <b>Nota:</b> Classe de MetaModel de Permissao para reduzir os erros de run-time errors.
 * 
 * @author Julivan Barbosa da Silva
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Permissao.class)
public abstract class Permissao_ {
	public static volatile SingularAttribute<Permissao, Long> codigo;
	public static volatile SingularAttribute<Permissao, String> descricao;
}
