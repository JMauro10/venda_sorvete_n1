package com.mycompany.venda_sorvete_n1.joseMauro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mycompany.venda_sorvete_n1.alexandre.Cliente;
import com.mycompany.venda_sorvete_n1.alexandre.ItemComanda;
import com.mycompany.venda_sorvete_n1.pedro.Comanda;

public class ComandaTest {

    public ComandaTest() {
    }

    private ItemComanda item(Produto p, int qtd) {
        return new ItemComanda(p, qtd);
    }

    private Produto produto(int id, String nome, double preco, int estoque) {
        return new Produto(id, nome, preco, estoque);
    }
    

    @Test
    void deveCalcularTotalSomandoPrecoUnitarioVezesQuantidade() {
        Cliente cliente = new Cliente("Cliente Total", "00011122233", "(62) 95555-4444", java.time.LocalDate.now());

        ItemComanda i1 = item(produto(1, "Casquinha P", 5.00, 100), 2);
        ItemComanda i2 = item(produto(2, "Pote M", 12.00, 50), 1);

        Comanda comanda = new ComandaBuilder()
                .paraCliente(cliente)
                .atendidoPor(new FuncionarioBuilder()
                        .criarFuncionario("Alexandre", "20202020202", "Atendente", java.time.LocalDate.now(), 1500.0)
                        .controi())
                .comItens(i1, i2)
                .build();

        double total = comanda.calcularTotal();
        assertEquals(22.00, total);
    }
}