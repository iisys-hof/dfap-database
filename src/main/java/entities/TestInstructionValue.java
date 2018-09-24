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
@Table(name = "test_instruction_value", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestInstructionValue.findAll", query = "SELECT t FROM TestInstructionValue t")
    , @NamedQuery(name = "TestInstructionValue.findByTestInstructionValueId", query = "SELECT t FROM TestInstructionValue t WHERE t.testInstructionValueId = :testInstructionValueId")
    , @NamedQuery(name = "TestInstructionValue.findByCheckValue", query = "SELECT t FROM TestInstructionValue t WHERE t.checkValue = :checkValue")
    , @NamedQuery(name = "TestInstructionValue.findByCheckText", query = "SELECT t FROM TestInstructionValue t WHERE t.checkText = :checkText")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "testInstructionValueId", scope = TestInstructionValue.class)
public class TestInstructionValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_instruction_value_id", nullable = false)
    private Long testInstructionValueId;
    @Column(name = "number")
    private Integer number;
    @Column(name = "check_value")
    private Short checkValue;
    @Size(max = 50)
    @Column(name = "check_text", length = 50)
    private String checkText;
    @JoinColumn(name = "test_instruction_entry_id", referencedColumnName = "test_instruction_entry_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private TestInstructionEntry testInstructionEntryId;

    public TestInstructionValue() {
    }

    public TestInstructionValue(Long testInstructionValueId) {
        this.testInstructionValueId = testInstructionValueId;
    }

    public Long getTestInstructionValueId() {
        return testInstructionValueId;
    }

    public void setTestInstructionValueId(Long testInstructionValueId) {
        this.testInstructionValueId = testInstructionValueId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Short getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Short checkValue) {
        this.checkValue = checkValue;
    }

    public String getCheckText() {
        return checkText;
    }

    public void setCheckText(String checkText) {
        this.checkText = checkText;
    }

    public TestInstructionEntry getTestInstructionEntryId() {
        return testInstructionEntryId;
    }

    public void setTestInstructionEntryId(TestInstructionEntry testInstructionEntryId) {
        this.testInstructionEntryId = testInstructionEntryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testInstructionValueId != null ? testInstructionValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestInstructionValue)) {
            return false;
        }
        TestInstructionValue other = (TestInstructionValue) object;
        if ((this.testInstructionValueId == null && other.testInstructionValueId != null) || (this.testInstructionValueId != null && !this.testInstructionValueId.equals(other.testInstructionValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestInstructionValue{" +
                "testInstructionValueId=" + testInstructionValueId +
                ", number=" + number +
                ", checkValue=" + checkValue +
                ", checkText='" + checkText + '\'' +
                '}';
    }
}
