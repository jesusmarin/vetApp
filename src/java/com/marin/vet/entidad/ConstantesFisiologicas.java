/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author JesusMarin
 */
@Entity
@Table(name = "constantesfisiologicas")
@NamedQueries({
    @NamedQuery(name = "ConstantesFisiologicas.findAll", query = "SELECT c FROM ConstantesFisiologicas c")})
public class ConstantesFisiologicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConstantesFisiologicas")
    private Integer idConstantesFisiologicas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "temperatura")
    private Double temperatura;
    @Column(name = "turgenciaPiel")
    private Integer turgenciaPiel;
    @Size(max = 45)
    @Column(name = "pulso")
    private String pulso;
    @Size(max = 45)
    @Column(name = "frecuenciaCardicaco")
    private String frecuenciaCardicaco;
    @Size(max = 45)
    @Column(name = "frecuenciaRes")
    private String frecuenciaRes;
    @Size(max = 45)
    @Column(name = "TLLC")
    private String tllc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<Mucosa> mucosaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<SistemaCardioVascular> sistemaCardioVascularList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<MusculoEsqueletico> musculoEsqueleticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<PielAnexos> pielAnexosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<NodulosLinfaticos> nodulosLinfaticosList;
    @OneToMany(mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<Actitud> actitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<Ojos> ojosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<Hidratacion> hidratacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<Locomocion> locomocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<SistemaNervioso> sistemaNerviosoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<Oidos> oidosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<SistemaDigestivo> sistemaDigestivoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<SistemaGenitoUrinario> sistemaGenitoUrinarioList;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cita idCita;
    @OneToMany(mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<CondicionCorporal> condicionCorporalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConstantesFisiologicas", fetch = FetchType.LAZY)
    private List<SistemaRespiratorio> sistemaRespiratorioList;

    public ConstantesFisiologicas() {
    }

    public ConstantesFisiologicas(Integer idConstantesFisiologicas) {
        this.idConstantesFisiologicas = idConstantesFisiologicas;
    }

    public Integer getIdConstantesFisiologicas() {
        return idConstantesFisiologicas;
    }

    public void setIdConstantesFisiologicas(Integer idConstantesFisiologicas) {
        this.idConstantesFisiologicas = idConstantesFisiologicas;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getTurgenciaPiel() {
        return turgenciaPiel;
    }

    public void setTurgenciaPiel(Integer turgenciaPiel) {
        this.turgenciaPiel = turgenciaPiel;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getFrecuenciaCardicaco() {
        return frecuenciaCardicaco;
    }

    public void setFrecuenciaCardicaco(String frecuenciaCardicaco) {
        this.frecuenciaCardicaco = frecuenciaCardicaco;
    }

    public String getFrecuenciaRes() {
        return frecuenciaRes;
    }

    public void setFrecuenciaRes(String frecuenciaRes) {
        this.frecuenciaRes = frecuenciaRes;
    }

    public String getTllc() {
        return tllc;
    }

    public void setTllc(String tllc) {
        this.tllc = tllc;
    }

    public List<Mucosa> getMucosaList() {
        return mucosaList;
    }

    public void setMucosaList(List<Mucosa> mucosaList) {
        this.mucosaList = mucosaList;
    }

    public List<SistemaCardioVascular> getSistemaCardioVascularList() {
        return sistemaCardioVascularList;
    }

    public void setSistemaCardioVascularList(List<SistemaCardioVascular> sistemaCardioVascularList) {
        this.sistemaCardioVascularList = sistemaCardioVascularList;
    }

    public List<MusculoEsqueletico> getMusculoEsqueleticoList() {
        return musculoEsqueleticoList;
    }

    public void setMusculoEsqueleticoList(List<MusculoEsqueletico> musculoEsqueleticoList) {
        this.musculoEsqueleticoList = musculoEsqueleticoList;
    }

    public List<PielAnexos> getPielAnexosList() {
        return pielAnexosList;
    }

    public void setPielAnexosList(List<PielAnexos> pielAnexosList) {
        this.pielAnexosList = pielAnexosList;
    }

    public List<NodulosLinfaticos> getNodulosLinfaticosList() {
        return nodulosLinfaticosList;
    }

    public void setNodulosLinfaticosList(List<NodulosLinfaticos> nodulosLinfaticosList) {
        this.nodulosLinfaticosList = nodulosLinfaticosList;
    }

    public List<Actitud> getActitudList() {
        return actitudList;
    }

    public void setActitudList(List<Actitud> actitudList) {
        this.actitudList = actitudList;
    }

    public List<Ojos> getOjosList() {
        return ojosList;
    }

    public void setOjosList(List<Ojos> ojosList) {
        this.ojosList = ojosList;
    }

    public List<Hidratacion> getHidratacionList() {
        return hidratacionList;
    }

    public void setHidratacionList(List<Hidratacion> hidratacionList) {
        this.hidratacionList = hidratacionList;
    }

    public List<Locomocion> getLocomocionList() {
        return locomocionList;
    }

    public void setLocomocionList(List<Locomocion> locomocionList) {
        this.locomocionList = locomocionList;
    }

    public List<SistemaNervioso> getSistemaNerviosoList() {
        return sistemaNerviosoList;
    }

    public void setSistemaNerviosoList(List<SistemaNervioso> sistemaNerviosoList) {
        this.sistemaNerviosoList = sistemaNerviosoList;
    }

    public List<Oidos> getOidosList() {
        return oidosList;
    }

    public void setOidosList(List<Oidos> oidosList) {
        this.oidosList = oidosList;
    }

    public List<SistemaDigestivo> getSistemaDigestivoList() {
        return sistemaDigestivoList;
    }

    public void setSistemaDigestivoList(List<SistemaDigestivo> sistemaDigestivoList) {
        this.sistemaDigestivoList = sistemaDigestivoList;
    }

    public List<SistemaGenitoUrinario> getSistemaGenitoUrinarioList() {
        return sistemaGenitoUrinarioList;
    }

    public void setSistemaGenitoUrinarioList(List<SistemaGenitoUrinario> sistemaGenitoUrinarioList) {
        this.sistemaGenitoUrinarioList = sistemaGenitoUrinarioList;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public List<CondicionCorporal> getCondicionCorporalList() {
        return condicionCorporalList;
    }

    public void setCondicionCorporalList(List<CondicionCorporal> condicionCorporalList) {
        this.condicionCorporalList = condicionCorporalList;
    }

    public List<SistemaRespiratorio> getSistemaRespiratorioList() {
        return sistemaRespiratorioList;
    }

    public void setSistemaRespiratorioList(List<SistemaRespiratorio> sistemaRespiratorioList) {
        this.sistemaRespiratorioList = sistemaRespiratorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConstantesFisiologicas != null ? idConstantesFisiologicas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstantesFisiologicas)) {
            return false;
        }
        ConstantesFisiologicas other = (ConstantesFisiologicas) object;
        if ((this.idConstantesFisiologicas == null && other.idConstantesFisiologicas != null) || (this.idConstantesFisiologicas != null && !this.idConstantesFisiologicas.equals(other.idConstantesFisiologicas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.ConstantesFisiologicas[ idConstantesFisiologicas=" + idConstantesFisiologicas + " ]";
    }
    
}
