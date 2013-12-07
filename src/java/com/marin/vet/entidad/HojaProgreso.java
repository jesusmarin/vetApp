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
import javax.persistence.Lob;
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
@Table(name = "hojaprogreso")
@NamedQueries({
    @NamedQuery(name = "HojaProgreso.findAll", query = "SELECT h FROM HojaProgreso h")})
public class HojaProgreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHojaProgreso")
    private Integer idHojaProgreso;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "informe")
    private String informe;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cita idCita;

    public HojaProgreso() {
    }

    public HojaProgreso(Integer idHojaProgreso) {
        this.idHojaProgreso = idHojaProgreso;
    }

    public Integer getIdHojaProgreso() {
        return idHojaProgreso;
    }

    public void setIdHojaProgreso(Integer idHojaProgreso) {
        this.idHojaProgreso = idHojaProgreso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHojaProgreso != null ? idHojaProgreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojaProgreso)) {
            return false;
        }
        HojaProgreso other = (HojaProgreso) object;
        if ((this.idHojaProgreso == null && other.idHojaProgreso != null) || (this.idHojaProgreso != null && !this.idHojaProgreso.equals(other.idHojaProgreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.HojaProgreso[ idHojaProgreso=" + idHojaProgreso + " ]";
    }
    
}
