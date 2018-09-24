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

import com.fasterxml.jackson.annotation.*;
import jsonViews.Views;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "test_instruction", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestInstruction.findAll", query = "SELECT t FROM TestInstruction t")
    , @NamedQuery(name = "TestInstruction.findByTestInstructionId", query = "SELECT t FROM TestInstruction t WHERE t.testInstructionId = :testInstructionId")
    , @NamedQuery(name = "TestInstruction.findByDate", query = "SELECT t FROM TestInstruction t WHERE t.date = :date")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "testInstructionId", scope = TestInstruction.class)
public class TestInstruction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_instruction_id", nullable = false)
    private Long testInstructionId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "name")
    private String name;




    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "testInstructionId")
    @JsonProperty
    private List<Tool> toolList;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "testInstructionId")
    @JsonProperty
    private List<TestInstructionProperty> testInstructionPropertyList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testInstructionId")
    @JsonIgnore
    private List<TestInstructionEntry> testInstructionEntryList;



    public TestInstruction() {
    }

    public TestInstruction(Long testInstructionId) {
        this.testInstructionId = testInstructionId;
    }

    public Long getTestInstructionId() {
        return testInstructionId;
    }

    public void setTestInstructionId(Long testInstructionId) {
        this.testInstructionId = testInstructionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tool> getToolList() {
        return toolList;
    }

    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
    }

    public List<TestInstructionProperty> getTestInstructionPropertyList() {
        return testInstructionPropertyList;
    }

    public void setTestInstructionPropertyList(List<TestInstructionProperty> testInstructionPropertyList) {
        this.testInstructionPropertyList = testInstructionPropertyList;
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
        hash += (testInstructionId != null ? testInstructionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestInstruction)) {
            return false;
        }
        TestInstruction other = (TestInstruction) object;
        if ((this.testInstructionId == null && other.testInstructionId != null) || (this.testInstructionId != null && !this.testInstructionId.equals(other.testInstructionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TestInstruction[ testInstructionId=" + testInstructionId + " ]";
    }
}
