/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import DAO.GaleriaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Galeria {
    private int idGaleria;
    private String data;
    private int idEvento;
    private Evento evento;
    
     public Galeria(int idGaleria, String data, Evento evento) {
        this.idGaleria = idGaleria;
        this.data = data;
        this.evento = evento;
    }

    public String getData() {
        return data;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public static List<Galeria> obterGalerias() throws ClassNotFoundException{
        return GaleriaDAO.obterGalerias();
    }

    public static Galeria obterGaleria(int idGaleria) throws ClassNotFoundException{
        return GaleriaDAO.obterGaleria(idGaleria);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        GaleriaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        GaleriaDAO.alterar(this);
    }

//    public void excluir() throws SQLException, ClassNotFoundException {
//        GaleriaDAO.excluir(this);
//    }
    
}
