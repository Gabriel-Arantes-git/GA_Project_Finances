package com.GA_Project.GA_Finances.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestUsuarioDTO(
        @NotBlank(message = "email deve ser preenchido")
        @Email(message = "formato do email inválido")
        String email,
        @Size(min = 8,message = "a senha deve ter no mínimo 8 dígitos")
        @NotBlank(message = "senha deve ser obrigatório")
        String senha,
        String nome
) { }
