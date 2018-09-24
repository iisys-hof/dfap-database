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
@Table(name = "machine_part", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MachinePart.findAll", query = "SELECT m FROM MachinePart m")
    , @NamedQuery(name = "MachinePart.findByMachinePartId", query = "SELECT m FROM MachinePart m WHERE m.machinePartId = :machinePartId")
    , @NamedQuery(name = "MachinePart.findByName", query = "SELECT m FROM MachinePart m WHERE m.name = :name")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "machinePartId")
public class MachinePart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_part_id", nullable = false)
    private Long machinePartId;
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;
    @OneToMany(mappedBy = "machinePartId")
    @JsonIgnore
    private List<MachineProperty> machinePropertyList;
    @OneToMany(mappedBy = "machinePartId")
    @JsonIgnore
    private List<SettingValue> settingValueList;

    public MachinePart() {
    }

    public MachinePart(Long machinePartId) {
        this.machinePartId = machinePartId;
    }

    public Long getMachinePartId() {
        return machinePartId;
    }

    public void setMachinePartId(Long machinePartId) {
        this.machinePartId = machinePartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<MachineProperty> getMachinePropertyList() {
        return machinePropertyList;
    }

    public void setMachinePropertyList(List<MachineProperty> machinePropertyList) {
        this.machinePropertyList = machinePropertyList;
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
        hash += (machinePartId != null ? machinePartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachinePart)) {
            return false;
        }
        MachinePart other = (MachinePart) object;
        if ((this.machinePartId == null && other.machinePartId != null) || (this.machinePartId != null && !this.machinePartId.equals(other.machinePartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MachinePart[ machinePartId=" + machinePartId + " ]";
    }
    
}
