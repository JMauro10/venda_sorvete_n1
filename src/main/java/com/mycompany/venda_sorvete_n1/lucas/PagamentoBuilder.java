package com.mycompany.venda_sorvete_n1.lucas;

import java.math.BigDecimal;

/**
 *
 * @author Lucas Lopes
 */
public class PagamentoBuilder {
    private BigDecimal total = BigDecimal.valueOf(50.00);
    private BigDecimal taxa = BigDecimal.ZERO;
    private MetodoPagamento metodo = MetodoPagamento.PIX;

    public static PagamentoBuilder umPagamento() { return new PagamentoBuilder(); }

    public PagamentoBuilder total(double v) { this.total = BigDecimal.valueOf(v); return this; }
    public PagamentoBuilder taxa(double p) { this.taxa = BigDecimal.valueOf(p); return this; }
    public PagamentoBuilder metodo(MetodoPagamento m) { this.metodo = m; return this; }

    public Pagamento build() {
        return new Pagamento(total)
                .taxaCartaoPercentual(taxa)
                .metodo(metodo);
    }
}