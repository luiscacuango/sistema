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
@Table(name = "PRESTAMO_PRODUCTO_TIENDA_USUARIO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findAll", query = "SELECT p FROM PrestamoProductoTiendaUsuario p"),
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findByIdPrestamoProductoTienda", query = "SELECT p FROM PrestamoProductoTiendaUsuario p WHERE p.idPrestamoProductoTienda = :idPrestamoProductoTienda"),
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findByCantidad", query = "SELECT p FROM PrestamoProductoTiendaUsuario p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findByFechaIngreso", query = "SELECT p FROM PrestamoProductoTiendaUsuario p WHERE p.fechaIngreso = :fechaIngreso")})
public class PrestamoProductoTiendaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRESTAMO_PRODUCTO_TIENDA", nullable = false)
    private Integer idPrestamoProductoTienda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @JoinColumn(name = "ID_TIENDA_RECIBE", referencedColumnName = "ID_TIENDA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "ID_TIENDA_PRESTA", referencedColumnName = "ID_TIENDA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda1;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public PrestamoProductoTiendaUsuario() {
    }

    public PrestamoProductoTiendaUsuario(Integer idPrestamoProductoTienda) {
        this.idPrestamoProductoTienda = idPrestamoProductoTienda;
    }

    public PrestamoProductoTiendaUsuario(Integer idPrestamoProductoTienda, int cantidad, Date fechaIngreso) {
        this.idPrestamoProductoTienda = idPrestamoProductoTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdPrestamoProductoTienda() {
        return idPrestamoProductoTienda;
    }

    public void setIdPrestamoProductoTienda(Integer idPrestamoProductoTienda) {
        this.idPrestamoProductoTienda = idPrestamoProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Tienda getTienda1() {
        return tienda1;
    }

    public void setTienda1(Tienda tienda1) {
        this.tienda1 = tienda1;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamoProductoTienda != null ? idPrestamoProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoProductoTiendaUsuario)) {
            return false;
        }
        PrestamoProductoTiendaUsuario other = (PrestamoProductoTiendaUsuario) object;
        if ((this.idPrestamoProductoTienda == null && other.idPrestamoProductoTienda != null) || (this.idPrestamoProductoTienda != null && !this.idPrestamoProductoTienda.equals(other.idPrestamoProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PrestamoProductoTiendaUsuario[idPrestamoProductoTienda=" + idPrestamoProductoTienda + "]";
    }

}
