package com.gs3.app.controller;

import com.gs3.app.dto.request.UsuarioRequest;
import com.gs3.app.dto.response.UsuarioResponse;
import com.gs3.app.mapper.UsuarioMapper;
import com.gs3.app.model.Usuario;
import com.gs3.app.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/usuarios")
@Api(tags = "usuarios", value = "Controlador Rest API Usuarios")
@EnableSwagger2
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    /**
     * Função responsável por receber uma requisição com o método POST e salvar os dados do usuario.
     * @param request
     * @return
     */
    @ApiOperation(value = "Salvar dados usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criação"),
            @ApiResponse(code = 400, message = "Requisição Inválida"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = this.usuarioService.salvarUsuario(usuarioMapper.requestParaEntidade(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.entidadeParaResponse(usuario));
    }

    /**
     * Função responsável por receber uma requisição com o método GET e listar todos os usuarios cadastrados.
     * @return
     */
    @ApiOperation(value = "Buscar dados usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<UsuarioResponse>> buscarUsuarios() {
        List<Usuario> usuarios = this.usuarioService.buscarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarioMapper.entidadesParaResponses(usuarios));
    }

    /**
     * Função responsável por autenticar usuarios cadastrados.
     * @return
     */
    @ApiOperation(value = "Autenticar dados usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody UsuarioRequest request) {
        boolean isAuthenticated = this.usuarioService.authenticate(request.getUsername(), request.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.status(HttpStatus.OK).body("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }

}
