package modelo;

import DAO.GerenteDAO;
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
public class Gerente extends Usuario {

    private int codGerente;

    public Gerente(int codGerente, String nome, String email, String senha, String dataNascimento ) {
        super(nome, email, senha, dataNascimento);
        this.codGerente = codGerente;
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

    public static Gerente obterGerente(int codGerente) throws ClassNotFoundException{
        return GerenteDAO.obterGerente(codGerente);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        GerenteDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        GerenteDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        GerenteDAO.excluir(this);
    }
    
    
}
