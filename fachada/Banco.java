/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dados.Cliente;
import dados.Endereco;
import dados.Pedido;
import dados.Produto;
import execoes.ClienteNaoEncontrado;
import execoes.PedidoNaoEncontrado;
import execoes.ProdutoNaoEncontrado;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Cadastro;

/**
 *
 * @author EDSON
 */
public class Banco implements Fachada{

    private Cadastro cadastro;
    
    public Banco(){
        this.cadastro = new Cadastro();
    }
    
    @Override
    public void CadastrarCliente(Cliente c, Endereco endereco) throws SQLException {
        this.cadastro.CadastrarCliente(c,endereco);
    }

    @Override
    public void CadastrarProduto(Produto p) throws SQLException {
        this.cadastro.CadastrarProduto(p);
    }

    @Override
    public void CadastrarPedido(ArrayList a,Pedido pe) throws SQLException {
        this.cadastro.CadastrarPedido(a,pe);
    }

    @Override
    public void RemoverCliente(String cpf) throws SQLException, ClienteNaoEncontrado {
        this.cadastro.RemoverCliente(cpf);
    }

    @Override
    public void RemoverProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado {
        this.cadastro.RemoverProduto(codigoProduto);
    }

    @Override
    public void RemoverPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        this.cadastro.RemoverPedido(codigoPedido);
    }

    @Override
    public Cliente ConsultarCliente(String cpf) throws SQLException, ClienteNaoEncontrado {
         return this.cadastro.ConsultarCliente(cpf);
    }
    

    @Override
    public Produto ConsultarProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado {
        return this.cadastro.ConsultarProduto(codigoProduto);
    }

    @Override
    public Pedido ConsultarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        return this.cadastro.ConsultarPedido(codigoPedido);
    }

    @Override
    public void AlterarCliente(String cpf, Endereco endereco) throws SQLException, ClienteNaoEncontrado {
        this.cadastro.AlterarCliente(cpf, endereco);
    }

    @Override
    public void AlterarProduto(int codigo,Produto p) throws SQLException, ProdutoNaoEncontrado {
        this.cadastro.AlterarProduto(codigo,p);
    }

    @Override
    public void AlterarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        this.cadastro.AlterarPedido(codigoPedido);
    }
    
}
