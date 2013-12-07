/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author JesusMarin
 */
@Entity
@Table(name = "desparasitaciones")
@NamedQueries({
    @NamedQuery(name = "Desparasitaciones.findAll", query = "SELECT d FROM Desparasitaciones d")})
public class Desparasitaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDesparasitaciones")
    private Integer idDesparasitaciones;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 245)
    @Column(name = "medicamento")
    private String medicamento;
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mascota idMascota;

    public Desparasitaciones() {
    }

    public Desparasitaciones(Integer idDesparasitaciones) {
        this.idDesparasitaciones = idDesparasitaciones;
    }

    public Integer getIdDesparasitaciones() {
        return idDesparasitaciones;
    }

    public void setIdDesparasitaciones(Integer idDesparasitaciones) {
        this.idDesparasitaciones = idDesparasitaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesparasitaciones != null ? idDesparasitaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desparasitaciones)) {
            return false;
        }
        Desparasitaciones other = (Desparasitaciones) object;
        if ((this.idDesparasitaciones == null && other.idDesparasitaciones != null) || (this.idDesparasitaciones != null && !this.idDesparasitaciones.equals(other.idDesparasitaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.Desparasitaciones[ idDesparasitaciones=" + idDesparasitaciones + " ]";
    }
    
}
