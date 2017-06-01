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
@Table(name = "externo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Externo.findAll", query = "SELECT e FROM Externo e")})
public class Externo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idExterno")
    private Integer idExterno;
    @Column(name = "conhecimento")
    private String conhecimento;
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @Column(name = "senha")
    private String senha;


    public Externo() {
    }

    public Externo(Integer idExterno, String conhecimento, String nome, String email, String dataNascimento, String senha) {
        this.idExterno = idExterno;
        this.conhecimento = conhecimento;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }    
    
    public Externo(Integer idExterno) {
        this.idExterno = idExterno;
    }

    public Externo(Integer idExterno, String email) {
        this.idExterno = idExterno;
        this.email = email;
    }

    public Integer getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(Integer idExterno) {
        this.idExterno = idExterno;
    }

    public String getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(String conhecimento) {
        this.conhecimento = conhecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExterno != null ? idExterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Externo)) {
            return false;
        }
        Externo other = (Externo) object;
        if ((this.idExterno == null && other.idExterno != null) || (this.idExterno != null && !this.idExterno.equals(other.idExterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Externo[ idExterno=" + idExterno + " ]";
    }
    
}
