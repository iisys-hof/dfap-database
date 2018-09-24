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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "machine_property", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MachineProperty.findAll", query = "SELECT m FROM MachineProperty m")
    , @NamedQuery(name = "MachineProperty.findByMachinePropertyId", query = "SELECT m FROM MachineProperty m WHERE m.machinePropertyId = :machinePropertyId")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "machinePropertyId")
public class MachineProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_property_id", nullable = false)
    private Long machinePropertyId;
    @JoinColumn(name = "machine_id", referencedColumnName = "machine_id")
    @ManyToOne
    private Machine machineId;
    @JoinColumn(name = "machine_part_id", referencedColumnName = "machine_part_id")
    @ManyToOne
    private MachinePart machinePartId;
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
    @ManyToOne
    private Property propertyId;

    public MachineProperty() {
    }

    public MachineProperty(Long machinePropertyId) {
        this.machinePropertyId = machinePropertyId;
    }

    public Long getMachinePropertyId() {
        return machinePropertyId;
    }

    public void setMachinePropertyId(Long machinePropertyId) {
        this.machinePropertyId = machinePropertyId;
    }

    public Machine getMachineId() {
        return machineId;
    }

    public void setMachineId(Machine machineId) {
        this.machineId = machineId;
    }

    public MachinePart getMachinePartId() {
        return machinePartId;
    }

    public void setMachinePartId(MachinePart machinePartId) {
        this.machinePartId = machinePartId;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machinePropertyId != null ? machinePropertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachineProperty)) {
            return false;
        }
        MachineProperty other = (MachineProperty) object;
        if ((this.machinePropertyId == null && other.machinePropertyId != null) || (this.machinePropertyId != null && !this.machinePropertyId.equals(other.machinePropertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MachineProperty[ machinePropertyId=" + machinePropertyId + " ]";
    }
    
}
