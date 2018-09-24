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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "property", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p")
    , @NamedQuery(name = "Property.findByPropertyId", query = "SELECT p FROM Property p WHERE p.propertyId = :propertyId")
    , @NamedQuery(name = "Property.findByName", query = "SELECT p FROM Property p WHERE p.name = :name")
    , @NamedQuery(name = "Property.findByType", query = "SELECT p FROM Property p WHERE p.type = :type")
    , @NamedQuery(name = "Property.findByPosition", query = "SELECT p FROM Property p WHERE p.position = :position")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "propertyId")
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id", nullable = false)
    private Long propertyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type", nullable = false)
    private short type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position", nullable = false)
    private int position;
    @OneToMany(mappedBy = "propertyId")
    @JsonIgnore
    private List<MachineProperty> machinePropertyList;
    @JoinColumn(name = "property_category_id", referencedColumnName = "property_category_id")
    @ManyToOne
    private PropertyCategory propertyCategoryId;
    @OneToMany(mappedBy = "propertyId")
    @JsonIgnore
    private List<SettingValue> settingValueList;

    public Property() {
    }

    public Property(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Property(Long propertyId, String name, short type, int position) {
        this.propertyId = propertyId;
        this.name = name;
        this.type = type;
        this.position = position;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @XmlTransient
    public List<MachineProperty> getMachinePropertyList() {
        return machinePropertyList;
    }

    public void setMachinePropertyList(List<MachineProperty> machinePropertyList) {
        this.machinePropertyList = machinePropertyList;
    }

    public PropertyCategory getPropertyCategoryId() {
        return propertyCategoryId;
    }

    public void setPropertyCategoryId(PropertyCategory propertyCategoryId) {
        this.propertyCategoryId = propertyCategoryId;
    }

    @XmlTransient
    public List<SettingValue> getSettingValueList() {
        return settingValueList;
    }

    public void setSettingValueList(List<SettingValue> settingValueList) {
        this.settingValueList = settingValueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.propertyId == null && other.propertyId != null) || (this.propertyId != null && !this.propertyId.equals(other.propertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Property[ propertyId=" + propertyId + " ]";
    }
    
}
