/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Local;

/**
 *
 * @author Aluno
 */
public class LocalDAO {

    public static List<Local> obterLocais() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Local> locais = new ArrayList<Local>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Local");
            while (rs.next()) {
                Local local = new Local(
                        rs.getInt("idLocal"),
                        rs.getString("descricao"),
                        rs.getInt("capacidade"));
                locais.add(local);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return locais;
    }

    private static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
        }
    }
}
