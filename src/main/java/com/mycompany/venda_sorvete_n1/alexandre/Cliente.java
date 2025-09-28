package com.mycompany.venda_sorvete_n1.alexandre;

import java.time.LocalDate;

/**
 *
 * @author Alexandre
 */
public class Cliente {
    
    private String nome; 
    private String cpf; 
    private String telefone; 
    private LocalDate data_cadastro;

    public Cliente(String nome, String cpf, String telefone, LocalDate data_cadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data_cadastro = data_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
}
