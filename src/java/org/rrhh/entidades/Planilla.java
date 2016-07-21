/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rrhh.entidades;

import java.io.Serializable;
import java.util.List;
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
 * @author admin
 */
// coment

@Entity
@Table(name = "planilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p"),
    @NamedQuery(name = "Planilla.findByIdplanilla", query = "SELECT p FROM Planilla p WHERE p.idplanilla = :idplanilla"),
    @NamedQuery(name = "Planilla.findByAfp", query = "SELECT p FROM Planilla p WHERE p.afp = :afp"),
    @NamedQuery(name = "Planilla.findByIsss", query = "SELECT p FROM Planilla p WHERE p.isss = :isss"),
    @NamedQuery(name = "Planilla.findBySueldo", query = "SELECT p FROM Planilla p WHERE p.sueldo = :sueldo"),
    @NamedQuery(name = "Planilla.findByRenta", query = "SELECT p FROM Planilla p WHERE p.renta = :renta"),
    @NamedQuery(name = "Planilla.findByVacacion", query = "SELECT p FROM Planilla p WHERE p.vacacion = :vacacion"),
    @NamedQuery(name = "Planilla.findByDescuentos", query = "SELECT p FROM Planilla p WHERE p.descuentos = :descuentos"),
    @NamedQuery(name = "Planilla.findByHorasextra", query = "SELECT p FROM Planilla p WHERE p.horasextra = :horasextra")})
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idplanilla")
    private Integer idplanilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "afp")
    private double afp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "isss")
    private double isss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sueldo")
    private double sueldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "renta")
    private double renta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vacacion")
    private double vacacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descuentos")
    private double descuentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "horasextra")
    private double horasextra;
    @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdempleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planillaIdplanilla")
    private List<Descuentosley> descuentosleyList;

    public Planilla() {
    }

    public Planilla(Integer idplanilla) {
        this.idplanilla = idplanilla;
    }

    public Planilla(Integer idplanilla, double afp, double isss, double sueldo, double renta, double vacacion, double descuentos, double horasextra, Empleado empleadoIdempleado, List<Descuentosley> descuentosleyList) {
        this.idplanilla = idplanilla;
        this.afp = afp;
        this.isss = isss;
        this.sueldo = sueldo;
        this.renta = renta;
        this.vacacion = vacacion;
        this.descuentos = descuentos;
        this.horasextra = horasextra;
        this.empleadoIdempleado = empleadoIdempleado;
        this.descuentosleyList = descuentosleyList;
    }

    

    public Integer getIdplanilla() {
        return idplanilla;
    }

    public void setIdplanilla(Integer idplanilla) {
        this.idplanilla = idplanilla;
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getIsss() {
        return isss;
    }

    public void setIsss(double isss) {
        this.isss = isss;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

    public double getVacacion() {
        return vacacion;
    }

    public void setVacacion(double vacacion) {
        this.vacacion = vacacion;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getHorasextra() {
        return horasextra;
    }

    public void setHorasextra(double horasextra) {
        this.horasextra = horasextra;
    }

    public Empleado getEmpleadoIdempleado() {
        return empleadoIdempleado;
    }

    public void setEmpleadoIdempleado(Empleado empleadoIdempleado) {
        this.empleadoIdempleado = empleadoIdempleado;
    }

    @XmlTransient
    public List<Descuentosley> getDescuentosleyList() {
        return descuentosleyList;
    }

    public void setDescuentosleyList(List<Descuentosley> descuentosleyList) {
        this.descuentosleyList = descuentosleyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanilla != null ? idplanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.idplanilla == null && other.idplanilla != null) || (this.idplanilla != null && !this.idplanilla.equals(other.idplanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rrhh.entidades.Planilla[ idplanilla=" + idplanilla + " ]";
    }
    
}
