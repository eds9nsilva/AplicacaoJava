/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import dados.Cliente;
import dados.Endereco;
import dados.Pedido;
import dados.Produto;
import execoes.ClienteNaoEncontrado;
import execoes.ProdutoNaoEncontrado;
import fachada.Banco;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDSON
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClienteNaoEncontrado, ProdutoNaoEncontrado {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Banco banco = new Banco();
        Cliente c;
        Endereco endereco;
        Produto p;
        Pedido pe;
        int opcao = 0;
        do {
            System.out.println("-------------------------");
            System.out.println("1: Cadastrar Cliente");
            System.out.println("2: Cadastrar Produto");
            System.out.println("3: Cadastrar Pedido");
            System.out.println("4: Consultar Cliente");
            System.out.println("5: Consultar Produto");
            System.out.println("6: Consultar Pedido");
            System.out.println("7: Remover Cliente");
            System.out.println("8: Remover Produto");
            System.out.println("9: Remover Pedido");
            System.out.println("10: Alterar Cliente");
            System.out.println("11: Alterar Produto");
            System.out.println("12: Alterar Pedido");
            System.out.println("13: Sair");
            System.out.print("Digiter Opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("");
                    System.out.print("Digiter Cpf:");
                    String cpf = teclado.nextLine();
                    System.out.print("Digiter Rg: ");
                    String rg = teclado.nextLine();
                    System.out.print("Digiter nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("Rua:");
                    String rua = teclado.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = teclado.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = teclado.nextLine();
                    System.out.print("Estado: ");
                    String estado = teclado.nextLine();
                    System.out.print("Pais: ");
                    String pais = teclado.nextLine();
                    System.out.print("Cep: ");
                    String cep = teclado.nextLine();
                    endereco = new Endereco(rua, bairro, cidade, estado, pais, cep);
                    c = new Cliente(cpf, rg, nome);
                    banco.CadastrarCliente(c, endereco);
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Descrição: ");
                    String descricao = teclado.nextLine();
                    System.out.print("Código Produto: ");
                    int codigo = teclado.nextInt();
                    System.out.print("Estoque: ");
                    int estoque = teclado.nextInt();
                    System.out.print("Valor por unidade: ");
                    double valor = teclado.nextDouble();
                    p = new Produto(descricao, codigo, estoque, valor);
                    banco.CadastrarProduto(p);
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Codigo pedido: ");
                    int codigoPedido = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Data Pedido: ");
                    String data_pedido = teclado.nextLine();
                    System.out.print("Desconto: ");
                    double desconto = teclado.nextDouble();
                    System.out.print("Total sem desconto: ");
                    double total_sem_desconto = teclado.nextDouble();
                    System.out.print("Total: ");
                    double total_geral = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.print("Cpf Cliente: ");
                    String cpfCliente = teclado.nextLine();
                    
                    
                    System.out.print("Codigo Produto: ");
                    int codigoProduto = teclado.nextInt();
                    System.out.print("Quantidade: ");
                    int quantidade = teclado.nextInt();
                   
                    
                    pe = new Pedido (desconto,total_sem_desconto,total_geral,data_pedido,cpfCliente,codigoPedido);
                    break;
                case 4:
                    System.out.println("");
                    System.out.print("Cpf: ");
                    cpf = teclado.nextLine();
                    c = banco.ConsultarCliente(cpf);
                    System.out.println("Nome: " + c.getNome());
                    System.out.println("Rg: " + c.getRg());
                    System.out.println("Rua: " + c.getEndereco().getRua());
                    System.out.println("Bairro: " + c.getEndereco().getBairro());
                    System.out.println("Cidade: " + c.getEndereco().getCidade());
                    System.out.println("Estado: " + c.getEndereco().getEstado());
                    System.out.println("Pais: " + c.getEndereco().getPais());
                    System.out.println("Cep: " + c.getEndereco().getCep());
                    break;
                case 5:
                    System.out.println("");
                    System.out.print("Código Produto: ");
                    codigo = teclado.nextInt();
                    p = banco.ConsultarProduto(codigo);
                    System.out.println("");
                    System.out.println("Código Produto: " + p.getCodigoProduto());
                    System.out.println("Descriçao: " + p.getDescricao());
                    System.out.println("Estoque: " + p.getEstoque());
                    System.out.println("Valor unitario" + p.getValor_unitario());
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("");
                    System.out.print("Cpf: ");
                    cpf = teclado.nextLine();
                    banco.RemoverCliente(cpf);
                    break;
                case 8:
                    System.out.println("");
                    System.out.print("Codigo: ");
                    codigo = teclado.nextInt();
                    banco.RemoverProduto(codigo);
                    break;
                case 9:
                    break;
                case 10:
                    System.out.println("");
                    System.out.print("Cpf: ");
                    cpf = teclado.nextLine();
                    c = banco.ConsultarCliente(cpf);
                    if (c != null) {
                        System.out.print("Rua:");
                        rua = teclado.nextLine();
                        System.out.print("Bairro: ");
                        bairro = teclado.nextLine();
                        System.out.print("Cidade: ");
                        cidade = teclado.nextLine();
                        System.out.print("Estado: ");
                        estado = teclado.nextLine();
                        System.out.print("Pais: ");
                        pais = teclado.nextLine();
                        System.out.print("Cep: ");
                        cep = teclado.nextLine();
                        endereco = new Endereco(rua, bairro, cidade, estado, pais, cep);
                        banco.AlterarCliente(cpf, endereco);
                    }
                    break;
                case 11:
                    System.out.println("");
                    System.out.print("Codigo: ");
                    codigo = teclado.nextInt();
                    teclado.nextLine();
                    p = banco.ConsultarProduto(codigo);
                    if (p != null) {
                        System.out.print("Descrição: ");
                        descricao = teclado.nextLine();
                        System.out.print("Estoque: ");
                        estoque = teclado.nextInt();
                        System.out.print("Valor por unidade: ");
                        valor = teclado.nextDouble();
                        p = new Produto(descricao, estoque, valor);
                        banco.AlterarProduto(codigo, p);
                    }
                    break;
                case 12:
                    break;
                case 13:
                    break;
            }
        } while (opcao != 13);
    }

}
