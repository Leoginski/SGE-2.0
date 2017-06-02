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
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByCodAdministrador", query = "SELECT a FROM Administrador a WHERE a.codAdministrador = :codAdministrador"),
    @NamedQuery(name = "Administrador.findByNome", query = "SELECT a FROM Administrador a WHERE a.nome = :nome"),
    @NamedQuery(name = "Administrador.findByDataNascimento", query = "SELECT a FROM Administrador a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Administrador.findByEmail", query = "SELECT a FROM Administrador a WHERE a.email = :email"),
    @NamedQuery(name = "Administrador.findBySenha", query = "SELECT a FROM Administrador a WHERE a.senha = :senha")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codAdministrador")
    private Integer codAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "dataNascimento")
    private String dataNascimento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 8)
    @Column(name = "senha")
    private String senha;

    public Administrador() {
    }

    public Administrador(Integer codAdministrador, String nome, String dataNascimento, String email, String senha) {
        this.codAdministrador = codAdministrador;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
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
