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
            while(rs.next()){
                Gerente gerente = new Gerente(
                        rs.getInt("codGerente"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("dataNascimento")
                        );
                gerentes.add(gerente);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return gerentes;
    }

    
    public static Gerente obterGerente(int idGerente) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Gerente gerente = null;    
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from gerente where codGerente=" + idGerente);
            rs.first();
                gerente = new Gerente(
                        rs.getInt("codGerente"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("dataNascimento"));
                
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return gerente;
    }

    
    public static void gravar(Gerente gerente) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into gerente(codGerente, nome, email, dataNascimento, senha) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, gerente.getCodGerente());
            comando.setString(2, gerente.getNome());
            comando.setString(3, gerente.getEmail());
            comando.setString(4, gerente.getDataNascimento());
            comando.setString(5, gerente.getSenha());
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

    public static void alterar(Gerente gerente) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update gerente set nome = ?, email = ? , dataNascimento = ?, senha = ? where codGerente = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, gerente.getNome());
            comando.setString(2, gerente.getEmail());
            comando.setString(3, gerente.getDataNascimento());
            comando.setString(4, gerente.getSenha());
            comando.setInt(5, gerente.getCodGerente());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }    
    
    public static void excluir(Gerente gerente) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from gerente where codGerente= ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, gerente.getCodGerente());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }        
}

