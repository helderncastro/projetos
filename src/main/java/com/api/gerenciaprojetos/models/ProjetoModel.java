package com.api.gerenciaprojetos.models;

import com.api.gerenciaprojetos.enumeration.Classificacao;
import com.api.gerenciaprojetos.enumeration.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PROJETO")
public class ProjetoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long idProjeto;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column(name="data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(name="data_fim")
    private LocalDate dataFim;

    @Column(length = 5000)
    private String descricao;

    @Column(length = 45)
    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal orcamento;

    @Column(length = 45)
    @Enumerated(EnumType.STRING)
    private Classificacao risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private PessoaModel idGerente;

    public ProjetoModel() {
    }

    public ProjetoModel(Long idProjeto, String nome, LocalDate dataInicio, LocalDate dataPrevisaoFim, LocalDate dataFim,
                        String descricao, Status status, BigDecimal orcamento, Classificacao risco, PessoaModel idGerente) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataPrevisaoFim = dataPrevisaoFim;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.status = status;
        this.orcamento = orcamento;
        this.risco = risco;
        this.idGerente = idGerente;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status ;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public Classificacao getRisco() {
        return risco;
    }

    public void setRisco(Classificacao risco) {
        this.risco = risco;
    }

    public PessoaModel getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(PessoaModel idGerente) {
        this.idGerente = idGerente;
    }
}
