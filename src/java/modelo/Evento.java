/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Math
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEvento")
    private Integer idEvento;
    @Column(name = "nomeEvento")
    private String nomeEvento;
    @Column(name = "duracao")
    private String duracao;
    @Column(name = "tema")
    private String tema;
    @Column(name = "dataInicioEvento")
    private String dataInicioEvento;
    @Column(name = "dataFimEvento")
    private String dataFimEvento;
    @Column(name = "dataInicioInscricao")
    private String dataInicioInscricao;
    @Column(name = "dataFimInscricao")
    private String dataFimInscricao;
  
    @JoinColumn(name = "Administrador_codAdministrador", referencedColumnName = "codAdministrador")
    @ManyToOne(optional = false)
    private Administrador administradorcodAdministrador;
    

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDataInicioEvento() {
        return dataInicioEvento;
    }

    public void setDataInicioEvento(String dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    public String getDataFimEvento() {
        return dataFimEvento;
    }

    public void setDataFimEvento(String dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    public String getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public void setDataInicioInscricao(String dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }

    public String getDataFimInscricao() {
        return dataFimInscricao;
    }

    public void setDataFimInscricao(String dataFimInscricao) {
        this.dataFimInscricao = dataFimInscricao;
    }


    public Administrador getAdministradorcodAdministrador() {
        return administradorcodAdministrador;
    }

    public void setAdministradorcodAdministrador(Administrador administradorcodAdministrador) {
        this.administradorcodAdministrador = administradorcodAdministrador;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
