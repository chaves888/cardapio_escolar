package br.unialfa.cardapio_escolar.model.relacionamento_pedido;

import br.unialfa.cardapio_escolar.enums.TipoRelatorio;
import br.unialfa.cardapio_escolar.model.principais.Escola;
import br.unialfa.cardapio_escolar.model.principais.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRelatorio tipo;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerado_por_id", nullable = false)
    private Usuario geradoPor;

    @Column(nullable = false)
    private LocalDateTime dataGeracao = LocalDateTime.now();

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escola_id")
    private Escola escola; // null para relatórios gerais

    @Column(columnDefinition = "LONGTEXT")
    private String conteudoJson; // dados do relatório em JSON

    private String nomeArquivo;

    @Column(nullable = false)
    private Boolean ativo = true;
}