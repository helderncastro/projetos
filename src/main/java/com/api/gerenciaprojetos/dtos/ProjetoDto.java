package com.api.gerenciaprojetos.dtos;

import com.api.gerenciaprojetos.enumeration.Classificacao;
import com.api.gerenciaprojetos.enumeration.Status;
import com.api.gerenciaprojetos.models.PessoaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProjetoDto {

    @NotBlank
    @Size(max = 200)
    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    @NotBlank
    @Size(max = 5000)
    private String descricao;

    @NotBlank
    @Size(max = 45)
    private Status status;

    private BigDecimal orcamento;

    @Size(max = 45)
    private Classificacao risco;

    private PessoaModel idGerente;

    public ProjetoDto() {

    }

    public ProjetoDto(String nome, LocalDate dataInicio, LocalDate dataPrevisaoFim, LocalDate dataFim, String descricao,
                      Status status, BigDecimal orcamento, Classificacao risco, PessoaModel idGerente) {
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
        return status;
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


