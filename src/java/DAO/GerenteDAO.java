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
import modelo.Gerente;

/**
 *
 * @author Aluno
 */
public class GerenteDAO {

    public static List<Gerente> obterGerentes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Gerente> gerentes = new ArrayList<Gerente>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from gerente");
            while (rs.next()) {
                Gerente gerente = new Gerente(rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("dataNascimento"),
                        rs.getInt("codGerente"));
                gerentes.add(gerente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return gerentes;
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
