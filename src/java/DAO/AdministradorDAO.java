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
import modelo.Administrador;
//import org.apache.coyote.http11.Constants;

//**
// *
// * @author Leonardo
// */
public class AdministradorDAO {

    public static List<Administrador> obterAdministradores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Administrador> administradores = new ArrayList<Administrador>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Administrador");
            while (rs.next()) {
                Administrador administrador = new Administrador(
                        rs.getInt("codAdministrador"),
                        rs.getString("nome"),
                        rs.getString("dataNascimento"),
                        rs.getString("email"),
                        rs.getString("senha"));
                administradores.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return administradores;
    }
    
    public static void gravar(Administrador administrador) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into administrador(codAdministrador, nome, dataNascimento, email, senha) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, administrador.getCodAdministrador());
            comando.setString(2, administrador.getNome());
            comando.setString(3, administrador.getDataNascimento());
            comando.setString(4, administrador.getEmail());
            comando.setString(5, administrador.getSenha());
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


    
    public static Administrador obterAdministrador(int codAdministrador) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Administrador administrador = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Administrador where codAdministrador = " + codAdministrador);
            rs.first();
            administrador = new Administrador(
                rs.getInt("codAdministrador"),
                rs.getString("nome"),
                rs.getString("dataNascimento"),
                rs.getString("email"),
                rs.getString("senha"));
                return administrador;
            }catch (SQLException e){
                e.printStackTrace();
            }finally{
                fecharConexao(conexao, comando);
            }
        return administrador;
    }

    public static void alterar(Administrador administrador) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update administrador set nome=?, dataNascimento=?, email=?, senha=? where codAdministrador=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, administrador.getNome());
            comando.setString(2, administrador.getDataNascimento());
            comando.setString(3, administrador.getEmail());
            comando.setString(4, administrador.getSenha());
            comando.setInt(5, administrador.getCodAdministrador());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    
        public static void excluir(Administrador administrador) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();    
            String sql = "delete from Administrador where codAdministrador=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, administrador.getCodAdministrador());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
//    public static void excluir(Administrador administrador) throws SQLException, ClassNotFoundException{
//    try{
//        Connection db = BD.getConexao();
//        PreparedStatement st = db.prepareStatement("delete from Administrador where codAdministrador=?");
//        st.setInt(1, administrador.getCodAdministrador());
//        st.executeUpdate();
//        st.close();
//    }catch(SQLException e){
//        
//    }
//    }
    
    
}
    
