package com.gs3.app.mapper;

import com.gs3.app.dto.request.UsuarioRequest;
import com.gs3.app.dto.response.UsuarioResponse;
import com.gs3.app.model.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario requestParaEntidade(UsuarioRequest request);

    UsuarioResponse entidadeParaResponse(Usuario usuario);

    List<Usuario> requestsParaEntidades(List<UsuarioRequest> requests);

    List<UsuarioResponse> entidadesParaResponses(List<Usuario> usuarios);

}
