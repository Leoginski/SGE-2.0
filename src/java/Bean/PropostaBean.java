/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.PropostaDAO;
import model.Proposta;

/**
 *
 * @author Aluno
 */
public class PropostaBean extends CrudBean<Proposta, PropostaDAO> {

    private PropostaDAO propostaDAO;

    @Override
    public PropostaDAO getDao() {
        if (propostaDAO == null) {
            propostaDAO = new PropostaDAO();
        }
        return propostaDAO;
    }

    @Override
    public Proposta criarNovaEntidade() {
        return new Proposta();
    }
}