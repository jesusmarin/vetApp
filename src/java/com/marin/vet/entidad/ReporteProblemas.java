/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "reporteproblemas")
@NamedQueries({
    @NamedQuery(name = "ReporteProblemas.findAll", query = "SELECT r FROM ReporteProblemas r")})
public class ReporteProblemas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReporteProblemas")
    private Integer idReporteProblemas;
    @Lob
    @Size(max = 65535)
    @Column(name = "problema")
    private String problema;
    @Lob
    @Size(max = 65535)
    @Column(name = "planDiagnostico")
    private String planDiagnostico;
    @Lob
    @Size(max = 65535)
    @Column(name = "resultado")
    private String resultado;
    @JoinColumn(name = "idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(fetch = FetchType.LAZY)
    private HistoriaClinica idHistoriaClinica;

    public ReporteProblemas() {
    }

    public ReporteProblemas(Integer idReporteProblemas) {
        this.idReporteProblemas = idReporteProblemas;
    }

    public Integer getIdReporteProblemas() {
        return idReporteProblemas;
    }

    public void setIdReporteProblemas(Integer idReporteProblemas) {
        this.idReporteProblemas = idReporteProblemas;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getPlanDiagnostico() {
        return planDiagnostico;
    }

    public void setPlanDiagnostico(String planDiagnostico) {
        this.planDiagnostico = planDiagnostico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public HistoriaClinica getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(HistoriaClinica idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteProblemas != null ? idReporteProblemas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteProblemas)) {
            return false;
        }
        ReporteProblemas other = (ReporteProblemas) object;
        if ((this.idReporteProblemas == null && other.idReporteProblemas != null) || (this.idReporteProblemas != null && !this.idReporteProblemas.equals(other.idReporteProblemas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.ReporteProblemas[ idReporteProblemas=" + idReporteProblemas + " ]";
    }
    
}
