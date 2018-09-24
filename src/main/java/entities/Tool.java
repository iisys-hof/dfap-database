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
@Table(name = "tool", catalog = "DFAP", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"geometry", "variant", "version"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tool.findAll", query = "SELECT t FROM Tool t")
    , @NamedQuery(name = "Tool.findByToolId", query = "SELECT t FROM Tool t WHERE t.toolId = :toolId")
    , @NamedQuery(name = "Tool.findByGeometry", query = "SELECT t FROM Tool t WHERE t.geometry = :geometry")
    , @NamedQuery(name = "Tool.findByVariant", query = "SELECT t FROM Tool t WHERE t.variant = :variant")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "toolId")
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_id", nullable = false)
    private Long toolId;

    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "geometry")
    private String geometry;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "variant")
    private String variant;
    @Size(max = 10)
    @Column(name = "version")
    private String version;


    transient private String name;


    @OneToMany(mappedBy = "toolId")
    @JsonIgnore
    private List<Ordering> orderingList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolId")
    @JsonIgnore
    private List<ToolSetting> toolSettingList;

    @JoinColumn(name = "test_instruction_id", referencedColumnName = "test_instruction_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private TestInstruction testInstructionId;

    @OneToMany(mappedBy = "toolId")
    private List<TestInstructionEntry> testInstructionEntryList;

    public Tool() {
    }

    public Tool(Long toolId) {
        this.toolId = toolId;
    }

    public Tool(Long toolId, String geometry, String variant) {
        this.toolId = toolId;
        this.geometry = geometry;
        this.variant = variant;
    }

    public Tool(Long toolId, String name) {
        this.toolId = toolId;
        if(name.startsWith("W")) {
            name = name.substring(1);
        }
        if (name.length() == 6) {
            this.name = name;
            this.geometry = name.substring(0, 4);
            this.variant = name.substring(4,6);
            this.name = "W" + name;
        }



    }


    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        if(name == null) {
            name = "W" + this.geometry + this.variant;
        }
        return name;
    }
    public void setName(String name) {
        if(name.startsWith("W")) {
            name = name.substring(1);
        }
        if (name.length() == 6) {
            this.name = name;
            this.geometry = name.substring(0, 4);
            this.variant = name.substring(4,6);
            this.name = "W" + name;
        }
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

    public TestInstruction getTestInstructionId() {
        return testInstructionId;
    }

    public void setTestInstructionId(TestInstruction testInstructionId) {
        this.testInstructionId = testInstructionId;
    }

    public List<TestInstructionEntry> getTestInstructionEntryList() {
        return testInstructionEntryList;
    }

    public void setTestInstructionEntryList(List<TestInstructionEntry> testInstructionEntryList) {
        this.testInstructionEntryList = testInstructionEntryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toolId != null ? toolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tool)) {
            return false;
        }
        Tool other = (Tool) object;
        if ((this.toolId == null && other.toolId != null) || (this.toolId != null && !this.toolId.equals(other.toolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tool{" +
                ", geometry='" + geometry + '\'' +
                ", variant='" + variant + '\'' +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
