package com.gs3.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerfilRequest {

    @NotNull(message = "{campo.nome}")
    private String nome;

    @NotNull(message = "{campo.status}")
    private Integer status;

}
