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
    
    public static Local obterLocal(int idLocal) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Local local = null;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Local where idLocal=" + idLocal);
            rs.first();
                 local = new Local(
                        rs.getInt("idLocal"),
                        rs.getString("descricao"),
                        rs.getInt("capacidade"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return local;
    }

    public static void gravar(Local local) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into local(idLocal, descricao, capacidade) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, local.getIdLocal());
            comando.setString(2, local.getDescricao());
            comando.setInt(3, local.getCapacidade());
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
    
    public static void alterar(Local local) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update local set descricao =?, capacidade = ? where idLocal=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, local.getDescricao());
            comando.setInt(2, local.getCapacidade());
            comando.setInt(3, local.getIdLocal());
            comando.execute();
            comando.close();
            conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    
        public static void excluir(Local local) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from local where idLocal= ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, local.getIdLocal());
            comando.execute();
            comando.close();
            conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    
}
