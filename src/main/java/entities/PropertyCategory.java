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
@Table(name = "property_category", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyCategory.findAll", query = "SELECT p FROM PropertyCategory p")
    , @NamedQuery(name = "PropertyCategory.findByPropertyCategoryId", query = "SELECT p FROM PropertyCategory p WHERE p.propertyCategoryId = :propertyCategoryId")
    , @NamedQuery(name = "PropertyCategory.findByName", query = "SELECT p FROM PropertyCategory p WHERE p.name = :name")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "propertyCategoryId")
public class PropertyCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_category_id", nullable = false)
    private Long propertyCategoryId;
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;
    @OneToMany(mappedBy = "propertyCategoryId")
    @JsonIgnore
    private List<Property> propertyList;

    public PropertyCategory() {
    }

    public PropertyCategory(Long propertyCategoryId) {
        this.propertyCategoryId = propertyCategoryId;
    }

    public Long getPropertyCategoryId() {
        return propertyCategoryId;
    }

    public void setPropertyCategoryId(Long propertyCategoryId) {
        this.propertyCategoryId = propertyCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyCategoryId != null ? propertyCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyCategory)) {
            return false;
        }
        PropertyCategory other = (PropertyCategory) object;
        if ((this.propertyCategoryId == null && other.propertyCategoryId != null) || (this.propertyCategoryId != null && !this.propertyCategoryId.equals(other.propertyCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PropertyCategory[ propertyCategoryId=" + propertyCategoryId + " ]";
    }
    
}
