/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "NEGOCIO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Negocio.findAll", query = "SELECT n FROM Negocio n"),
    @NamedQuery(name = "Negocio.findByIdNegocio", query = "SELECT n FROM Negocio n WHERE n.idNegocio = :idNegocio"),
    @NamedQuery(name = "Negocio.findByNombreNegocio", query = "SELECT n FROM Negocio n WHERE n.nombreNegocio = :nombreNegocio")})
public class Negocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NEGOCIO", nullable = false)
    private Integer idNegocio;
    @Basic(optional = false)
    @Column(name = "NOMBRE_NEGOCIO", nullable = false, length = 350)
    private String nombreNegocio;
    @OneToMany(mappedBy = "negocio", fetch = FetchType.LAZY)
    private List<Tienda> tiendaList;

    public Negocio() {
    }

    public Negocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Negocio(Integer idNegocio, String nombreNegocio) {
        this.idNegocio = idNegocio;
        this.nombreNegocio = nombreNegocio;
    }

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public List<Tienda> getTiendaList() {
        return tiendaList;
    }

    public void setTiendaList(List<Tienda> tiendaList) {
        this.tiendaList = tiendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNegocio != null ? idNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Negocio)) {
            return false;
        }
        Negocio other = (Negocio) object;
        if ((this.idNegocio == null && other.idNegocio != null) || (this.idNegocio != null && !this.idNegocio.equals(other.idNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Negocio[idNegocio=" + idNegocio + "]";
    }

}
