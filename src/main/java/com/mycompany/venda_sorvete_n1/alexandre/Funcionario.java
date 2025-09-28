package com.mycompany.venda_sorvete_n1.alexandre;

import java.time.LocalDate;

/**
 *
 * @author Alexandre
 */
public class Funcionario {
    
    private String nome; 
    private String cpf; 
    private String cargo; 
    private LocalDate data_admissao;

    public Funcionario(String nome, String cpf, String cargo, LocalDate data_admissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.data_admissao = data_admissao;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(LocalDate data_admissao) {
        this.data_admissao = data_admissao;
    }

}
