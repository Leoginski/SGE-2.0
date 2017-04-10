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
import modelo.Album;

/**
 *
 * @author Aluno
 */
public class AlbumDAO {

    public static List<Album> obterAlbuns() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Album> albuns = new ArrayList<Album>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Album");
            while (rs.next()) {
                Album album = new Album(
                        rs.getInt("idAlbum"),
                        rs.getString("descricao"),
                        rs.getString("titulo"),
                        null
                        );
                album.setIdGaleria(rs.getInt("idGaleria"));
                albuns.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return albuns;
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
