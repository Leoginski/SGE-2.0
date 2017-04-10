package modelo;

import DAO.GerenteDAO;
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
public class Gerente extends Usuario {

    private int codGerente;

    public Gerente(String nome, String email, String senha, String dataNascimento, int codGerente) {
        super(nome, email, senha, dataNascimento);
        this.codGerente = codGerente;
    }

    //Novos Metodos
    public int getcodGerente() {
        return this.codGerente;
    }

    public int getCodGerente() {
        return codGerente;
    }

    public void setCodGerente(int codGerente) {
        this.codGerente = codGerente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public static List<Gerente> obterGerentes() throws ClassNotFoundException{
        return GerenteDAO.obterGerentes();
    }
    
    public void setcodDocente(int codDocente) {
        this.codGerente = codGerente;
    }
    
}
