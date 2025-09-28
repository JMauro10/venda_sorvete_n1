package com.mycompany.venda_sorvete_n1.lucas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 *
 * @author Lucas Lopes
 */
public class Pagamento {

    private final BigDecimal totalBruto;
    private BigDecimal taxaCartaoPercentual = BigDecimal.ZERO;
    private MetodoPagamento metodo = MetodoPagamento.PIX;
    private StatusPagamento status = StatusPagamento.PENDENTE;
    private BigDecimal valorPago = BigDecimal.ZERO;
    private BigDecimal troco = BigDecimal.ZERO;
    private final LocalDateTime criadoEm = LocalDateTime.now();

    public Pagamento(BigDecimal totalBruto) {
        if (totalBruto == null || totalBruto.signum() < 0) {
            throw new IllegalArgumentException("totalBruto inválido");
        }
        this.totalBruto = moeda(totalBruto);
    }

    public Pagamento metodo(MetodoPagamento m) { this.metodo = m; return this; }

    public Pagamento taxaCartaoPercentual(BigDecimal p) {
        if (p == null || p.signum() < 0 || p.compareTo(BigDecimal.valueOf(10)) > 0)
            throw new IllegalArgumentException("Taxa do cartão deve estar entre 0% e 10%");
        this.taxaCartaoPercentual = p;
        return this;
    }

    public void pagarComDinheiro(BigDecimal valorEntregue) {
        this.metodo = MetodoPagamento.DINHEIRO;
        BigDecimal total = totalLiquido();
        if (valorEntregue == null || valorEntregue.compareTo(total) < 0) {
            throw new IllegalArgumentException("Valor pago insuficiente para DINHEIRO");
        }
        this.valorPago = moeda(valorEntregue);
        this.troco = moeda(valorEntregue.subtract(total));
        this.status = StatusPagamento.APROVADO;
    }

    public void pagarComPix() {
        this.metodo = MetodoPagamento.PIX;
        this.valorPago = totalLiquido();
        this.troco = BigDecimal.ZERO;
        this.status = StatusPagamento.APROVADO;
    }

    public void pagarComCartao() {
        this.metodo = MetodoPagamento.CARTAO;
        this.valorPago = totalLiquido();
        this.troco = BigDecimal.ZERO;
        this.status = StatusPagamento.APROVADO;
    }

    public BigDecimal totalLiquido() {
        BigDecimal total = totalBruto;
        if (metodo == MetodoPagamento.CARTAO && taxaCartaoPercentual.signum() > 0) {
            BigDecimal fatorTaxa = BigDecimal.ONE.add(
                    taxaCartaoPercentual.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_UP));
            total = total.multiply(fatorTaxa);
        }
        return moeda(total);
    }

    private BigDecimal moeda(BigDecimal v) { return v.setScale(2, RoundingMode.HALF_UP); }

    public String resumo() {
        return String.format(
            "metodo=%s,status=%s,totalBruto=%.2f,taxaCartao=%.2f%%,totalLiquido=%.2f,valorPago=%.2f,troco=%.2f,criadoEm=%s",
            metodo, status, totalBruto, taxaCartaoPercentual, totalLiquido(), valorPago, troco, criadoEm
        );
    }

    public BigDecimal getTotalBruto() { return totalBruto; }
    public BigDecimal getTaxaCartaoPercentual() { return taxaCartaoPercentual; }
    public MetodoPagamento getMetodo() { return metodo; }
    public StatusPagamento getStatus() { return status; }
    public BigDecimal getValorPago() { return valorPago; }
    public BigDecimal getTroco() { return troco; }
}