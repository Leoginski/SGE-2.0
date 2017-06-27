/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import DAO.EventoDAO;
import model.Evento;

/**
 *
 * @author Aluno
 */
public class EventoBean extends CrudBean<Evento, EventoDAO> {

    private EventoDAO eventoDAO;

    @Override
    public EventoDAO getDao() {
        if (eventoDAO == null) {
            eventoDAO = new EventoDAO();
        }
        return eventoDAO;
    }

    @Override
    public Evento criarNovaEntidade() {
        return new Evento();
    }
}
