package br.unialfa.cardapio_escolar.enums;

public enum TipoProduto {
    PROTEINA("Proteína"),
    CARBOIDRATO("Carboidrato"),
    VERDURA("Verdura"),
    LEGUME("Legume"),
    FRUTA("Fruta"),
    LACTEO("Laticínio"),
    TEMPERO("Tempero"),
    BEBIDA("Bebida"),
    OUTROS("Outros");

    private final String descricao;

    TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}