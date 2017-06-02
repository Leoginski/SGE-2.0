/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "inscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i"),
    @NamedQuery(name = "Inscricao.findByCodInscricao", query = "SELECT i FROM Inscricao i WHERE i.codInscricao = :codInscricao"),
    @NamedQuery(name = "Inscricao.findByTipo", query = "SELECT i FROM Inscricao i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "Inscricao.findByFrequencia", query = "SELECT i FROM Inscricao i WHERE i.frequencia = :frequencia")})
public class Inscricao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codInscricao")
    private Integer codInscricao;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "frequencia")
    private Boolean frequencia;
    @JoinColumn(name = "Aluno_matricula", referencedColumnName = "idAluno")
    @ManyToOne(optional = false)
    private Aluno alunomatricula;
    @JoinColumn(name = "Externo_id", referencedColumnName = "idExterno")
    @ManyToOne(optional = false)
    private Externo externoid;
    @JoinColumn(name = "Proposta_id", referencedColumnName = "idProposta")
    @ManyToOne(optional = false)
    private Proposta propostaid;
    

    public Inscricao() {
    }

    public Inscricao(Integer codInscricao, String tipo, Boolean frequencia, Aluno alunomatricula, Externo externoid, Proposta propostaid) {
        this.codInscricao = codInscricao;
        this.tipo = tipo;
        this.frequencia = frequencia;
        this.alunomatricula = alunomatricula;
        this.externoid = externoid;
        this.propostaid = propostaid;
    }
    
    public Inscricao(Integer codInscricao) {
        this.codInscricao = codInscricao;
    }

    public Integer getCodInscricao() {
        return codInscricao;
    }

    public void setCodInscricao(Integer codInscricao) {
        this.codInscricao = codInscricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Boolean frequencia) {
        this.frequencia = frequencia;
    }

    public Aluno getAlunomatricula() {
        return alunomatricula;
    }

    public void setAlunomatricula(Aluno alunomatricula) {
        this.alunomatricula = alunomatricula;
    }

    public Externo getExternoid() {
        return externoid;
    }

    public void setExternoid(Externo externoid) {
        this.externoid = externoid;
    }

    public Proposta getPropostaid() {
        return propostaid;
    }

    public void setPropostaid(Proposta propostaid) {
        this.propostaid = propostaid;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInscricao != null ? codInscricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.codInscricao == null && other.codInscricao != null) || (this.codInscricao != null && !this.codInscricao.equals(other.codInscricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Inscricao[ codInscricao=" + codInscricao + " ]";
    }
    
}
