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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "test_instruction_property", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestInstructionProperty.findAll", query = "SELECT t FROM TestInstructionProperty t")
    , @NamedQuery(name = "TestInstructionProperty.findByTestInstructionPropertyId", query = "SELECT t FROM TestInstructionProperty t WHERE t.testInstructionPropertyId = :testInstructionPropertyId")
    , @NamedQuery(name = "TestInstructionProperty.findByNumber", query = "SELECT t FROM TestInstructionProperty t WHERE t.number = :number")
    , @NamedQuery(name = "TestInstructionProperty.findByName", query = "SELECT t FROM TestInstructionProperty t WHERE t.name = :name")
    , @NamedQuery(name = "TestInstructionProperty.findByAdditionalInfo", query = "SELECT t FROM TestInstructionProperty t WHERE t.additionalInfo = :additionalInfo")
    , @NamedQuery(name = "TestInstructionProperty.findByType", query = "SELECT t FROM TestInstructionProperty t WHERE t.type = :type")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "testInstructionPropertyId", scope = TestInstructionProperty.class)
public class TestInstructionProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_instruction_property_id", nullable = false)
    private Long testInstructionPropertyId;
    @Column(name = "number")
    private Integer number;
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;
    @Size(max = 50)
    @Column(name = "additional_info", length = 50)
    private String additionalInfo;
    @Column(name = "type")
    private Short type;
    @Column(name = "active")
    private Short active;
    @JoinColumn(name = "test_instruction_id", referencedColumnName = "test_instruction_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private TestInstruction testInstructionId;

    public TestInstructionProperty() {
    }

    public TestInstructionProperty(Long testInstructionPropertyId) {
        this.testInstructionPropertyId = testInstructionPropertyId;
    }

    public Long getTestInstructionPropertyId() {
        return testInstructionPropertyId;
    }

    public void setTestInstructionPropertyId(Long testInstructionPropertyId) {
        this.testInstructionPropertyId = testInstructionPropertyId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public TestInstruction getTestInstructionId() {
        return testInstructionId;
    }

    public void setTestInstructionId(TestInstruction testInstructionId) {
        this.testInstructionId = testInstructionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testInstructionPropertyId != null ? testInstructionPropertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestInstructionProperty)) {
            return false;
        }
        TestInstructionProperty other = (TestInstructionProperty) object;
        if ((this.testInstructionPropertyId == null && other.testInstructionPropertyId != null) || (this.testInstructionPropertyId != null && !this.testInstructionPropertyId.equals(other.testInstructionPropertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestInstructionProperty{" +
                "testInstructionPropertyId=" + testInstructionPropertyId +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
