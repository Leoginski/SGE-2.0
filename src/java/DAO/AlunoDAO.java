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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

/**
 *
 * @author Aluno
 */
public class AlunoDAO {

    public static List<Aluno> obterAlunos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Aluno");
            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("dataNascimento"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return alunos;
    }
    
    public static Aluno obterAluno(int idAluno) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Aluno aluno = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Aluno where idAluno = " + idAluno);
            rs.first();
            aluno = new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("dataNascimento"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return aluno;
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
// se tiver combo      String sql = "insert into aluno(idAluno, nome, email, senha, dataNascimento, professorCoordenador values)"
    //if (curso.getCoordenador() == null){
        //comando.setNull(6, Types.NULL);
        //}else{
        //comando.setInt(6, curso.getCoordenador().getMatricula());
        //}
    public static void gravar(Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into aluno(idAluno, nome, email, dataNascimento, senha) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, aluno.getIdAluno());
            comando.setString(2, aluno.getNome());
            comando.setString(3, aluno.getEmail());
            comando.setString(4, aluno.getDataNascimento());
            comando.setString(5, aluno.getSenha());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }

    public static void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update aluno set nome = ?, email = ?, dataNascimento = ?, senha = ? where idAluno = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getEmail());
            comando.setString(3, aluno.getDataNascimento());
            comando.setString(4, aluno.getSenha());
            comando.setInt(5, aluno.getIdAluno());
//            if (curso.getCoordenador() == null){
//                comando.setNull(5, Types.NULL);
//            }else{
//                comando.setInt(5, curso.getCodCurso());
//            }
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    

    public static void excluir(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from aluno where idAluno = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, aluno.getIdAluno());
//            if (curso.getCoordenador() == null){
//                comando.setNull(5, Types.NULL);
//            }else{
//                comando.setInt(5, curso.getCodCurso());
//            }
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    
    
}
