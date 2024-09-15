package com.gs3.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERFIL")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="perfil_seq")
    @SequenceGenerator(name = "perfil_seq", sequenceName = "PERFIL_SEQ", allocationSize = 1, initialValue=900)
    @Column(name = "COD_PERFIL")
    private Integer id;

    @Column(name = "NOME_PERFIL", nullable = false)
    private String nome;

    @Column(name = "STATUS", length = 1, nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

}
