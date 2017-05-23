/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Math
 */
@Entity
@Table(name = "certificado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificado.findAll", query = "SELECT c FROM Certificado c")})
public class Certificado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codAutencidade")
    private String codAutencidade;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "Inscricao_codInscricao", referencedColumnName = "codInscricao")
    @ManyToOne(optional = false)
    private Inscricao inscricaocodInscricao;

    public Certificado() {
    }

    public Certificado(String codAutencidade) {
        this.codAutencidade = codAutencidade;
    }

    public String getCodAutencidade() {
        return codAutencidade;
    }

    public void setCodAutencidade(String codAutencidade) {
        this.codAutencidade = codAutencidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Inscricao getInscricaocodInscricao() {
        return inscricaocodInscricao;
    }

    public void setInscricaocodInscricao(Inscricao inscricaocodInscricao) {
        this.inscricaocodInscricao = inscricaocodInscricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAutencidade != null ? codAutencidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificado)) {
            return false;
        }
        Certificado other = (Certificado) object;
        if ((this.codAutencidade == null && other.codAutencidade != null) || (this.codAutencidade != null && !this.codAutencidade.equals(other.codAutencidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Certificado[ codAutencidade=" + codAutencidade + " ]";
    }
    
}
