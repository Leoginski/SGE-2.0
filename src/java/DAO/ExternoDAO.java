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
import modelo.Externo;

/**
 *
 * @author Aluno
 */
public class ExternoDAO {

    public static List<Externo> obterExternos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Externo> externos = new ArrayList<Externo>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from externo");
            while (rs.next()) {
                Externo externo = new Externo(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("dataNascimento"),
                        rs.getString("conhecimento"),
                        rs.getInt("idExterno"));
                externos.add(externo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return externos;
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
