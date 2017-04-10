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
import modelo.Certificado;

/**
 *
 * @author Aluno
 */
public class CertificadoDAO {

    public static List<Certificado> obterCertificados() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Certificado> certificados = new ArrayList<Certificado>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Certificado");
            while (rs.next()) {
                Certificado certificado = new Certificado(
                        rs.getInt("codCertificado"),
                        rs.getString("descricao"),
                        rs.getInt("codProposta"));
                certificados.add(certificado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return certificados;
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
