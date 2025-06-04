package br.unialfa.cardapio_escolar.model.principais;

import br.unialfa.cardapio_escolar.model.relacionamento_pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    private String telefone;

    @Column(nullable = false)
    private Boolean ativa = true;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gestor_id")
    private Usuario gestor;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EstoqueEscola> estoque;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
}