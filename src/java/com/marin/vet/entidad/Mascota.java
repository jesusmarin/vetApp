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
@Table(name = "mascota")
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m")})
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMascota")
    private Integer idMascota;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Size(max = 145)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 145)
    @Column(name = "color")
    private String color;
    @Size(max = 255)
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @OneToMany(mappedBy = "idMascota", fetch = FetchType.LAZY)
    private List<HistoriaClinica> historiaClinicaList;
    @OneToMany(mappedBy = "idMascota", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @OneToMany(mappedBy = "idMascota", fetch = FetchType.LAZY)
    private List<Vacuna> vacunaList;
    @OneToMany(mappedBy = "idMascota", fetch = FetchType.LAZY)
    private List<Cita> citaList;
    @JoinColumn(name = "idTipoProcedencia", referencedColumnName = "idTipoProcedencia")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoProcedencia idTipoProcedencia;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "idRaza", referencedColumnName = "idRaza")
    @ManyToOne(fetch = FetchType.LAZY)
    private Raza idRaza;
    @OneToMany(mappedBy = "idMascota", fetch = FetchType.LAZY)
    private List<Desparasitaciones> desparasitacionesList;

    public Mascota() {
    }

    public Mascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<HistoriaClinica> getHistoriaClinicaList() {
        return historiaClinicaList;
    }

    public void setHistoriaClinicaList(List<HistoriaClinica> historiaClinicaList) {
        this.historiaClinicaList = historiaClinicaList;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public TipoProcedencia getIdTipoProcedencia() {
        return idTipoProcedencia;
    }

    public void setIdTipoProcedencia(TipoProcedencia idTipoProcedencia) {
        this.idTipoProcedencia = idTipoProcedencia;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Raza getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Raza idRaza) {
        this.idRaza = idRaza;
    }

    public List<Desparasitaciones> getDesparasitacionesList() {
        return desparasitacionesList;
    }

    public void setDesparasitacionesList(List<Desparasitaciones> desparasitacionesList) {
        this.desparasitacionesList = desparasitacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.Mascota[ idMascota=" + idMascota + " ]";
    }
    
}
