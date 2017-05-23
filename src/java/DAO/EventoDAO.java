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
import modelo.Evento;

/**
 *
 * @author Aluno
 */
public class EventoDAO {

    public static List<Evento> obterEventos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Evento> eventos = new ArrayList<Evento>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Evento");
            while (rs.next()) {
                Evento evento = new Evento(rs.getInt("idEvento"),
                        rs.getString("nomeEvento"),
                        rs.getString("duracao"),
                        rs.getString("tema"),
                        rs.getString("dataInicioEvento"),
                        rs.getString("dataFimEvento"),
                        rs.getString("dataInicioInscricao"),
                        rs.getString("dataFimInscricao"),
                        rs.getInt("Administrador_codAdministrador"));
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return eventos;
    }

    public static Evento obterEvento(int idEvento) throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        Evento evento = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from evento where idEvento =  "+ idEvento);
            rs.first();
            evento = new Evento(rs.getInt("idEvento"),
                    rs.getString("nomeEvento"),
                    rs.getString("duracao"),
                    rs.getString("tema"),
                    rs.getString("dataInicioEvento"),
                    rs.getString("dataFimEvento"),
                    rs.getString("dataInicioInscricao"),
                    rs.getString("dataFimInscricao"),
                    rs.getInt("Administrador_codAdministrador"));                    
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            fecharConexao(conexao, comando);
        }
        return evento;
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

    public static void gravar(Evento evento) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into evento(idEvento, nomeEvento, duracao, tema, dataInicioEvento, dataFimEvento, dataInicioInscricao, dataFimInscricao, Administrador_codAdministrador ) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, evento.getIdEvento());
            comando.setString(2, evento.getNomeEvento());
            comando.setString(3, evento.getDuracao());
            comando.setString(4, evento.getTema());
            comando.setString(5, evento.getDataInicioEvento());
            comando.setString(6, evento.getDataFimEvento());
            comando.setString(7, evento.getDataInicioInscricao());
            comando.setString(8, evento.getDataFimInscricao());
            comando.setInt(9, evento.getCodAdministrador());            
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
    
        public static void alterar(Evento evento) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update evento set nomeEvento = ?, duracao = ? , tema = ?, dataInicioEvento = ?, dataFimEvento = ?, dataInicioInscricao = ?, dataFimInscricao = ?, Administrador_codAdministrador = ? where idEvento = ?";
	    PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, evento.getNomeEvento());
            comando.setString(2, evento.getDuracao());
            comando.setString(3, evento.getTema());
            comando.setString(4, evento.getDataInicioEvento());
            comando.setString(5, evento.getDataFimEvento());
            comando.setString(6, evento.getDataInicioInscricao());
            comando.setString(7, evento.getDataFimInscricao());
            comando.setInt(8, evento.getCodAdministrador());   
            comando.setInt(9, evento.getIdEvento());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }

    public static void excluir(Evento evento) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from evento where idEvento= ?";
	    PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, evento.getIdEvento());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
}
