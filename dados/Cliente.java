/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author EDSON
 */
public class Cliente {
    String cpf,rg,nome;
    Endereco endereco= new Endereco();

    public Cliente(String cpf, String rg, String nome) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
    }

    public Cliente(String cpf) {
        this.cpf=cpf;
    }

    public Cliente() {

    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    
}
