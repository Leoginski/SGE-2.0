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
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByIdAlbum", query = "SELECT a FROM Album a WHERE a.idAlbum = :idAlbum"),
    @NamedQuery(name = "Album.findByDesricao", query = "SELECT a FROM Album a WHERE a.desricao = :desricao"),
    @NamedQuery(name = "Album.findByTitulo", query = "SELECT a FROM Album a WHERE a.titulo = :titulo")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlbum")
    private Integer idAlbum;
    @Size(max = 45)
    @Column(name = "desricao")
    private String desricao;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "Galeria_id", referencedColumnName = "idGaleria")
    @ManyToOne(optional = false)
    private Galeria galeriaid;
    

    public Album() {
    }

    public Album(Integer idAlbum, String desricao, String titulo, Galeria galeriaid) {
        this.idAlbum = idAlbum;
        this.desricao = desricao;
        this.titulo = titulo;
        this.galeriaid = galeriaid;
    }
    
    

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getDesricao() {
        return desricao;
    }

    public void setDesricao(String desricao) {
        this.desricao = desricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Galeria getGaleriaid() {
        return galeriaid;
    }

    public void setGaleriaid(Galeria galeriaid) {
        this.galeriaid = galeriaid;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbum != null ? idAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idAlbum == null && other.idAlbum != null) || (this.idAlbum != null && !this.idAlbum.equals(other.idAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Album[ idAlbum=" + idAlbum + " ]";
    }
    
}
