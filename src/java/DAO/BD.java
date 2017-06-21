/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class BD {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/sge", "root", "");
        return conexao;
    }
    
    public static void fecharConexao(Connection conexao) throws SQLException {
        try {
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
