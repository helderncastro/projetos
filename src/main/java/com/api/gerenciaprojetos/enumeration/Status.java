package com.api.gerenciaprojetos.enumeration;

public enum Status {
    //em análise, análise realizada, análise aprovada, iniciado, planejado, em andamento, encerrado, cancelado.
    ANALISE("Em análise"),
    REALIZADA("Análise realizada"),
    APROVADA("Análise aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    ANDAMENTO("Em andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado");

    private String label;

    private Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
