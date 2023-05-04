package com.api.gerenciaprojetos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class PessoaDto {

    @NotBlank
    @Size(max = 100)
    private String nome;

    private LocalDate dataNascimento;

    @NotBlank
    @Size(max= 14)
    private String cpf;

    private Boolean funcionario;

    public PessoaDto() {

    }

    public PessoaDto(String nome, LocalDate dataNascimento, String cpf, Boolean funcionario) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }
}
