/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import exception.ErroSistema;

/**
 *
 * @author Aluno
 */
public interface CrudDAO<E> {

    /**
     *
     * @param entidade
     * @throws ErroSistema
     */
    public void salvar(E entidade) throws ErroSistema;

    /**
     *
     * @param entidade
     * @throws ErroSistema
     */
    public void excluir(E entidade) throws ErroSistema;

    /**
     *
     * @return @throws ErroSistema
     */
    public List<E> buscar() throws ErroSistema;
}
