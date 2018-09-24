/*
 * Copyright 2018 Thomas Winkler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "ordering_parts_list", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderingPartsList.findAll", query = "SELECT o FROM OrderingPartsList o")
    , @NamedQuery(name = "OrderingPartsList.findByOrderingPartsListId", query = "SELECT o FROM OrderingPartsList o WHERE o.orderingPartsListId = :orderingPartsListId")
    , @NamedQuery(name = "OrderingPartsList.findByComponent", query = "SELECT o FROM OrderingPartsList o WHERE o.component = :component")
    , @NamedQuery(name = "OrderingPartsList.findByDescription", query = "SELECT o FROM OrderingPartsList o WHERE o.description = :description")
    , @NamedQuery(name = "OrderingPartsList.findByQuantity", query = "SELECT o FROM OrderingPartsList o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderingPartsList.findByUnit", query = "SELECT o FROM OrderingPartsList o WHERE o.unit = :unit")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderingPartsListId")
public class OrderingPartsList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordering_parts_list_id", nullable = false)
    private Long orderingPartsListId;
    @Size(max = 20)
    @Column(name = "component", length = 20)
    private String component;
    @Size(max = 50)
    @Column(name = "description", length = 50)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity", precision = 53)
    private Double quantity;
    @Size(max = 5)
    @Column(name = "unit", length = 5)
    private String unit;
    @JoinColumn(name = "ordering_id", referencedColumnName = "ordering_id")
    @ManyToOne
    private Ordering orderingId;

    public OrderingPartsList() {
    }

    public OrderingPartsList(Long orderingPartsListId) {
        this.orderingPartsListId = orderingPartsListId;
    }

    public Long getOrderingPartsListId() {
        return orderingPartsListId;
    }

    public void setOrderingPartsListId(Long orderingPartsListId) {
        this.orderingPartsListId = orderingPartsListId;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Ordering getOrderingId() {
        return orderingId;
    }

    public void setOrderingId(Ordering orderingId) {
        this.orderingId = orderingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderingPartsListId != null ? orderingPartsListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderingPartsList)) {
            return false;
        }
        OrderingPartsList other = (OrderingPartsList) object;
        if ((this.orderingPartsListId == null && other.orderingPartsListId != null) || (this.orderingPartsListId != null && !this.orderingPartsListId.equals(other.orderingPartsListId))) {
            return false;
        }
        return true;
    }

    public boolean isSame(OrderingPartsList o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderingPartsList that =  o;
        return  Objects.equals(component, that.component) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public String toString() {
        return "OrderingPartsList{" +
                "orderingPartsListId=" + orderingPartsListId +
                ", component='" + component + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
