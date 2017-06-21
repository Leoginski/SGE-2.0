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
@Table(name = "gerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findByCodGerente", query = "SELECT g FROM Gerente g WHERE g.codGerente = :codGerente"),
    @NamedQuery(name = "Gerente.findByNome", query = "SELECT g FROM Gerente g WHERE g.nome = :nome"),
    @NamedQuery(name = "Gerente.findByEmail", query = "SELECT g FROM Gerente g WHERE g.email = :email"),
    @NamedQuery(name = "Gerente.findByDataNascimento", query = "SELECT g FROM Gerente g WHERE g.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Gerente.findBySenha", query = "SELECT g FROM Gerente g WHERE g.senha = :senha")})
public class Gerente implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gerentecodGerente")
    private Collection<Proposta> propostaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codGerente")
    private Integer codGerente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @Size(max = 8)
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

    @XmlTransient
    public Collection<Proposta> getPropostaCollection() {
        return propostaCollection;
    }

    public void setPropostaCollection(Collection<Proposta> propostaCollection) {
        this.propostaCollection = propostaCollection;
    }
    
}
