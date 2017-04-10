/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.LocalDAO;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Local {

    private int idLocal;
    private String descricao;
    private int capacidade;

    public Local(int idLocal, String descricao, int capacidade) {
        this.idLocal = idLocal;
        this.descricao = descricao;
        this.capacidade = capacidade;
    }
    
    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getId() {
        return idLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setId(int id) {
        this.idLocal = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
        public static List<Local> obterLocais() throws ClassNotFoundException{
        return LocalDAO.obterLocais();
    }

}
