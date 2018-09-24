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
@Table(name = "test_instruction_entry", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestInstructionEntry.findAll", query = "SELECT t FROM TestInstructionEntry t")
    , @NamedQuery(name = "TestInstructionEntry.findByTestInstructionEntryId", query = "SELECT t FROM TestInstructionEntry t WHERE t.testInstructionEntryId = :testInstructionEntryId")
    , @NamedQuery(name = "TestInstructionEntry.findByDate", query = "SELECT t FROM TestInstructionEntry t WHERE t.date = :date")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "testInstructionEntryId", scope = TestInstructionEntry.class)
public class TestInstructionEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_instruction_entry_id", nullable = false)
    private Long testInstructionEntryId;


    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "testInstructionEntryId")
    @JsonProperty
    private List<TestInstructionValue> testInstructionValueList;



    @JoinColumn(name = "test_instruction_id", referencedColumnName = "test_instruction_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private TestInstruction testInstructionId;

    @JsonIgnore
    @JoinColumn(name = "tool_id", referencedColumnName = "tool_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Tool toolId;


    public TestInstructionEntry() {
    }

    public TestInstructionEntry(Long testInstructionEntryId) {
        this.testInstructionEntryId = testInstructionEntryId;
    }

    public Long getTestInstructionEntryId() {
        return testInstructionEntryId;
    }

    public void setTestInstructionEntryId(Long testInstructionEntryId) {
        this.testInstructionEntryId = testInstructionEntryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<TestInstructionValue> getTestInstructionValueList() {
        return testInstructionValueList;
    }

    public void setTestInstructionValueList(List<TestInstructionValue> testInstructionValueList) {
        this.testInstructionValueList = testInstructionValueList;
    }

    public TestInstruction getTestInstructionId() {
        return testInstructionId;
    }

    public void setTestInstructionId(TestInstruction testInstructionId) {
        this.testInstructionId = testInstructionId;
    }

    public Tool getToolId() {
        return toolId;
    }

    public void setToolId(Tool toolId) {
        this.toolId = toolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testInstructionEntryId != null ? testInstructionEntryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestInstructionEntry)) {
            return false;
        }
        TestInstructionEntry other = (TestInstructionEntry) object;
        if ((this.testInstructionEntryId == null && other.testInstructionEntryId != null) || (this.testInstructionEntryId != null && !this.testInstructionEntryId.equals(other.testInstructionEntryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestInstructionEntry{" +
                "testInstructionEntryId=" + testInstructionEntryId +
                ", date=" + date +
                ", testInstructionValueList=" + testInstructionValueList +
                '}';
    }
}
