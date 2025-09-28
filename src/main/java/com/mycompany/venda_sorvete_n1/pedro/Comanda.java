/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.venda_sorvete_n1.pedro;

import com.mycompany.venda_sorvete_n1.alexandre.Cliente;
import com.mycompany.venda_sorvete_n1.alexandre.Funcionario;
import com.mycompany.venda_sorvete_n1.alexandre.ItemComanda;
import com.mycompany.venda_sorvete_n1.joseMauro.Produto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Comanda {

    private Integer idComanda;
    private LocalDateTime data_abertura;
    private LocalDateTime data_fechamento;
    private String status; // "Aberta", "Fechada", "Cancelada"
    private Cliente cliente;
    private Funcionario funcionario;
    private List<ItemComanda> itens;

    public Comanda(Cliente cliente, Funcionario funcionario) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.itens = new ArrayList<>();
        this.status = "Fechada"; // Inicialmente fechada
    }

    public void abrirComanda() {
        this.data_abertura = LocalDateTime.now();
        this.status = "Aberta";
    }

    public void fecharComanda() {
        if (!isAberta()) {
            throw new IllegalStateException("Comanda já está fechada ou cancelada.");
        }
        this.data_fechamento = LocalDateTime.now();
        this.status = "Fechada";
    }

    public void cancelarComanda() {
        if (!isAberta()) {
            throw new IllegalStateException("Só é possível cancelar comandas abertas.");
        }
        this.status = "Cancelada";
        this.data_fechamento = LocalDateTime.now();
    }

    public boolean isAberta() {
        return "Aberta".equalsIgnoreCase(this.status);
    }

    // Métodos para compor a comanda
    public void adicionarItem(Produto produto, int quantidade) {
        if (!isAberta()) {
            throw new IllegalStateException("Não é possível adicionar itens em comanda fechada.");
        }
        if (quantidade > produto.getQtdEstoque()) {
            throw new IllegalArgumentException("Quantidade maior que estoque disponível.");
        }
        itens.add(new ItemComanda(produto, quantidade));
        produto.setQtdEstoque(produto.getQtdEstoque() - quantidade); // baixa do estoque
    }

    public void removerItem(ItemComanda item) {
        if (!isAberta()) {
            throw new IllegalStateException("Não é possível remover itens em comanda fechada.");
        }
        itens.remove(item);
        // devolve ao estoque
        item.getProduto().setQtdEstoque(item.getProduto().getQtdEstoque() + item.getQuantidade());
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemComanda item : itens) {
            total += item.getTotalItem();
        }
        return total;
    }

    public List<ItemComanda> getItens() {
        return itens;
    }
}
