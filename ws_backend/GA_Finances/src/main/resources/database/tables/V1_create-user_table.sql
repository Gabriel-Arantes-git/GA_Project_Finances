
CREATE TABLE usuario.credencial (
	idkey serial4 NOT NULL,
	email text NOT NULL,
	senha text NOT NULL,
	ultimo_login timestamp NULL,
	ativo bool DEFAULT true NULL,
	CONSTRAINT credencial_email_unique UNIQUE (email),
	CONSTRAINT credencial_idkey PRIMARY KEY (idkey)
);

CREATE TABLE usuario.token_recuperacao (
	idkey serial4 NOT NULL,
	idkey_credencial int4 NOT NULL,
	"token" uuid NOT NULL,
	criado_em timestamp DEFAULT CURRENT_TIMESTAMP NULL,
	expira_em timestamp NOT NULL,
	usado_em timestamp NULL,
	ip_origem varchar(50) NULL,
	CONSTRAINT token_recuperacao_pkey PRIMARY KEY (idkey),
	CONSTRAINT token_recuperacao_token_unique UNIQUE (token),
	CONSTRAINT token_recuperacao_idkey_credencial_fkey FOREIGN KEY (idkey_credencial) REFERENCES usuario.credencial(idkey)
);

CREATE TABLE usuario.tipo_usuario (
	idkey serial4 NOT NULL,
	descricao text NOT NULL,
	CONSTRAINT pk_idkey_tipo_usuario PRIMARY KEY (idkey)
);

INSERT INTO usuario.tipo_usuario (descricao) VALUES
('ADMIN'),
('USER');

CREATE TABLE usuario.usuario (
	idkey serial4 NOT NULL,
	nome text NOT NULL,
	idkey_credencial int4 NULL,
	idkey_tipo_usuario int4 NULL,
	CONSTRAINT pk_idkey_usuario PRIMARY KEY (idkey),
	CONSTRAINT usuario_idkey_credencial_fkey FOREIGN KEY (idkey_credencial) REFERENCES usuario.credencial(idkey),
	CONSTRAINT usuario_idkey_tipo_usuario_fkey FOREIGN KEY (idkey_tipo_usuario) REFERENCES usuario.tipo_usuario(idkey)
);

