/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.venda_sorvete_n1.joseMauro;


import com.mycompany.venda_sorvete_n1.joseMauro.Estoque;
import com.mycompany.venda_sorvete_n1.joseMauro.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author José Mauro
 */
public class EstoqueTest {
   
    
    public EstoqueTest() {
      
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   
    @Test
    public void testCalcularQuantidadeEstoque() {
        System.out.println("calcularQuantidadeEstoque");
        
        Estoque estoque = new Estoque();
          
        Produto produto1 = new Produto(1, "Sorvete Napolitano", 25.90, 3);
        Produto produto2 = new Produto(2, "Sorvete Flocos", 21.90, 2);    
        Produto produto3 = new Produto(3, "Sorvete Creme", 23.90, 1);
  
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        estoque.adicionarProduto(produto3);
        
        int expResult = 6;
        int result = estoque.calcularQuantidadeEstoque();
        assertEquals(expResult, result);
    }
    
}
