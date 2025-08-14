

CREATE TABLE tuplas.tpl_transacao_usuario (
	idkey_usuario int4 NULL,
	idkey_transacao int4 NULL,
	CONSTRAINT tpl_transacao_usuario_idkey_transacao_fkey FOREIGN KEY (idkey_transacao) REFERENCES financeiro.transacao(idkey),
	CONSTRAINT tpl_transacao_usuario_idkey_usuario_fkey FOREIGN KEY (idkey_usuario) REFERENCES usuario.usuario(idkey)
);