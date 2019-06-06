/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.Cliente;
import dados.Endereco;
import dados.Pedido;
import dados.Produto;
import execoes.ClienteNaoEncontrado;
import execoes.PedidoNaoEncontrado;
import execoes.ProdutoNaoEncontrado;
import java.sql.SQLException;
import java.util.ArrayList;
import repositorio.Repositorio;

/**
 *
 * @author EDSON
 */
public class Cadastro implements InterfaceCadastro{
    
    private Repositorio repositorio;
    
    public Cadastro(){
        this.repositorio = new Repositorio();
    }
    
    @Override
    public void CadastrarCliente(Cliente c,Endereco endereco) throws SQLException {
        this.repositorio.CadastrarCliente(c,endereco);
    }

    @Override
    public void CadastrarProduto(Produto p) throws SQLException {
        this.repositorio.CadastrarProduto(p);
    }

    @Override
    public void CadastrarPedido(ArrayList a,Pedido pe) throws SQLException {
        this.repositorio.CadastrarPedido(a,pe);
    }

    @Override
    public void RemoverCliente(String cpf) throws SQLException, ClienteNaoEncontrado {
        this.repositorio.RemoverCliente(cpf);
    }

    @Override
    public void RemoverProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado {
        this.repositorio.RemoverProduto(codigoProduto);
    }

    @Override
    public void RemoverPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        this.repositorio.RemoverPedido(codigoPedido);
    }

    @Override
    public Cliente ConsultarCliente(String cpf) throws SQLException, ClienteNaoEncontrado {
        return this.repositorio.ConsultarCliente(cpf);
    }
   

    @Override
    public Produto ConsultarProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado {
        return this.repositorio.ConsultarProduto(codigoProduto);
    }

    @Override
    public Pedido ConsultarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        return this.repositorio.ConsultarPedido(codigoPedido);
    }

    @Override
    public void AlterarCliente(String cpf, Endereco endereco) throws SQLException, ClienteNaoEncontrado {
        this.repositorio.AlterarCliente(cpf, endereco);
    }

    @Override
    public void AlterarProduto(int codigo,Produto p) throws SQLException, ProdutoNaoEncontrado {
        this.repositorio.AlterarProduto(codigo,p);
    }

    @Override
    public void AlterarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        this.repositorio.AlterarPedido(codigoPedido);
    }
    
}
