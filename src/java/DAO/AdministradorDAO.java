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
import modelo.Administrador;

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
