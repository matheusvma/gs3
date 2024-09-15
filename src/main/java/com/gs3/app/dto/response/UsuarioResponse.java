package com.gs3.app.dto.response;

import com.gs3.app.model.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Integer id;

    private String nome;

    private String numTelefone;

    private String cpf;

    private Integer codPerfil;

    private String username;

}
