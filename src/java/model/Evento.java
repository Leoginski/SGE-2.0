/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByNomeEvento", query = "SELECT e FROM Evento e WHERE e.nomeEvento = :nomeEvento"),
    @NamedQuery(name = "Evento.findByDuracao", query = "SELECT e FROM Evento e WHERE e.duracao = :duracao"),
    @NamedQuery(name = "Evento.findByTema", query = "SELECT e FROM Evento e WHERE e.tema = :tema"),
    @NamedQuery(name = "Evento.findByDataInicioEvento", query = "SELECT e FROM Evento e WHERE e.dataInicioEvento = :dataInicioEvento"),
    @NamedQuery(name = "Evento.findByDataFimEvento", query = "SELECT e FROM Evento e WHERE e.dataFimEvento = :dataFimEvento"),
    @NamedQuery(name = "Evento.findByDataInicioInscricao", query = "SELECT e FROM Evento e WHERE e.dataInicioInscricao = :dataInicioInscricao"),
    @NamedQuery(name = "Evento.findByDataFimInscricao", query = "SELECT e FROM Evento e WHERE e.dataFimInscricao = :dataFimInscricao")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEvento")
    private Integer idEvento;
    @Size(max = 45)
    @Column(name = "nomeEvento")
    private String nomeEvento;
    @Size(max = 10)
    @Column(name = "duracao")
    private String duracao;
    @Size(max = 50)
    @Column(name = "tema")
    private String tema;
    @Size(max = 45)
    @Column(name = "dataInicioEvento")
    private String dataInicioEvento;
    @Size(max = 45)
    @Column(name = "dataFimEvento")
    private String dataFimEvento;
    @Size(max = 45)
    @Column(name = "dataInicioInscricao")
    private String dataInicioInscricao;
    @Size(max = 45)
    @Column(name = "dataFimInscricao")
    private String dataFimInscricao;
    @JoinColumn(name = "Administrador_codAdministrador", referencedColumnName = "codAdministrador")
    @ManyToOne(optional = false)
    private Administrador administradorcodAdministrador;
    

    public Evento() {
    }

    public Evento(Integer idEvento, String nomeEvento, String duracao, String tema, String dataInicioEvento, String dataFimEvento, String dataInicioInscricao, String dataFimInscricao, Administrador administradorcodAdministrador) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.duracao = duracao;
        this.tema = tema;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.dataInicioInscricao = dataInicioInscricao;
        this.dataFimInscricao = dataFimInscricao;
        this.administradorcodAdministrador = administradorcodAdministrador;
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
