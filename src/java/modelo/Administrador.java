/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.AdministradorDAO;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Administrador extends Usuario {

    private final int codAdministrador;

    public Administrador(int codAdministrador, String nome, String email, String senha, String dataNascimento) {
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

    public int getcodAdministrador() {
        return this.codAdministrador;
    }
    public static List<Administrador> obterAdministradores() throws ClassNotFoundException{
        return AdministradorDAO.obterAdministradores();
    }
}
