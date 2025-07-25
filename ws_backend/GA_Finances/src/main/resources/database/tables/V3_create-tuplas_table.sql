CREATE TABLE tuplas.tpl_parcela_transacao (
	idkey_transacao int4 NULL,
	idkey_parcela int4 NULL,
	CONSTRAINT tpl_parcela_transacao_idkey_parcela_fkey FOREIGN KEY (idkey_parcela) REFERENCES financeiro.parcela(idkey),
	CONSTRAINT tpl_parcela_transacao_idkey_transacao_fkey FOREIGN KEY (idkey_transacao) REFERENCES financeiro.transacao(idkey)
);

CREATE TABLE tuplas.tpl_transacao_usuario (
	idkey_usuario int4 NULL,
	idkey_transacao int4 NULL,
	CONSTRAINT tpl_transacao_usuario_idkey_transacao_fkey FOREIGN KEY (idkey_transacao) REFERENCES financeiro.transacao(idkey),
	CONSTRAINT tpl_transacao_usuario_idkey_usuario_fkey FOREIGN KEY (idkey_usuario) REFERENCES usuario.usuario(idkey)
);