/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.AdministradorDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Administrador extends Usuario {

    private int codAdministrador;

    public Administrador(int codAdministrador, String nome, String dataNascimento, String email, String senha) {
        super(nome, email, senha, dataNascimento);
        this.codAdministrador = codAdministrador;
    }

    public int getCodAdministrador() {
        return codAdministrador;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public static List<Administrador> obterAdministradores() throws ClassNotFoundException{
        return AdministradorDAO.obterAdministradores();
    }
    public static Administrador obterAdministrador(int codAdministrador) throws ClassNotFoundException{
        return AdministradorDAO.obterAdministrador(codAdministrador);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        AdministradorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AdministradorDAO.alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        AdministradorDAO.excluir(this);
    }
    
}
