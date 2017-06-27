/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.AdministradorDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Administrador;

/**
 *
 * @author Math
 */
@ManagedBean
@RequestScoped
public class AdministradorBean extends CrudBean<Administrador, AdministradorDAO> {

    private AdministradorDAO administradorDAO;

    @Override
    public AdministradorDAO getDao() {
        if (administradorDAO == null) {
            administradorDAO = new AdministradorDAO();
        }
        return administradorDAO;
    }

    @Override
    public Administrador criarNovaEntidade() {
        return new Administrador();
    }
}
