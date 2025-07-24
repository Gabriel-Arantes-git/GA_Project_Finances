package com.GA_Project.GA_Finances.entity.usuarioEntity;

public enum UserTipo {
    ADMIN("Administrador"),
    USER("Usuário Padrão");

    private String role;

    UserTipo(String role){
        this.role = role;
    }

    public String getUserTipo() {
        return role;
    }
}
