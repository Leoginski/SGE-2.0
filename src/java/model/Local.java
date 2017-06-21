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
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findByIdLocal", query = "SELECT l FROM Local l WHERE l.idLocal = :idLocal"),
    @NamedQuery(name = "Local.findByDescricao", query = "SELECT l FROM Local l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "Local.findByCapacidade", query = "SELECT l FROM Local l WHERE l.capacidade = :capacidade")})
public class Local implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localId")
    private Collection<Proposta> propostaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLocal")
    private Integer idLocal;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "capacidade")
    private Integer capacidade;

    public Local() {
    }

    public Local(Integer idLocal, String descricao, Integer capacidade) {
        this.idLocal = idLocal;
        this.descricao = descricao;
        this.capacidade = capacidade;
    }

    
    
    public Local(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocal != null ? idLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Local[ idLocal=" + idLocal + " ]";
    }

    @XmlTransient
    public Collection<Proposta> getPropostaCollection() {
        return propostaCollection;
    }

    public void setPropostaCollection(Collection<Proposta> propostaCollection) {
        this.propostaCollection = propostaCollection;
    }
    
}
