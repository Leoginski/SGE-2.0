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
import modelo.Proposta;

/**
 *
 * @author Pc
 */
public class PropostaDAO {

    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
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
                        rs.getString("publico_alvo"),
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
                        rs.getInt("gerente_codGerente"),
                        rs.getInt("local_id"),
                        rs.getInt("evento_id"),
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

    public static Proposta obterProposta(int idProposta) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Proposta proposta = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Proposta where idproposta = " + idProposta);
            rs.first();
                proposta = new Proposta(
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
                        rs.getString("publico_alvo"),
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
                        rs.getInt("gerente_codGerente"),
                        rs.getInt("local_id"),
                        rs.getInt("evento_id"),
                        rs.getString("dataInicio"), 
                        rs.getString("dataFim"));
                        return proposta;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return proposta;
    }
    
        public static void gravar(Proposta proposta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into proposta(idProposta, proponente, emailProponente, tipoAtividade, tituloAtividade, finalidadeAtividade, cargaHoraria, vagasAtividade, nomeConvidado, emailConvidado, formacaoConvidado, origem, informacoesComplementares, diaria, estado, publico_alvo, publico_todos, publico_informatica, publico_edificacoes, publico_eletromecanica, publico_eletrotecnica, publico_mecanica, publico_metalurgia, publico_eventos, publico_secretariado, publico_designMoveis, publico_eletronica, publico_transacoesImobiliarias, publico_transporteFerroviario, publico_sistemasInformacao, publico_engMecatronica, publico_engMetalurgica, publico_fisica, segunda, terca, quarta, quinta, sexta, sabado, gerente_codGerente, local_id, evento_id, dataInicio, dataFim) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposta.getIdProposta());
            comando.setString(2, proposta.getProponente());
            comando.setString(3, proposta.getEmailProponente());
            comando.setString(4, proposta.getTipoAtividade());
            comando.setString(5, proposta.getTituloAtividade());
            comando.setString(6, proposta.getFinalidadeAtividade());
            comando.setString(7, proposta.getCargaHoraria());
            comando.setInt(8, proposta.getVagasAtividade());
            comando.setString(9, proposta.getNomeConvidado());
            comando.setString(10, proposta.getEmailConvidado());
            comando.setString(11, proposta.getFormacaoConvidado());
            comando.setString(12, proposta.getOrigem());
            comando.setString(13, proposta.getInformacoesComplementares());
            comando.setInt(14, proposta.getDiaria());
            comando.setString(15, proposta.getEstado());
            comando.setString(16, proposta.getPublico_alvo());
            comando.setInt(17, proposta.getPublico_todos());
            comando.setInt(18, proposta.getPublico_informatica());
            comando.setInt(19, proposta.getPublico_edificacoes());
            comando.setInt(20, proposta.getPublico_eletromecanica());
            comando.setInt(21, proposta.getPublico_eletrotecnica());
            comando.setInt(22, proposta.getPublico_mecanica());
            comando.setInt(23, proposta.getPublico_metalurgia());
            comando.setInt(24, proposta.getPublico_eventos());
            comando.setInt(25, proposta.getPublico_secretariado());
            comando.setInt(26, proposta.getPublico_designMoveis());
            comando.setInt(27, proposta.getPublico_eletronica());
            comando.setInt(28, proposta.getPublico_transacoesImobiliarias());
            comando.setInt(29, proposta.getPublico_transporteFerroviario());
            comando.setInt(30, proposta.getPublico_sistemasInformacao());
            comando.setInt(31, proposta.getPublico_engMecatronica());
            comando.setInt(32, proposta.getPublico_engMetalurgica());
            comando.setInt(33, proposta.getPublico_fisica());
            comando.setInt(34, proposta.getSegunda());
            comando.setInt(35, proposta.getTerca());
            comando.setInt(36, proposta.getQuarta());
            comando.setInt(37, proposta.getQuinta());
            comando.setInt(38, proposta.getSexta());
            comando.setInt(39, proposta.getSabado());
            comando.setInt(40, proposta.getIdGerente());
            comando.setInt(41, proposta.getIdLocal());
            comando.setInt(42, proposta.getIdEvento());
            comando.setString(43, proposta.getDataInicio());
            comando.setString(44, proposta.getDataFim());
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

        public static void alterar(Proposta proposta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update proposta set proponente =?, emailProponente=?, tipoAtividade=?, tituloAtividade=?, "
                    + "finalidadeAtividade=?, cargaHoraria=?, vagasAtividade=?, nomeConvidado=?, emailConvidado=?, "
                    + "formacaoConvidado=?, origem=?, informacoesComplementares=?, diaria=?, estado=?, publico_alvo=?,"
                    + " publico_todos=?, publico_informatica=?, publico_edificacoes=?, "
                    + "publico_eletromecanica=?, publico_eletrotecnica=?, publico_mecanica=?, publico_metalurgia=?, "
                    + "publico_eventos=?, publico_secretariado=?, publico_designMoveis=?, publico_eletronica=?, "
                    + "publico_transacoesImobiliarias=?, publico_transporteFerroviario=?, publico_sistemasInformacao=?, "
                    + "publico_engMecatronica=?, publico_engMetalurgica=?, publico_fisica=?, segunda=?, terca=?, quarta=?, "
                    + "quinta=?, sexta=?, sabado=?, gerente_codGerente=?, local_id=?, evento_id=?, dataInicio=?, dataFim=? "
                    + "where idProposta = ? ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, proposta.getProponente());
            comando.setString(2, proposta.getEmailProponente());
            comando.setString(3, proposta.getTipoAtividade());
            comando.setString(4, proposta.getTituloAtividade());
            comando.setString(5, proposta.getFinalidadeAtividade());
            comando.setString(6, proposta.getCargaHoraria());
            comando.setInt(7, proposta.getVagasAtividade());
            comando.setString(8, proposta.getNomeConvidado());
            comando.setString(9, proposta.getEmailConvidado());
            comando.setString(10, proposta.getFormacaoConvidado());
            comando.setString(11, proposta.getOrigem());
            comando.setString(12, proposta.getInformacoesComplementares());
            comando.setInt(13, proposta.getDiaria());
            comando.setString(14, proposta.getEstado());
            comando.setString(15, proposta.getPublico_alvo());
            comando.setInt(16, proposta.getPublico_todos());
            comando.setInt(17, proposta.getPublico_informatica());
            comando.setInt(18, proposta.getPublico_edificacoes());
            comando.setInt(19, proposta.getPublico_eletromecanica());
            comando.setInt(20, proposta.getPublico_eletrotecnica());
            comando.setInt(21, proposta.getPublico_mecanica());
            comando.setInt(22, proposta.getPublico_metalurgia());
            comando.setInt(23, proposta.getPublico_eventos());
            comando.setInt(24, proposta.getPublico_secretariado());
            comando.setInt(25, proposta.getPublico_designMoveis());
            comando.setInt(26, proposta.getPublico_eletronica());
            comando.setInt(27, proposta.getPublico_transacoesImobiliarias());
            comando.setInt(28, proposta.getPublico_transporteFerroviario());
            comando.setInt(29, proposta.getPublico_sistemasInformacao());
            comando.setInt(30, proposta.getPublico_engMecatronica());
            comando.setInt(31, proposta.getPublico_engMetalurgica());
            comando.setInt(32, proposta.getPublico_fisica());
            comando.setInt(33, proposta.getSegunda());
            comando.setInt(34, proposta.getTerca());
            comando.setInt(35, proposta.getQuarta());
            comando.setInt(36, proposta.getQuinta());
            comando.setInt(37, proposta.getSexta());
            comando.setInt(38, proposta.getSabado());
            comando.setInt(39, proposta.getIdGerente());
            comando.setInt(40, proposta.getIdLocal());
            comando.setInt(41, proposta.getIdEvento());
            comando.setString(42, proposta.getDataInicio());
            comando.setString(43, proposta.getDataFim());
            comando.setInt(44, proposta.getIdProposta());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }


        public static void excluir(Proposta proposta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "delete from proposta where idProposta = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposta.getIdProposta());
        comando.execute();
        comando.close();
        conexao.close();
        }catch(SQLException e){
            throw e;
        }
    }
        
        
}
