/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
@Entity
@Table(name = "CONDUCTOR", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c"),
    @NamedQuery(name = "Conductor.findByIdConductor", query = "SELECT c FROM Conductor c WHERE c.idConductor = :idConductor"),
    @NamedQuery(name = "Conductor.findByNombre", query = "SELECT c FROM Conductor c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Conductor.findByRuc", query = "SELECT c FROM Conductor c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Conductor.findByNumeroLicenciaConducir", query = "SELECT c FROM Conductor c WHERE c.numeroLicenciaConducir = :numeroLicenciaConducir"),
    @NamedQuery(name = "Conductor.findByObservaciones", query = "SELECT c FROM Conductor c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "Conductor.findByFechaRegistro", query = "SELECT c FROM Conductor c WHERE c.fechaRegistro = :fechaRegistro")})
public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONDUCTOR", nullable = false)
    private Integer idConductor;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "RUC", nullable = false, length = 200)
    private String ruc;
    @Basic(optional = false)
    @Column(name = "NUMERO_LICENCIA_CONDUCIR", nullable = false, length = 200)
    private String numeroLicenciaConducir;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 200)
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<GuiaRemicion> guiaRemicionList;

    public Conductor() {
    }

    public Conductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Conductor(Integer idConductor, String nombre, String ruc, String numeroLicenciaConducir, String observaciones, Date fechaRegistro) {
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.ruc = ruc;
        this.numeroLicenciaConducir = numeroLicenciaConducir;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNumeroLicenciaConducir() {
        return numeroLicenciaConducir;
    }

    public void setNumeroLicenciaConducir(String numeroLicenciaConducir) {
        this.numeroLicenciaConducir = numeroLicenciaConducir;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<GuiaRemicion> getGuiaRemicionList() {
        return guiaRemicionList;
    }

    public void setGuiaRemicionList(List<GuiaRemicion> guiaRemicionList) {
        this.guiaRemicionList = guiaRemicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConductor != null ? idConductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.idConductor == null && other.idConductor != null) || (this.idConductor != null && !this.idConductor.equals(other.idConductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Conductor[idConductor=" + idConductor + "]";
    }

}
