package com.mycompany.venda_sorvete_n1.joseMauro;

import com.mycompany.venda_sorvete_n1.alexandre.Funcionario;

class FuncionarioBuilder {
    
    private Funcionario funcionario;

    public FuncionarioBuilder(){
        super();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioBuilder criarFuncionario(String nome, String cpf, String cargo, 
            java.time.LocalDate data_admissao, double salario){
        this.funcionario = new Funcionario(nome, cpf, cargo, data_admissao, salario);
        return this;
    }

    public Funcionario controi(){
        return getFuncionario();
    }
}