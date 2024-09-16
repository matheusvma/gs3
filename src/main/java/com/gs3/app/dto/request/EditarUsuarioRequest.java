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
public class EditarUsuarioRequest {

    @NotNull(message = "{campo.nome}")
    private String nome;

    private String numTelefone;

    @NotNull(message = "{campo.cpf}")
    private String cpf;

    @NotNull(message = "{campo.perfil}")
    private Integer codPerfil;

    @NotNull(message = "{campo.username}")
    private String username;

}
