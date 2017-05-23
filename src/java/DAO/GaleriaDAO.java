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
    
    public static Galeria obterGaleria(int idGaleria) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Galeria galeria = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Galeria where idGaleria="+ idGaleria);
            rs.first();
                galeria = new Galeria(
                        rs.getInt("idGaleria"),
                        rs.getString("data"),
                        null
                        );
                galeria.setIdEvento(rs.getInt("idEvento"));
                
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return galeria;
    }

    public static void gravar(Galeria galeria) throws SQLException, ClassNotFoundException{
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

    public static void alterar(Galeria aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
