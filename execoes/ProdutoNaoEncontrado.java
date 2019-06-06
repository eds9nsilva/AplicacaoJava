/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execoes;

/**
 *
 * @author EDSON
 */
public class ProdutoNaoEncontrado extends Exception{
    public ProdutoNaoEncontrado(){
        super("Produto Não Encontrado");
    }
}
