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
public class Pedido {

    double desconto, total_sem_desconto, total_geral;
    String data_pedido;
    String cpfCliente;
    int codigoPedido;

    public Pedido(double desconto, double total_sem_desconto, double total_geral, String data_pedido, String cpfCliente, int codigoPedido) {
        this.desconto = desconto;
        this.total_sem_desconto = total_sem_desconto;
        this.total_geral = total_geral;
        this.data_pedido = data_pedido;
        this.cpfCliente = cpfCliente;
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotal_sem_desconto() {
        return total_sem_desconto;
    }

    public void setTotal_sem_desconto(double total_sem_desconto) {
        this.total_sem_desconto = total_sem_desconto;
    }

    public double getTotal_geral() {
        return total_geral;
    }

    public void setTotal_geral(double total_geral) {
        this.total_geral = total_geral;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

}
