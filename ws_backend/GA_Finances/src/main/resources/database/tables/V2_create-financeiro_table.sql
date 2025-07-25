CREATE TABLE financeiro.tipo_categoria (
	idkey serial4 NOT NULL,
	descricao text NULL,
	CONSTRAINT pk_idkey_tipo_categoria PRIMARY KEY (idkey)
);
insert into financeiro.tipo_categoria (descricao) values
('Váriavel'),
('Fixo');

CREATE TABLE financeiro.tipo_transacao (
	idkey serial4 NOT NULL,
	descricao text NOT NULL,
	CONSTRAINT pk_idkey_tipo_transacao PRIMARY KEY (idkey)
);
INSERT INTO financeiro.tipo_transacao (descricao) VALUES
('Ganho'),
('Despesa'),
('Transferência Interna');

CREATE TABLE financeiro.tipo_compra (
	idkey serial4 NOT NULL,
	descricao text NOT NULL,
	CONSTRAINT pk_idkey_tipo_compra PRIMARY KEY (idkey)
);
INSERT INTO financeiro.tipo_compra (descricao) VALUES
('Única'),
('Parcelada'),
('Assinatura');

CREATE TABLE financeiro.nivel_prioridade (
	idkey serial4 NOT NULL,
	descricao text NOT NULL,
	CONSTRAINT pk_idkey_nivel_prioridade PRIMARY KEY (idkey)
);

INSERT INTO financeiro.nivel_prioridade (descricao) VALUES
('Alta'),
('Média'),
('Baixa');

CREATE TABLE financeiro.categoria (
	idkey serial4 NOT NULL,
	nome text NOT NULL,
	idkey_tipo_categoria int4 NULL,
	idkey_usuario int4 NULL,
	CONSTRAINT pk_idkey_categoria PRIMARY KEY (idkey),
	CONSTRAINT fk_idkey_pessoa_categoria_pessoa FOREIGN KEY (idkey_usuario) REFERENCES usuario.usuario(idkey),
	CONSTRAINT fk_tipo_categoria FOREIGN KEY (idkey_tipo_categoria) REFERENCES financeiro.tipo_categoria(idkey)
);

INSERT INTO financeiro.categoria (nome, idkey_tipo_categoria) VALUES
('Alimentação', 1),
('Transporte', 1),
('Moradia', 2),
('Educação', 2),
('Lazer', 1),
('Saúde', 2),
('Assinaturas', 2),
('Imprevistos', 1);

CREATE TABLE financeiro.status_pagamento (
	idkey serial4 NOT NULL,
	descricao text NOT NULL,
	CONSTRAINT pk_idkey_status_pagamento PRIMARY KEY (idkey),
	CONSTRAINT status_pagamento_descricao_key UNIQUE (descricao)
);

INSERT INTO financeiro.status_pagamento (descricao) VALUES
('pago'),
('pendente'),
('atrasado'),
('cancelado');

CREATE TABLE financeiro.parcela (
	idkey serial4 NOT NULL,
	numero_parcela int4 NOT NULL,
	data_vencimento date NOT NULL,
	valor numeric(10, 2) NOT NULL,
	idkey_status_pagamento int4 NULL,
	data_pagamento date NULL,
	CONSTRAINT pk_idkey_parcela PRIMARY KEY (idkey),
	CONSTRAINT parcela_idkey_status_pagamento_fkey FOREIGN KEY (idkey_status_pagamento) REFERENCES financeiro.status_pagamento(idkey)
);

CREATE TABLE financeiro.transacao (
	idkey serial4 NOT NULL,
	nome text NOT NULL,
	valor numeric(10, 2) NOT NULL,
	"data" date NOT NULL,
	idkey_categoria int4 NULL,
	idkey_tipo_transacao int4 NULL,
	idkey_tipo_compra int4 NULL,
	idkey_nivel_prioridade int4 NULL,
	CONSTRAINT pk_idkey_transacao PRIMARY KEY (idkey),
	CONSTRAINT transacao_idkey_categoria_fkey FOREIGN KEY (idkey_categoria) REFERENCES financeiro.categoria(idkey),
	CONSTRAINT transacao_idkey_nivel_prioridade_fkey FOREIGN KEY (idkey_nivel_prioridade) REFERENCES financeiro.nivel_prioridade(idkey),
	CONSTRAINT transacao_idkey_tipo_compra_fkey FOREIGN KEY (idkey_tipo_compra) REFERENCES financeiro.tipo_compra(idkey),
	CONSTRAINT transacao_idkey_tipo_transacao_fkey FOREIGN KEY (idkey_tipo_transacao) REFERENCES financeiro.tipo_transacao(idkey)
);