/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author JesusMarin
 */
@Entity
@Table(name = "cita")
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Column(name = "fechaEntrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Size(max = 255)
    @Column(name = "anotacion")
    private String anotacion;
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Lob
    @Size(max = 65535)
    @Column(name = "diagnosticoPresuntivo")
    private String diagnosticoPresuntivo;
    @Lob
    @Size(max = 65535)
    @Column(name = "DiagnosticoDefinitivo")
    private String diagnosticoDefinitivo;
    @Lob
    @Size(max = 65535)
    @Column(name = "tratamiento")
    private String tratamiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "pronostico")
    private String pronostico;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.LAZY)
    private List<HojaProgreso> hojaProgresoList;
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mascota idMascota;
    @JoinColumn(name = "idTipoServicio", referencedColumnName = "idTipoServicio")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoServicio idTipoServicio;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.LAZY)
    private List<ConstantesFisiologicas> constantesFisiologicasList;

    public Cita() {
    }

    public Cita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDiagnosticoPresuntivo() {
        return diagnosticoPresuntivo;
    }

    public void setDiagnosticoPresuntivo(String diagnosticoPresuntivo) {
        this.diagnosticoPresuntivo = diagnosticoPresuntivo;
    }

    public String getDiagnosticoDefinitivo() {
        return diagnosticoDefinitivo;
    }

    public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getPronostico() {
        return pronostico;
    }

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    public List<HojaProgreso> getHojaProgresoList() {
        return hojaProgresoList;
    }

    public void setHojaProgresoList(List<HojaProgreso> hojaProgresoList) {
        this.hojaProgresoList = hojaProgresoList;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public TipoServicio getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(TipoServicio idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public List<ConstantesFisiologicas> getConstantesFisiologicasList() {
        return constantesFisiologicasList;
    }

    public void setConstantesFisiologicasList(List<ConstantesFisiologicas> constantesFisiologicasList) {
        this.constantesFisiologicasList = constantesFisiologicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.Cita[ idCita=" + idCita + " ]";
    }
    
}
