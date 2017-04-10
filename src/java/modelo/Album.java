/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.AlbumDAO;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Album {

    private final int idAlbum;
    private String descricao;
    private String titulo;
    private Galeria galeria;
    private int idGaleria;

    public Album(int idAlbum, String descricao, String titulo, Galeria galeria) {
        this.idAlbum = idAlbum;
        this.descricao = descricao;
        this.titulo = titulo;
        this.galeria = galeria;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }
    
    public static List<Album> obterAlbuns() throws ClassNotFoundException{
        return AlbumDAO.obterAlbuns();
    }
}
