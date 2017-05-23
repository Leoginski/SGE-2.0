/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                        rs.getString("descricao"),
                        rs.getInt("Evento_idEvento"));
                noticias.add(noticia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return noticias;
    }

    public static Noticia obterNoticia(int idNoticia) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Noticia noticia = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Noticia where idNoticia="+ idNoticia);
            rs.first();
                noticia = new Noticia(
                        rs.getInt("idNoticia"),
                        rs.getString("data"),
                        rs.getString("descricao"),
                        rs.getInt("Evento_idEvento"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return noticia;
    }
    
    public static void gravar(Noticia noticia) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into noticia(idNoticia, data, descricao, Evento_idEvento) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
           comando.setInt(1, noticia.getIdNoticia());
            comando.setString(2, noticia.getData());
            comando.setString(3, noticia.getDescricao());
            comando.setInt(4, noticia.getIdEvento());
        comando.execute();
        comando.close();
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

public static void alterar(Noticia noticia) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update noticia set data = ?, descricao = ?, Evento_idEvento = ? where idNoticia = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, noticia.getData());
            comando.setString(2, noticia.getDescricao());
            comando.setInt(3, noticia.getIdEvento());
            comando.setInt(4, noticia.getIdNoticia());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }

public static void excluir(Noticia noticia) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from noticia where idNoticia = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, noticia.getIdNoticia());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    
}
