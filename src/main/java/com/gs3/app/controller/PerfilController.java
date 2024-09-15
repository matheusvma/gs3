package com.gs3.app.controller;

import com.gs3.app.dto.request.PerfilRequest;
import com.gs3.app.dto.response.PerfilResponse;
import com.gs3.app.mapper.PerfilMapper;
import com.gs3.app.model.Perfil;
import com.gs3.app.service.PerfilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/perfis")
@Api(tags = "perfis", value = "Controlador Rest API Perfis")
@EnableSwagger2
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PerfilMapper perfilMapper;

    /**
     * Função responsável por receber uma requisição com o método POST e salvar os dados do perfil.
     * @param request
     * @return
     */
    @ApiOperation(value = "Salvar dados perfil")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criação"),
            @ApiResponse(code = 400, message = "Requisição Inválida"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<PerfilResponse> criarPerfil(@RequestBody @Valid PerfilRequest request) {
        Perfil perfil = this.perfilService.salvarPerfil(perfilMapper.requestParaEntidade(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilMapper.entidadeParaResponse(perfil));
    }

    /**
     * Função responsável por receber uma requisição com o método GET e listar todos os perfis cadastrados.
     * @return
     */
    @ApiOperation(value = "Buscar dados perfil")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<PerfilResponse>> buscarPerfis() {
        List<Perfil> perfis = this.perfilService.buscarPerfis();
        return ResponseEntity.status(HttpStatus.OK).body(perfilMapper.entidadesParaResponses(perfis));
    }

}
