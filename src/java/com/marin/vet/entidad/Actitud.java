

package com.marin.vet.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author JesusMarin
 */
@Entity
@Table(name = "actitud")
@NamedQueries({
    @NamedQuery(name = "Actitud.findAll", query = "SELECT a FROM Actitud a")})
public class Actitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idActitud")
    private Integer idActitud;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public Actitud() {
    }

    public Actitud(Integer idActitud) {
        this.idActitud = idActitud;
    }

    public Integer getIdActitud() {
        return idActitud;
    }

    public void setIdActitud(Integer idActitud) {
        this.idActitud = idActitud;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ConstantesFisiologicas getIdConstantesFisiologicas() {
        return idConstantesFisiologicas;
    }

    public void setIdConstantesFisiologicas(ConstantesFisiologicas idConstantesFisiologicas) {
        this.idConstantesFisiologicas = idConstantesFisiologicas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActitud != null ? idActitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actitud)) {
            return false;
        }
        Actitud other = (Actitud) object;
        if ((this.idActitud == null && other.idActitud != null) || (this.idActitud != null && !this.idActitud.equals(other.idActitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idActitud + " ";
    }
    
}
