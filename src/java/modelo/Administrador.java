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
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codAdministrador")
    private Integer codAdministrador;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
   

    public Administrador() {
    }

    public Administrador(Integer codAdministrador) {
        this.codAdministrador = codAdministrador;
    }

    public Administrador(Integer codAdministrador, String nome) {
        this.codAdministrador = codAdministrador;
        this.nome = nome;
    }

    public Integer getCodAdministrador() {
        return codAdministrador;
    }

    public void setCodAdministrador(Integer codAdministrador) {
        this.codAdministrador = codAdministrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (codAdministrador != null ? codAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.codAdministrador == null && other.codAdministrador != null) || (this.codAdministrador != null && !this.codAdministrador.equals(other.codAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Administrador[ codAdministrador=" + codAdministrador + " ]";
    }
    
}
