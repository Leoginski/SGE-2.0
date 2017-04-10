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
import modelo.Noticia;

/**
 *
 * @author Math
 */
public class NoticiaDAO {

    public static List<Noticia> obterNoticias() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Noticia> noticias = new ArrayList<Noticia>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Noticia");
            while (rs.next()) {
                Noticia noticia = new Noticia(
                        rs.getInt("idNoticia"),
                        rs.getString("data"),
                        rs.getString("descricao"));
                noticias.add(noticia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return noticias;
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
