package br.unialfa.cardapio_escolar.model.relacionamento_pedido;

import br.unialfa.cardapio_escolar.model.principais.Cardapio;
import br.unialfa.cardapio_escolar.model.principais.Escola;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardapioEscola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardapio_id", nullable = false)
    private Cardapio cardapio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escola_id", nullable = false)
    private Escola escola;

    @Column(nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    private LocalDateTime dataVisualizacao;

    @Column(nullable = false)
    private Boolean confirmado = false;

    private String observacoes;
}