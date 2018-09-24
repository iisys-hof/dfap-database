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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "setting_value", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SettingValue.findAll", query = "SELECT s FROM SettingValue s")
    , @NamedQuery(name = "SettingValue.findBySettingValueId", query = "SELECT s FROM SettingValue s WHERE s.settingValueId = :settingValueId")
    , @NamedQuery(name = "SettingValue.findByValue", query = "SELECT s FROM SettingValue s WHERE s.value = :value")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "settingValueId")
public class SettingValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_value_id", nullable = false)
    private Long settingValueId;
    @Size(max = 10)
    @Column(name = "value", length = 10)
    private String value;
    @JoinColumn(name = "machine_part_id", referencedColumnName = "machine_part_id")
    @ManyToOne
    @JsonProperty(value = "machinePart")
    private MachinePart machinePartId;
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
    @ManyToOne
    @JsonProperty(value = "property")
    private Property propertyId;
    @JoinColumn(name = "tool_setting_id", referencedColumnName = "tool_setting_id")
    @ManyToOne
    @JsonIgnore
    private ToolSetting toolSettingId;

    public SettingValue() {
    }

    public SettingValue(Long settingValueId) {
        this.settingValueId = settingValueId;
    }

    public Long getSettingValueId() {
        return settingValueId;
    }

    public void setSettingValueId(Long settingValueId) {
        this.settingValueId = settingValueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public ToolSetting getToolSettingId() {
        return toolSettingId;
    }

    public void setToolSettingId(ToolSetting toolSettingId) {
        this.toolSettingId = toolSettingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settingValueId != null ? settingValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SettingValue)) {
            return false;
        }
        SettingValue other = (SettingValue) object;
        if ((this.settingValueId == null && other.settingValueId != null) || (this.settingValueId != null && !this.settingValueId.equals(other.settingValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SettingValue[ settingValueId=" + settingValueId + " ]";
    }
    
}
