package com.GA_Project.GA_Finances.dto.financeiro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record RequestNovaTransacaoDTO(
        @JsonProperty("nome") String nome,
        @JsonProperty("valor") Double valor,
        @JsonProperty("data") LocalDate data,
        @JsonProperty("idCategoria") Long idCategoria,
        @JsonProperty("idNivelPrioridade") Long idNivelPrioridade,
        @JsonProperty("idTipoCompra") Long idTipoCompra,
        @JsonProperty("idTipoTransacao") Long idTipoTransacao
) {
}
