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
@Table(name = "machine", catalog = "DFAP", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m")
    , @NamedQuery(name = "Machine.findByMachineId", query = "SELECT m FROM Machine m WHERE m.machineId = :machineId")
    , @NamedQuery(name = "Machine.findByName", query = "SELECT m FROM Machine m WHERE m.name = :name")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "machineId")
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id", nullable = false)
    private Long machineId;
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;
    @Size(max = 16)
    @Column(name = "printerAddress", length = 16)
    private String printerAddress;
    @OneToMany(mappedBy = "machineId")
    @JsonIgnore
    private List<MachineProperty> machinePropertyList;
    @OneToMany(mappedBy = "machineId")
    @JsonIgnore
    private List<Ordering> orderingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machineId")
    @JsonIgnore
    private List<ToolSetting> toolSettingList;

    public Machine() {
    }

    public Machine(Long machineId) {
        this.machineId = machineId;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrinterAddress() {
        return printerAddress;
    }

    public void setPrinterAddress(String printerAddress) {
        this.printerAddress = printerAddress;
    }

    @XmlTransient
    public List<MachineProperty> getMachinePropertyList() {
        return machinePropertyList;
    }

    public void setMachinePropertyList(List<MachineProperty> machinePropertyList) {
        this.machinePropertyList = machinePropertyList;
    }

    @XmlTransient
    public List<Ordering> getOrderingList() {
        return orderingList;
    }

    public void setOrderingList(List<Ordering> orderingList) {
        this.orderingList = orderingList;
    }

    @XmlTransient
    public List<ToolSetting> getToolSettingList() {
        return toolSettingList;
    }

    public void setToolSettingList(List<ToolSetting> toolSettingList) {
        this.toolSettingList = toolSettingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machineId != null ? machineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.machineId == null && other.machineId != null) || (this.machineId != null && !this.machineId.equals(other.machineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "machineId=" + machineId +
                ", name='" + name + '\'' +
                '}';
    }
}
