/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.GerenteDAO;
import model.Gerente;

/**
 *
 * @author Aluno
 */
public class GerenteBean extends CrudBean<Gerente, GerenteDAO> {

    private GerenteDAO gerenteDAO;

    @Override
    public GerenteDAO getDao() {
        if (gerenteDAO == null) {
            gerenteDAO = new GerenteDAO();
        }
        return gerenteDAO;
    }

    @Override
    public Gerente criarNovaEntidade() {
        return new Gerente();
    }
}
