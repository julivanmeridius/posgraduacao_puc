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
 * <b>Nota:</b> Classe de MetaModel de Estado para reduzir os erros de run-time errors.
 * 
 * @author Julivan Barbosa da Silva
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estado.class)
public abstract class Estado_ {
	public static volatile SingularAttribute<Estado, Long> codigo;
	public static volatile SingularAttribute<Estado, String> nome;
}

