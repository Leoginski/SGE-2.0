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
import modelo.Proposta;

/**
 *
 * @author Pc
 */
public class PropostaDAO {

    public static List<Proposta> obterPropostas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Proposta> propostas = new ArrayList<Proposta>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Proposta");
            while (rs.next()) {
                Proposta proposta = new Proposta(
                        rs.getInt("idProposta"),
                        rs.getString("proponente"),
                        rs.getString("emailProponente"),
                        rs.getString("tipoAtividade"),
                        rs.getString("tituloAtividade"),
                        rs.getString("finalidadeAtividade"),
                        rs.getString("cargaHoraria"),
                        rs.getInt("vagasAtividade"),
                        rs.getString("nomeConvidado"),
                        rs.getString("emailConvidado"),
                        rs.getString("formacaoConvidado"),
                        rs.getString("origem"),
                        rs.getString("informacoesComplementares"),
                        rs.getInt("diaria"),
                        rs.getString("estado"),
                        rs.getInt("exclusiva"),
                        rs.getInt("preferencial"),
                        rs.getInt("especifica"),
                        rs.getInt("publico_todos"),
                        rs.getInt("publico_informatica"),
                        rs.getInt("publico_edificacoes"),
                        rs.getInt("publico_eletromecanica"),
                        rs.getInt("publico_eletrotecnica"),
                        rs.getInt("publico_mecanica"),
                        rs.getInt("publico_metalurgia"),
                        rs.getInt("publico_eventos"),
                        rs.getInt("publico_secretariado"),
                        rs.getInt("publico_designMoveis"),
                        rs.getInt("publico_eletronica"),
                        rs.getInt("publico_transacoesImobiliarias"),
                        rs.getInt("publico_transporteFerroviario"),
                        rs.getInt("publico_sistemasInformacao"),
                        rs.getInt("publico_engMecatronica"),
                        rs.getInt("publico_engMetalurgica"),
                        rs.getInt("publico_fisica"),
                        rs.getInt("segunda"),
                        rs.getInt("terca"),
                        rs.getInt("quarta"),
                        rs.getInt("quinta"),
                        rs.getInt("sexta"),
                        rs.getInt("sabado"),
                        null, null, null,
                        rs.getString("dataInicio"), 
                        rs.getString("dataFim")
                        
                       
                );
                propostas.add(proposta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return propostas;
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
