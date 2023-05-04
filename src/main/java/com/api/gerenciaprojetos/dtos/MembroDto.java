package com.api.gerenciaprojetos.dtos;

import com.api.gerenciaprojetos.models.PessoaModel;
import com.api.gerenciaprojetos.models.ProjetoModel;

public class MembroDto {

    private ProjetoModel projetoMembro;
    private PessoaModel pessoaMembro;

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
