package com.gs3.app.service;

import com.gs3.app.model.Perfil;
import com.gs3.app.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    /**
     * Função responsável por salvar os dados do perfil na base.
     * @param perfil
     * @return
     */
    public Perfil salvarPerfil(Perfil perfil) {

        return this.perfilRepository.save(perfil);
    }

    /**
     * Função responsável por buscar todos os perfis cadastrados na base.
     * @return
     */
    public List<Perfil> buscarPerfis() {

        return this.perfilRepository.findAll();
    }

}
