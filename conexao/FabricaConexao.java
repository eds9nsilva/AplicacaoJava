/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EDSON
 */
public class FabricaConexao {
    
    public static Connection getConexao() {
        try {
            return DriverManager.getConnection("Nome do Banco de dados", "Usuario do banco", "Senha do banco") ;
        }catch (SQLException e) {
            throw new RuntimeException(e) ;
        }
    }

}
