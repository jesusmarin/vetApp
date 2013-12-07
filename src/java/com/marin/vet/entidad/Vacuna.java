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
@Table(name = "vacuna")
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v")})
public class Vacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacuna")
    private Integer idVacuna;
    @Size(max = 255)
    @Column(name = "vacunaUtilizada")
    private String vacunaUtilizada;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mascota idMascota;
    @JoinColumn(name = "idTipoVacuna", referencedColumnName = "idTipoVacuna")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoVacuna idTipoVacuna;

    public Vacuna() {
    }

    public Vacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getVacunaUtilizada() {
        return vacunaUtilizada;
    }

    public void setVacunaUtilizada(String vacunaUtilizada) {
        this.vacunaUtilizada = vacunaUtilizada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public TipoVacuna getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public void setIdTipoVacuna(TipoVacuna idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.Vacuna[ idVacuna=" + idVacuna + " ]";
    }
    
}
