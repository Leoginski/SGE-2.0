/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.NoticiaDAO;
import java.util.List;

/**
 *
 * @author Math
 */
public class Noticia {
    private int idNoticia;
    private String data;
    private String descricao;

    public Noticia(int idNoticia, String data, String descricao) {
        this.idNoticia=idNoticia;
        this.data = data;
        this.descricao = descricao;
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

}
