package br.unialfa.cardapio_escolar.enums;

public enum Turno {
    MANHA("Manhã"),
    TARDE("Tarde");

    private final String descricao;

    Turno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}