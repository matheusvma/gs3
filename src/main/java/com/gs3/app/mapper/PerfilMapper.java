package com.gs3.app.mapper;

import com.gs3.app.dto.request.PerfilRequest;
import com.gs3.app.dto.response.PerfilResponse;
import com.gs3.app.model.Perfil;
import com.gs3.app.model.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PerfilMapper {

    Perfil requestParaEntidade(PerfilRequest request);

    PerfilResponse entidadeParaResponse(Perfil perfil);

    List<Perfil> requestsParaEntidades(List<PerfilRequest> requests);

    List<PerfilResponse> entidadesParaResponses(List<Perfil> perfis);

}
