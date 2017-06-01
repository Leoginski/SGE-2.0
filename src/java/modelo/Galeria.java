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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "galeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galeria.findAll", query = "SELECT g FROM Galeria g")})
public class Galeria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idGaleria")
    private Integer idGaleria;
    @Column(name = "data")
    private String data;

    @JoinColumn(name = "Evento_id", referencedColumnName = "idEvento")
    @ManyToOne(optional = false)
    private Evento eventoid;

    public Galeria() {
    }

    public Galeria(Integer idGaleria, String data, Evento eventoid) {
        this.idGaleria = idGaleria;
        this.data = data;
        this.eventoid = eventoid;
    }
    
    public Galeria(Integer idGaleria) {
        this.idGaleria = idGaleria;
    }

    public Integer getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(Integer idGaleria) {
        this.idGaleria = idGaleria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

  

    public Evento getEventoid() {
        return eventoid;
    }

    public void setEventoid(Evento eventoid) {
        this.eventoid = eventoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGaleria != null ? idGaleria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galeria)) {
            return false;
        }
        Galeria other = (Galeria) object;
        if ((this.idGaleria == null && other.idGaleria != null) || (this.idGaleria != null && !this.idGaleria.equals(other.idGaleria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Galeria[ idGaleria=" + idGaleria + " ]";
    }
    
}
