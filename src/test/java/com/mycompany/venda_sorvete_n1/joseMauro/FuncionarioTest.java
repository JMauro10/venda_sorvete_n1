package com.mycompany.venda_sorvete_n1.joseMauro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.mycompany.venda_sorvete_n1.alexandre.Funcionario;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuncionarioTest {

    private Funcionario alexandre;
    private Funcionario joseMauro;
    private Funcionario mariaClara;

    public FuncionarioTest() {
    }

    @BeforeEach
    public void setUp() {
        alexandre = new FuncionarioBuilder().criarFuncionario("Alexandre", "987.654.321-00", "Gerente",
                java.time.LocalDate.of(2022, 5, 10), 3000.00).controi();
        joseMauro = new FuncionarioBuilder().criarFuncionario("José Mauro", "123.456.789-00", "Atendente",
                java.time.LocalDate.of(2023, 1, 15), 1500.00).controi();
        mariaClara = new FuncionarioBuilder().criarFuncionario("Maria Clara", "111.222.333-44", "Atendente",
                java.time.LocalDate.of(2023, 3, 20), 1500.00).controi();
    }

    @Test
    public void testarAumentarSalario() {
        System.out.println("Testar Aumentar Salário");

        double aumentoAlexandre = 300.00; // 10% de 3000.00
        double aumentoJoseMauro = 150.00; // 10% de 1500.00
        double aumentoMariaClara = 150.00; // 10% de 1500.00

        double novoSalarioAlexandre = alexandre.getSalario() + aumentoAlexandre;
        double novoSalarioJoseMauro = joseMauro.getSalario() + aumentoJoseMauro;
        double novoSalarioMariaClara = mariaClara.getSalario() + aumentoMariaClara;

        assert novoSalarioAlexandre == 3300.00 : "Salário do Alexandre incorreto";
        assert novoSalarioJoseMauro == 1650.00 : "Salário do José Mauro incorreto";
        assert novoSalarioMariaClara == 1650.00 : "Salário da Maria Clara incorreto";
    }

}
