package br.unialfa.cardapio_escolar.model.principais;

import br.unialfa.cardapio_escolar.enums.DiaSemana;
import br.unialfa.cardapio_escolar.enums.StatusCardapio;
import br.unialfa.cardapio_escolar.enums.Turno;
import br.unialfa.cardapio_escolar.model.relacionamento_pedido.CardapioEscola;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate semanaInicio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiaSemana dia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Turno turno;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nutricionista_id", nullable = false)
    private Usuario nutricionista;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCardapio status = StatusCardapio.RASCUNHO;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private LocalDateTime dataEnvio;

    private LocalDateTime dataAprovacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aprovado_por_id")
    private Usuario aprovadoPor;

    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardapioEscola> escolas;

    private String observacoes;
}