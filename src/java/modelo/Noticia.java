/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.NoticiaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Math
 */
public class Noticia {
    private int idNoticia;
    private String data;
    private String descricao;
    private int idEvento;
    private Evento evento;

    public Noticia(int idNoticia, String data, String descricao, int idEvento) {
        this.idNoticia=idNoticia;
        this.data = data;
        this.descricao = descricao;
        this.idEvento = idEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Evento getEvento() throws ClassNotFoundException {
        if ((evento == null) && (idEvento != 0)) {
            evento = Evento.obterEvento(idEvento);
        }
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public static List<Noticia> obterNoticias() throws ClassNotFoundException{
        return NoticiaDAO.obterNoticias();
    }

    public static Noticia obterNoticia(int idNoticia) throws ClassNotFoundException{
        return NoticiaDAO.obterNoticia(idNoticia);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        NoticiaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        NoticiaDAO.alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        NoticiaDAO.excluir(this);
    }
    
}
