package com.api.gerenciaprojetos.enumeration;

public enum Classificacao {

    BAIXO("Baixo Risco"),
    MEDIO("Medio Risco"),
    ALTO("Alto Risco");

   private String label;

   private Classificacao (String label) {
       this.label = label;
   }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
