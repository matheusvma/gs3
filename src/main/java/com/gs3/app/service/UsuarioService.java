package com.gs3.app.service;

import com.gs3.app.model.Usuario;
import com.gs3.app.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Função responsável por salvar os dados do usuario na base.
     * @param usuario
     * @return
     */
    public Usuario salvarUsuario(Usuario usuario) {

        return this.usuarioRepository.saveAndFlush(usuario);
    }

    /**
     * Função responsável por buscar todos os usuarios cadastrados na base.
     * @return
     */
    public List<Usuario> buscarUsuarios() {

        return this.usuarioRepository.findAll();
    }

    /**
     * Função responsável por efetuar a autenticação do usuario.
     * @return
     */
    public Usuario authenticate(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario != null && usuario.getPassword().equals(password)){
            return usuario;
        }

        return null;
    }

    /**
     * Função responsável por editar os dados do usuario na base.
     * @param usuario
     * @return
     */
    public Usuario editarUsuario(Integer codigo, Usuario usuario) {
        Usuario usuarioAtualizar = this.usuarioRepository.findById(codigo).get();
        usuario.setId(codigo);
        BeanUtils.copyProperties(usuario, usuarioAtualizar);
        return this.usuarioRepository.saveAndFlush(usuarioAtualizar);
    }

}
