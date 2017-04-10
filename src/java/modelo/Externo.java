package modelo;

import DAO.ExternoDAO;
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
public class Externo extends Usuario {
    private int idExterno;
    private String conhecimento;

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public String getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(String conhecimento) {
        this.conhecimento = conhecimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Externo(String nome, String email, String senha, String dataNascimento, String conheceu, int idExterno) {
        super(nome, email, senha, dataNascimento);
        this.conhecimento = conhecimento;
        this.idExterno=idExterno;;
    }
    public static List<Externo> obterExternos() throws ClassNotFoundException{
        return ExternoDAO.obterExternos();
    }

}
