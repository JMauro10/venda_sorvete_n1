package com.mycompany.venda_sorvete_n1.joseMauro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Mauro
 */
public class Estoque {
    private List<Produto> produtos;
    
    public Estoque(){
    this.produtos = new ArrayList<>();
}
    
    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }
    
    public int calcularQuantidadeEstoque(){
        int total = 0;
        for(Produto produto : produtos){
            total = total + produto.getQtdEstoque();
        }
        return total;
    }
}
