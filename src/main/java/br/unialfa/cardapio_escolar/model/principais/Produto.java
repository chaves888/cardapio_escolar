package br.unialfa.cardapio_escolar.model.principais;

import br.unialfa.cardapio_escolar.enums.TipoProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String unidade; // kg, litros, unidades, pacote

    private Integer validadeDias; // dias de validade

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProduto tipo;

    @Column(nullable = false)
    private Boolean ativo = true;

    private String descricao;
}