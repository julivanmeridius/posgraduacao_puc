CREATE TABLE produto (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(300) NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	quantidade BIGINT(5) NOT NULL,
	status VARCHAR(100),	
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_fornecedor BIGINT(20) NOT NULL,
	ativo BOOLEAN NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedor(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into produto(codigo, nome, descricao, valor, quantidade, status, codigo_categoria, codigo_fornecedor, ativo) 
values (85, 'Java for Dummies','Dummies Series', 89.40, 100,'disponivel',1,1,true);


