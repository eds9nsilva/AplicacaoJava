/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.SQLException;
import dados.*;
import execoes.ClienteNaoEncontrado;
import execoes.PedidoNaoEncontrado;
import execoes.ProdutoNaoEncontrado;
import java.util.ArrayList;

/**
 *
 * @author EDSON
 */
public interface InterfaceRepositorio {

    public void CadastrarCliente(Cliente c,Endereco endereco) throws SQLException;

    public void CadastrarProduto(Produto p) throws SQLException;

    public void CadastrarPedido(ArrayList a,Pedido pe) throws SQLException;

    public void RemoverCliente(String cpf) throws SQLException, ClienteNaoEncontrado;

    public void RemoverProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado;

    public void RemoverPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado;

    public Cliente ConsultarCliente(String cpf) throws SQLException, ClienteNaoEncontrado;

    public Produto ConsultarProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado;

    public Pedido ConsultarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado;

    public void AlterarCliente(String cpf, Endereco endereco) throws SQLException, ClienteNaoEncontrado;

    public void AlterarProduto(int codigo,Produto p) throws SQLException, ProdutoNaoEncontrado;

    public void AlterarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado;

}
