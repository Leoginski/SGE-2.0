package modelo;

import DAO.EventoDAO;
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
public class Evento {

    private int idEvento;
    private String nomeEvento;
    private String duracao;
    private String tema;
    private String dataInicioEvento;
    private String dataFimEvento;
    private String dataInicioInscricao;
    private String dataFimInscricao;
    private int codAdministrador;
    private Administrador administrador;

    public Evento(int idEvento, String nomeEvento, String duracao, String tema, String dataInicioEvento, String dataFimEvento, String dataInicioInscricao, String dataFimInscricao, int codAdministrador) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.duracao = duracao;
        this.tema = tema;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.dataInicioInscricao = dataInicioInscricao;
        this.dataFimInscricao = dataFimInscricao;
        this.codAdministrador = codAdministrador;
    }

    public Administrador getAdministrador() throws ClassNotFoundException {
        if ((administrador == null) && (codAdministrador != 0)) {
            administrador = Administrador.obterAdministrador(codAdministrador);
        }
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public int getIdEvento() {
        return idEvento;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getTema() {
        return tema;
    }

    public String getDataInicioEvento() {
        return dataInicioEvento;
    }

    public String getDataFimEvento() {
        return dataFimEvento;
    }

    public String getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public String getDataFimInscricao() {
        return dataFimInscricao;
    }

    public int getCodAdministrador() {
        return codAdministrador;
    }

    //gets e sets
    public String getNomeEvento() {
        return this.nomeEvento;
    }
    public static List<Evento> obterEventos() throws ClassNotFoundException{
        return EventoDAO.obterEventos();
    }

    public static Evento obterEvento(int idEvento) throws ClassNotFoundException{
        return EventoDAO.obterEvento(idEvento);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        EventoDAO.gravar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException {
        EventoDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
        EventoDAO.excluir(this);
    }


}
