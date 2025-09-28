package com.mycompany.venda_sorvete_n1.alexandre;

import com.mycompany.venda_sorvete_n1.joseMauro.Produto;

/**
 *
 * @author Alexandre
 */
public class ItemComanda {
    
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItemComanda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    public double getTotalItem() {
        return quantidade * precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
}
