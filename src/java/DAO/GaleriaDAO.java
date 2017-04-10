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
import modelo.Galeria;

/**
 *
 * @author Aluno
 */
public class GaleriaDAO {

    public static List<Galeria> obterGalerias() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Galeria> galerias = new ArrayList<Galeria>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Galeria");
            while (rs.next()) {
                Galeria galeria = new Galeria(
                        rs.getInt("idGaleria"),
                        rs.getString("data"),
                        null
                        );
                galeria.setIdEvento(rs.getInt("idEvento"));
                galerias.add(galeria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return galerias;
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
