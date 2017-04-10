package modelo;

import DAO.EventoDAO;
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

    private final int idEvento;
    private final String nomeEvento;
    private final String duracao;
    private final String tema;
    private final String dataInicioEvento;
    private final String dataFimEvento;
    private final String dataInicioInscricao;
    private final String dataFimInscricao;
    private final int codAdministrador;

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

}
