# 🗄️ Banco de Dados – GA_Project

Este documento descreve a estrutura do banco de dados em *PostgreSQL* e os objetivos utilizados no sistema GA_Project. 
---

## 📐 Diagrama ER

Abaixo, a estrutura relacional do banco, modelada no DBeaver:

<img width="1912" height="910" alt="Captura de tela 2025-07-13 143503" src="https://github.com/user-attachments/assets/e68aeb5e-d21f-41f6-9910-319c1110fe19" />

---

## 📁 Estrutura de Schemas

O banco está organizado em múltiplos schemas:

- **`usuario`**: gerenciamento de usuários, autenticação e tokens.
- **`financeiro`**: controle de transações, parcelas e categorização financeira.

---

## 🧱 Principais Tabelas

### 🔐 Autenticação e Perfis (`usuario`)
- `credencial`: armazena email, senha hash, login ativo e timestamps.
- `token_recuperacao`: tokens de redefinição de senha, com expiração, IP e controle de uso.
- `usuario`: metadados do usuário e vínculo com a credencial.
- `tipo_usuario`: enum de perfis (admin, comum etc.).

### 💰 Gestão Financeira (`financeiro`)
- `transacao`: valor, data, descrição e vínculos com categoria, tipo, prioridade e compra.
- `categoria`: agrupamento de transações, vinculado a um `tipo_categoria`.
- `tipo_transacao`, `tipo_compra`, `nivel_prioridade`: enums.
- `tpl_transacao_usuario`: associação N:N entre usuários e transações.

### 📅 Parcelamento
- `parcela`: valor, data de vencimento, status e pagamento efetivo.
- `status_pagamento`: enum de status (pago, pendente, atrasado...).
- `tpl_parcela_transacao`: ligação entre parcelas e transações.

---
