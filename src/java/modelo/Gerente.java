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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Math
 */
@Entity
@Table(name = "gerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g")})
public class Gerente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codGerente")
    private Integer codGerente;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @Column(name = "senha")
    private String senha;

    public Gerente() {
    }

    public Gerente(Integer codGerente, String nome, String email, String dataNascimento, String senha) {
        this.codGerente = codGerente;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }
    
    public Gerente(Integer codGerente) {
        this.codGerente = codGerente;
    }

    public Gerente(Integer codGerente, String nome) {
        this.codGerente = codGerente;
        this.nome = nome;
    }

    public Integer getCodGerente() {
        return codGerente;
    }

    public void setCodGerente(Integer codGerente) {
        this.codGerente = codGerente;
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
        hash += (codGerente != null ? codGerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.codGerente == null && other.codGerente != null) || (this.codGerente != null && !this.codGerente.equals(other.codGerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gerente[ codGerente=" + codGerente + " ]";
    }
    
}
