/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.NoticiaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Noticia;

/**
 *
 * @author Aluno
 */
@ManagedBean
@RequestScoped
public class NoticiaBean extends CrudBean<Noticia, NoticiaDAO> {

    private NoticiaDAO noticiaDAO;

    @Override
    public NoticiaDAO getDao() {
        if (noticiaDAO == null) {
            noticiaDAO = new NoticiaDAO();
        }
        return noticiaDAO;
    }

    @Override
    public Noticia criarNovaEntidade() {
        return new Noticia();
    }
}
