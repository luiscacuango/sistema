/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "CLIENTE_POTENCIAL", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "ClientePotencial.findAll", query = "SELECT c FROM ClientePotencial c"),
    @NamedQuery(name = "ClientePotencial.findByIdClientePotencial", query = "SELECT c FROM ClientePotencial c WHERE c.idClientePotencial = :idClientePotencial"),
    @NamedQuery(name = "ClientePotencial.findByFechaRegistro", query = "SELECT c FROM ClientePotencial c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ClientePotencial.findByClienteRazonSocial", query = "SELECT c FROM ClientePotencial c WHERE c.clienteRazonSocial = :clienteRazonSocial"),
    @NamedQuery(name = "ClientePotencial.findByFechaCumpleanios", query = "SELECT c FROM ClientePotencial c WHERE c.fechaCumpleanios = :fechaCumpleanios"),
    @NamedQuery(name = "ClientePotencial.findByDireccion", query = "SELECT c FROM ClientePotencial c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "ClientePotencial.findByDni", query = "SELECT c FROM ClientePotencial c WHERE c.dni = :dni"),
    @NamedQuery(name = "ClientePotencial.findByEstado", query = "SELECT c FROM ClientePotencial c WHERE c.estado = :estado"),
    @NamedQuery(name = "ClientePotencial.findByTelefono", query = "SELECT c FROM ClientePotencial c WHERE c.telefono = :telefono")})
public class ClientePotencial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE_POTENCIAL", nullable = false)
    private Integer idClientePotencial;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "CLIENTE_RAZON_SOCIAL", nullable = false, length = 150)
    private String clienteRazonSocial;
    @Basic(optional = false)
    @Column(name = "FECHA_CUMPLEANIOS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCumpleanios;
    @Basic(optional = false)
    @Column(name = "DIRECCION", nullable = false, length = 350)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "DNI", nullable = false, length = 12)
    private String dni;
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false)
    private int estado;
    @Basic(optional = false)
    @Column(name = "TELEFONO", nullable = false, length = 50)
    private String telefono;

    public ClientePotencial() {
    }

    public ClientePotencial(Integer idClientePotencial) {
        this.idClientePotencial = idClientePotencial;
    }

    public ClientePotencial(Integer idClientePotencial, Date fechaRegistro, String clienteRazonSocial, Date fechaCumpleanios, String direccion, String dni, int estado, String telefono) {
        this.idClientePotencial = idClientePotencial;
        this.fechaRegistro = fechaRegistro;
        this.clienteRazonSocial = clienteRazonSocial;
        this.fechaCumpleanios = fechaCumpleanios;
        this.direccion = direccion;
        this.dni = dni;
        this.estado = estado;
        this.telefono = telefono;
    }

    public Integer getIdClientePotencial() {
        return idClientePotencial;
    }

    public void setIdClientePotencial(Integer idClientePotencial) {
        this.idClientePotencial = idClientePotencial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getClienteRazonSocial() {
        return clienteRazonSocial;
    }

    public void setClienteRazonSocial(String clienteRazonSocial) {
        this.clienteRazonSocial = clienteRazonSocial;
    }

    public Date getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public void setFechaCumpleanios(Date fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientePotencial != null ? idClientePotencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePotencial)) {
            return false;
        }
        ClientePotencial other = (ClientePotencial) object;
        if ((this.idClientePotencial == null && other.idClientePotencial != null) || (this.idClientePotencial != null && !this.idClientePotencial.equals(other.idClientePotencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ClientePotencial[idClientePotencial=" + idClientePotencial + "]";
    }

}
