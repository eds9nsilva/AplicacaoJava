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
public class Produto {

    String descricao;

    int codigoProduto;

    int estoque;

    double valor_unitario;

    public Produto(String descricao, int codigo, int estoque, double valor) {
        this.estoque = estoque;
        this.descricao = descricao;
        this.valor_unitario = valor;
        this.codigoProduto = codigo;

    }

    public Produto() {

    }

    public Produto(String descricao, int estoque, double valor) {
        this.descricao= descricao;
        this.estoque = estoque;
        this.valor_unitario = valor;
    }

 
    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

}
