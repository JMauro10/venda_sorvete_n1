/*package com.mycompany.venda_sorvete_n1.lucas;

import br.com.sorveteria.pagamento.testbuilder.PagamentoBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    void fluxoGeralPagamento() {
       
        Pagamento p1 = PagamentoBuilder.umPagamento()
                .total(30.00)
                .metodo(MetodoPagamento.DINHEIRO)
                .build();
        p1.pagarComDinheiro(BigDecimal.valueOf(50.00));
        assertEquals(StatusPagamento.APROVADO, p1.getStatus());
        assertEquals(new BigDecimal("20.00"), p1.getTroco());

        
        Pagamento p2 = PagamentoBuilder.umPagamento()
                .total(18.50)
                .metodo(MetodoPagamento.PIX)
                .build();
        p2.pagarComPix();
        assertEquals(StatusPagamento.APROVADO, p2.getStatus());
        assertEquals(new BigDecimal("18.50"), p2.getValorPago());
        assertEquals(new BigDecimal("0.00"), p2.getTroco());

        
        Pagamento p3 = PagamentoBuilder.umPagamento()
                .total(100.00)
                .taxa(3.5)
                .metodo(MetodoPagamento.CARTAO)
                .build();
        p3.pagarComCartao();
        assertEquals(StatusPagamento.APROVADO, p3.getStatus());
        assertEquals(new BigDecimal("103.50"), p3.getValorPago());

       
        String resumo = p3.resumo();
        assertTrue(resumo.contains("metodo=CARTAO"));
        assertTrue(resumo.contains("totalLiquido=103.50"));
    }
}*/