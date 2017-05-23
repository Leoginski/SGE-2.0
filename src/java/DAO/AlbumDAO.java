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

        public static Album obterAlbum() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Album album = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Album");
            rs.first();
                album = new Album(
                        rs.getInt("idAlbum"),
                        rs.getString("descricao"),
                        rs.getString("titulo"),
                        null
                        );
                album.setIdGaleria(rs.getInt("idGaleria"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return album;
    }

    
    public static void gravar(Album album) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
//            String sql = "insert into aluno(idAluno, nome, email, dataNascimento, senha) values (?,?,?,?,?,?)";
//            PreparedStatement comando = conexao.prepareStatement(sql);
//            comando.setInt(1, aluno.getIdAluno());
//            comando.setString(2, aluno.getNome());
//            comando.setString(3, aluno.getEmail());
//            comando.setString(4, aluno.getDataNascimento());
//            comando.setString(5, aluno.getSenha());

            //só descomentar daqui pra baixo
//        comando.execute();
//        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
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

    public static void alterar(Album aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
