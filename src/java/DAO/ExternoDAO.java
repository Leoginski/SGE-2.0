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
                        rs.getInt("idExterno"),
                        rs.getString("conhecimento"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("dataNascimento"),
                        rs.getString("senha")
                                            );
                externos.add(externo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return externos;
    }

        public static Externo obterExterno(int idExterno) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Externo externo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from externo where idExterno=" + idExterno);
            rs.first();
                externo = new Externo(
                        rs.getInt("idExterno"),
                        rs.getString("conhecimento"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("dataNascimento"),
                        rs.getString("senha"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return externo;
    }
    
    public static void gravar(Externo externo) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into externo(idExterno, conhecimento, nome, email, dataNascimento, senha) values (?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, externo.getIdExterno());
            comando.setString(2, externo.getConhecimento());
            comando.setString(3, externo.getNome());
            comando.setString(4, externo.getEmail());
            comando.setString(5, externo.getDataNascimento());
            comando.setString(6, externo.getSenha());
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

    public static void alterar(Externo externo) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update externo set conhecimento = ?, nome = ?, email = ?, dataNascimento = ?, senha = ? where idExterno = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, externo.getConhecimento());
            comando.setString(2, externo.getNome());
            comando.setString(3, externo.getEmail());
            comando.setString(4, externo.getDataNascimento());
            comando.setString(5, externo.getSenha());
            comando.setInt(6, externo.getIdExterno());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }

    
    public static void excluir(Externo externo) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from externo where idExterno= ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, externo.getIdExterno());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }    
    
    
}
