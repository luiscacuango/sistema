/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

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
@Table(name = "TIENDA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tienda.findAll", query = "SELECT t FROM Tienda t"),
    @NamedQuery(name = "Tienda.findByIdTienda", query = "SELECT t FROM Tienda t WHERE t.idTienda = :idTienda"),
    @NamedQuery(name = "Tienda.findByNombreTienda", query = "SELECT t FROM Tienda t WHERE t.nombreTienda = :nombreTienda"),
    @NamedQuery(name = "Tienda.findByDireccion", query = "SELECT t FROM Tienda t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "Tienda.findByCiudad", query = "SELECT t FROM Tienda t WHERE t.ciudad = :ciudad"),
    @NamedQuery(name = "Tienda.findByDistrito", query = "SELECT t FROM Tienda t WHERE t.distrito = :distrito"),
    @NamedQuery(name = "Tienda.findByTelefonos", query = "SELECT t FROM Tienda t WHERE t.telefonos = :telefonos"),
    @NamedQuery(name = "Tienda.findByNumeroRuc", query = "SELECT t FROM Tienda t WHERE t.numeroRuc = :numeroRuc")})
public class Tienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIENDA", nullable = false)
    private Integer idTienda;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIENDA", nullable = false, length = 350)
    private String nombreTienda;
    @Basic(optional = false)
    @Column(name = "DIRECCION", nullable = false, length = 200)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "CIUDAD", nullable = false, length = 200)
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "DISTRITO", nullable = false, length = 200)
    private String distrito;
    @Basic(optional = false)
    @Column(name = "TELEFONOS", nullable = false, length = 400)
    private String telefonos;
    @Basic(optional = false)
    @Column(name = "NUMERO_RUC", nullable = false, length = 20)
    private String numeroRuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @JoinColumn(name = "ID_NEGOCIO", referencedColumnName = "ID_NEGOCIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Negocio negocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda1", fetch = FetchType.LAZY)
    private List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<ProduccionAlmacen> produccionAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<SalidaProductoTienda> salidaProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda", fetch = FetchType.LAZY)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;

    public Tienda() {
    }

    public Tienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public Tienda(Integer idTienda, String nombreTienda, String direccion, String ciudad, String distrito, String telefonos, String numeroRuc) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.distrito = distrito;
        this.telefonos = telefonos;
        this.numeroRuc = numeroRuc;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getNumeroRuc() {
        return numeroRuc;
    }

    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }

    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
    }

    public List<StockProductoTiendaOrigen> getStockProductoTiendaOrigenList() {
        return stockProductoTiendaOrigenList;
    }

    public void setStockProductoTiendaOrigenList(List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList) {
        this.stockProductoTiendaOrigenList = stockProductoTiendaOrigenList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public List<PrestamoProductoTiendaUsuario> getPrestamoProductoTiendaUsuarioList() {
        return prestamoProductoTiendaUsuarioList;
    }

    public void setPrestamoProductoTiendaUsuarioList(List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList) {
        this.prestamoProductoTiendaUsuarioList = prestamoProductoTiendaUsuarioList;
    }

    public List<PrestamoProductoTiendaUsuario> getPrestamoProductoTiendaUsuarioList1() {
        return prestamoProductoTiendaUsuarioList1;
    }

    public void setPrestamoProductoTiendaUsuarioList1(List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList1) {
        this.prestamoProductoTiendaUsuarioList1 = prestamoProductoTiendaUsuarioList1;
    }

    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    public List<ProduccionAlmacen> getProduccionAlmacenList() {
        return produccionAlmacenList;
    }

    public void setProduccionAlmacenList(List<ProduccionAlmacen> produccionAlmacenList) {
        this.produccionAlmacenList = produccionAlmacenList;
    }

    public List<SalidaProductoTienda> getSalidaProductoTiendaList() {
        return salidaProductoTiendaList;
    }

    public void setSalidaProductoTiendaList(List<SalidaProductoTienda> salidaProductoTiendaList) {
        this.salidaProductoTiendaList = salidaProductoTiendaList;
    }

    public List<IngresoMateriaPrimaTienda> getIngresoMateriaPrimaTiendaList() {
        return ingresoMateriaPrimaTiendaList;
    }

    public void setIngresoMateriaPrimaTiendaList(List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList) {
        this.ingresoMateriaPrimaTiendaList = ingresoMateriaPrimaTiendaList;
    }

    public List<SalidaMateriaPrimaTienda> getSalidaMateriaPrimaTiendaList() {
        return salidaMateriaPrimaTiendaList;
    }

    public void setSalidaMateriaPrimaTiendaList(List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList) {
        this.salidaMateriaPrimaTiendaList = salidaMateriaPrimaTiendaList;
    }

    public List<StockMateriaPrimaTiendaOrigen> getStockMateriaPrimaTiendaOrigenList() {
        return stockMateriaPrimaTiendaOrigenList;
    }

    public void setStockMateriaPrimaTiendaOrigenList(List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList) {
        this.stockMateriaPrimaTiendaOrigenList = stockMateriaPrimaTiendaOrigenList;
    }

    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTienda != null ? idTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tienda)) {
            return false;
        }
        Tienda other = (Tienda) object;
        return !((this.idTienda == null && other.idTienda != null) || (this.idTienda != null && !this.idTienda.equals(other.idTienda)));
    }

    @Override
    public String toString() {
        return "be.Tienda[idTienda=" + idTienda + "]";
    }

}
