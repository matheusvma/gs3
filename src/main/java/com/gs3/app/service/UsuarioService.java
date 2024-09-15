package com.gs3.app.service;

import com.gs3.app.model.Usuario;
import com.gs3.app.repository.UsuarioRepository;
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
    public boolean authenticate(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return usuario != null && usuario.getPassword().equals(password);
    }

}
