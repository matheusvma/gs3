package com.gs3.app.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIO")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "USUARIO_SEQ", allocationSize = 1, initialValue=900)
    @Column(name = "COD_USUARIO")
    private Integer id;

    @Column(name = "NOME_USUARIO",  nullable = false)
    private String nome;

    @Column(name = "NUMERO_TELEFONE", length = 20)
    private String numTelefone;

    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Basic(optional = false)
    @Column(name = "COD_PERFIL", nullable = false)
    private Integer codPerfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", insertable = false, updatable = false)
    private Perfil perfil;

}
