package br.unialfa.cardapio_escolar.model.relacionamento_pedido;

import br.unialfa.cardapio_escolar.enums.StatusPedido;
import br.unialfa.cardapio_escolar.model.principais.Escola;
import br.unialfa.cardapio_escolar.model.principais.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escola_id", nullable = false)
    private Escola escola;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitante_id", nullable = false)
    private Usuario solicitante;

    @Column(nullable = false)
    private LocalDateTime dataPedido = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status = StatusPedido.PENDENTE;

    private String observacoes;

    private LocalDateTime dataAnalise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analisado_por_id")
    private Usuario analisadoPor;

    private LocalDateTime dataEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entregue_por_id")
    private Usuario entreguePor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemPedido> itens;

    private String motivoCancelamento;
}