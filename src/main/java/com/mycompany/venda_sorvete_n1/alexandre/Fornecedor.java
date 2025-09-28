package com.mycompany.venda_sorvete_n1.alexandre;

/**
 *
 * @author Alexandre
 */
public class Fornecedor {
    
    private String RazaoSocial; 
    private String telefone; 
    private String email; 
    private String cnpj; 
    
    public Fornecedor(String RazaoSocial, String telefone, String email, String cnpj) { 
        this.RazaoSocial = RazaoSocial; 
        this.telefone = telefone; this.email = email; 
        this.cnpj = cnpj; 
    } 

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
