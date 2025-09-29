package com.mycompany.venda_sorvete_n1.lucas;

import com.mycompany.venda_sorvete_n1.lucas.Pagamento;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
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
    }
}