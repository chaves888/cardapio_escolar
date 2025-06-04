package br.unialfa.cardapio_escolar.enums;

public enum TipoRelatorio {
    NUTRICIONAL_SEMANAL("Relatório Nutricional Semanal"),
    PRODUTOS_ENVIADOS("Produtos Enviados por Escola"),
    CONSUMO_ESCOLA("Consumo por Escola"),
    PEDIDOS_REALIZADOS("Pedidos Realizados e Atendidos"),
    PRODUTOS_VENCIMENTO("Produtos Próximos ao Vencimento"),
    ESTOQUE_GERAL("Estoque Geral"),
    CARDAPIOS_APROVADOS("Cardápios Aprovados");

    private final String descricao;

    TipoRelatorio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}