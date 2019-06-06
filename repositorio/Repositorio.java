/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import conexao.FabricaConexao;
import dados.Cliente;
import dados.Endereco;
import dados.Pedido;
import dados.Produto;
import execoes.ClienteNaoEncontrado;
import execoes.PedidoNaoEncontrado;
import execoes.ProdutoNaoEncontrado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author EDSON
 */
public class Repositorio implements InterfaceRepositorio {

    private Connection conexao;

    public Repositorio() {
        this.conexao = new FabricaConexao().getConexao();
    }

    @Override
    public void CadastrarCliente(Cliente c, Endereco endereco) throws SQLException {

        String sql = "insert into cliente (rg,nome,cpf) values (?,?,?) ";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setString(1, c.getRg());
        statement.setString(2, c.getNome());
        statement.setString(3, c.getCpf());
        statement.execute();
        String sqlEndereco = "insert into endereco (id_endereco,rua,bairro,cidade,estado,pais,cep) values (?,?,?,?,?,?,?) ";
        statement = this.conexao.prepareStatement(sqlEndereco);
        statement.setString(1, c.getCpf());
        statement.setString(2, endereco.getRua());
        statement.setString(3, endereco.getBairro());
        statement.setString(4, endereco.getCidade());
        statement.setString(5, endereco.getEstado());
        statement.setString(6, endereco.getPais());
        statement.setString(7, endereco.getCep());
        statement.execute();
        statement.close();

    }

    @Override
    public void CadastrarProduto(Produto p) throws SQLException {
        String sql = "insert into produto (codigo,estoque,descricao,valor_unitario) values (?,?,?,?) ";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, p.getCodigoProduto());
        statement.setInt(2, p.getEstoque());
        statement.setString(3, p.getDescricao());
        System.out.println(p.getDescricao());
        statement.setDouble(4, p.getValor_unitario());
        statement.execute();
        statement.close();
    }

    @Override
    public void CadastrarPedido(ArrayList a,Pedido pe) throws SQLException {
        String sql="insert into pedido (codigo_pedido,dosconto,total_sem_desconto,total_geral,data_pedido,id_cliente) values (?,?,?,?,?,?)";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, pe.getCodigoPedido());
        statement.setDouble(2,pe.getDesconto());
        statement.setDouble(4, pe.getTotal_sem_desconto());
        statement.setDouble(5, pe.getTotal_geral());
        statement.setString(6, pe.getData_pedido());
        statement.setString(7, pe.getCpfCliente());
        statement.execute();
        statement.close();
    }

    @Override
    public void RemoverCliente(String cpf) throws SQLException, ClienteNaoEncontrado {
        String sql = "delete  from cliente where cpf=?";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.executeUpdate();
        if (statement.executeUpdate() == 1) {
            statement.close();
            throw new ClienteNaoEncontrado();

        } else {
            String sqlEndereco = "delete from endereco where id_endereco=?";
            statement = this.conexao.prepareStatement(sqlEndereco);
            statement.setString(1, cpf);
            statement.executeUpdate();
        }
        statement.close();
    }

    @Override
    public void RemoverProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado {
        String sql = "delete from produto where codigo=?";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, codigoProduto);
        statement.executeUpdate();
        if (statement.executeUpdate() == 1) {
            statement.close();
            throw new ProdutoNaoEncontrado();
        }
        statement.close();
    }

    @Override
    public void RemoverPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente ConsultarCliente(String cpf) throws SQLException, ClienteNaoEncontrado {
        String sql = "select * from cliente where cpf=?";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setString(1, cpf);
        ResultSet resultset = statement.executeQuery();
        if (resultset.next() == false) {
            throw new ClienteNaoEncontrado();
        } else {
            Cliente c = null;
            c = new Cliente();
            c.setRg(resultset.getString("rg"));
            c.setNome(resultset.getString("nome"));
            c.setCpf(resultset.getString("cpf"));
            c.setEndereco(RetornoEndereco(cpf));
            return c;
        }
    }

    public Endereco RetornoEndereco(String cpf) throws SQLException, ClienteNaoEncontrado {
        String sqlEndereco = "select * from endereco where id_endereco=?";
        PreparedStatement statement = this.conexao.prepareStatement(sqlEndereco);
        statement.setString(1, cpf);
        Endereco endereco = null;
        ResultSet resultset = statement.executeQuery();
        if (resultset.next() == false) {
            throw new ClienteNaoEncontrado();
        } else {
            endereco = new Endereco();
            endereco.setRua(resultset.getString("rua"));
            endereco.setBairro(resultset.getString("bairro"));
            endereco.setCidade(resultset.getString("cidade"));
            endereco.setEstado(resultset.getString("estado"));
            endereco.setPais(resultset.getString("pais"));
            endereco.setCep(resultset.getString("cep"));

            return endereco;
        }
    }

    ;
    @Override
    public Produto ConsultarProduto(int codigoProduto) throws SQLException, ProdutoNaoEncontrado {
        String sql = "select * from produto where codigo=?";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, codigoProduto);
        ResultSet resultset = statement.executeQuery();
        if (resultset.next() == false) {
            throw new ProdutoNaoEncontrado();
        } else {
            Produto p = new Produto();
            p.setCodigoProduto(resultset.getInt("codigo"));
            p.setEstoque(resultset.getInt("estoque"));
            p.setDescricao(resultset.getString("descricao"));
            p.setValor_unitario(resultset.getDouble("valor_unitario"));
            return p;
        }
    }

    @Override
    public Pedido ConsultarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AlterarCliente(String cpf, Endereco endereco) throws SQLException, ClienteNaoEncontrado {
        String sqlEndereco = "update endereco set id_endereco=?, rua=?, bairro=?, cidade=?,estado=?, pais=?, cep=? where id_endereco=?";
        PreparedStatement statement = this.conexao.prepareStatement(sqlEndereco);
        statement.setString(1, cpf);
        statement.setString(2, endereco.getRua());
        statement.setString(3, endereco.getBairro());
        statement.setString(4, endereco.getCidade());
        statement.setString(5, endereco.getEstado());
        statement.setString(6, endereco.getPais());
        statement.setString(7, endereco.getCep());
        statement.setString(8, cpf);
        statement.executeUpdate();
        statement.close();

    }

    @Override
    public void AlterarProduto(int codigo, Produto p) throws SQLException, ProdutoNaoEncontrado {
        String sql = "update produto set codigo=?, estoque=?, descricao=?, valor_unitario=? where codigo=?";
        PreparedStatement statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, codigo);
        statement.setInt(2, p.getEstoque());
        statement.setString(3, p.getDescricao());
        statement.setDouble(4, p.getValor_unitario());
        statement.setInt(5, codigo);
        statement.executeUpdate();
    }

    @Override
    public void AlterarPedido(int codigoPedido) throws SQLException, PedidoNaoEncontrado {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
