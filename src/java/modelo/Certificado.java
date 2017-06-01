package modelo;

import DAO.CertificadoDAO;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardo
 */
public class Certificado {

    private int codCertificado;
    private String descricao;
    private int codProposta;

    public Certificado(int codCertificado, String descricao, int codProposta) {
        this.codProposta = codProposta;
        this.codCertificado = codCertificado;
        this.descricao = descricao;
    }

    public int getCodCertificado() {
        return codCertificado;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodProposta() {
        return codProposta;
    }

    public void setCodCertificado(int codCertificado) {
        this.codCertificado = codCertificado;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodProposta(int codProposta) {
        this.codProposta = codProposta;
    }
    public static List<Certificado> obterCertificados() throws ClassNotFoundException{
        return CertificadoDAO.obterCertificados();
    }

//    public static Certificado obterCertificado() throws ClassNotFoundException{
//        return CertificadoDAO.obterCertificado();
//    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CertificadoDAO.gravar(this);
    }
    public void alterar() throws SQLException, ClassNotFoundException {
        CertificadoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CertificadoDAO.alterar(this);
    }

    
}
