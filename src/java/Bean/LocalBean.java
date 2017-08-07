/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.LocalDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Local;

/**
 *
 * @author Aluno
 */
@ManagedBean
@RequestScoped
public class LocalBean extends CrudBean<Local, LocalDAO> {

    private LocalDAO localDAO;

    @Override
    public LocalDAO getDao() {
        if (localDAO == null) {
            localDAO = new LocalDAO();
        }
        return localDAO;
    }

    @Override
    public Local criarNovaEntidade() {
        return new Local();
    }
}
