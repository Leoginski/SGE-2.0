/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.AlunoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Aluno;

/**
 *
 * @author Aluno
 */
@ManagedBean
@RequestScoped
public class AlunoBean extends CrudBean<Aluno, AlunoDAO> {

    private AlunoDAO alunoDAO;

    @Override
    public AlunoDAO getDao() {
        if (alunoDAO == null) {
            alunoDAO = new AlunoDAO();
        }
        return alunoDAO;
    }

    @Override
    public Aluno criarNovaEntidade() {
        return new Aluno();
    }
}
