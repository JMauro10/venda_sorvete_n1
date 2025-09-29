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
    private double salario;

    public Funcionario(String nome, String cpf, String cargo, LocalDate data_admissao, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.data_admissao = data_admissao;
        this.salario = salario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double aumentarSalario(double percentual) {
        if (percentual > 0) {
            double aumento = (this.salario * percentual) / 100;
            this.salario += aumento;
        }
        return this.salario;
    }

}
