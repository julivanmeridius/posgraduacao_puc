CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João Cabralia', 'Rua do Porto Seco', '9', null, 'Chacara Santana', '34.160-121', 'Sao Carlos', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Mariana Cazares', 'Rua Cambara', '241', 'Apto 1', 'Centro', '51.400-111', 'Ribeirão Pires', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Santos', 'Avenida Brasil', '18', null, 'Unidos da Vila', '54.277-126', 'Uberaba', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Ricardo Pereira', 'Rua Carvalho Pinto', '230', 'Apto 132', 'Cidade Dutra', '34.100-12', 'Ilheus', 'BA', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Josué Mariano', 'Av Conde Rio Branco', '21', null, 'Jardim da Serra', '16.100-121', 'Joao Pessoa', 'RN', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Barbosa', 'Av Machado de Assis', '180', null, 'Pedra Azul', '12.480-121', 'Caxias do Sul', 'RS', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Henrique Medeiros', 'Rua Fernandes Moreira', '1120', 'Apto 201', 'Centro', '11.500-121', 'Niteroi', 'RJ', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Carlos Santana', 'Rua Fernandes Dias', '433', null, 'Centro', '33.010-121', 'Araxa', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Leonardo Oliveira', 'Rua Novos Boemios', '566', null, 'Vila Andrade', '32.400-00', 'Varginha', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Isabela Martins', 'Rua do Manaca', '1233', 'Apto 10', 'Vila Maior', '91.400-121', 'Fortaleza', 'CE', true);
