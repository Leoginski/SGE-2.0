/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Math
 */
@ManagedBean
@RequestScoped
public abstract class CrudBean<E> {

    private String estadoTela = "buscar";
    
    private E entidade;
    private List<E> entidades;
    
    public void novo(){
        entidade = criarNovaEntidade();
    }
    
    public void salva(){
        try{
            getDao.salvar(entidade);
            entidade = criarNovaEntidade();
            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        }catch (ErroSistema ex){
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null,ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void edita(E entidade){
        this.entidade = entidade;
    }
    
    public void exclui(E entidade){
        try{
            getDao().excluir(entidade);
            entidades.remove(entidade);
            adcionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        }catch(ErroSistema ex){
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    private void adicionarMensagem(String salvo_com_sucesso, FacesMessage.Severity SEVERITY_INFO) {
        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
}
