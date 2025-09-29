package com.mycompany.venda_sorvete_n1.joseMauro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mycompany.venda_sorvete_n1.alexandre.Cliente;
import com.mycompany.venda_sorvete_n1.alexandre.Funcionario;
import com.mycompany.venda_sorvete_n1.alexandre.ItemComanda;
import com.mycompany.venda_sorvete_n1.pedro.Comanda;

public class ComandaBuilder {
    private Cliente cliente;
    private Funcionario funcionario;
    private final List<ItemComanda> itens = new ArrayList<>();

    public ComandaBuilder paraCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ComandaBuilder atendidoPor(Funcionario funcionario) {
        this.funcionario = funcionario;
        return this;
    }

    public ComandaBuilder comItem(ItemComanda item) {
        this.itens.add(item);
        return this;
    }

    public ComandaBuilder comItens(ItemComanda... itens) {
        this.itens.addAll(Arrays.asList(itens));
        return this;
    }

    public Comanda build() {
        Comanda comanda = new Comanda(cliente, funcionario);
        comanda.getItens().addAll(this.itens);
        return comanda;
    }
}