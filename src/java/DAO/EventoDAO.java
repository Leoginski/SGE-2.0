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
