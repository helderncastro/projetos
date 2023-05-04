package com.api.gerenciaprojetos.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEMBROS")
public class MembroModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "idprojeto", nullable = false)
    private ProjetoModel projetoMembro;

    @ManyToOne()
    @JoinColumn(name = "idpessoa", nullable = false)
    private PessoaModel pessoaMembro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjetoModel getProjetoMembro() {
        return projetoMembro;
    }

    public void setProjetoMembro(ProjetoModel projetoMembro) {
        this.projetoMembro = projetoMembro;
    }

    public PessoaModel getPessoaMembro() {
        return pessoaMembro;
    }

    public void setPessoaMembro(PessoaModel pessoaMembro) {
        this.pessoaMembro = pessoaMembro;
    }
}
