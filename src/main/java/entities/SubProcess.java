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
@Table(name = "sub_process", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubProcess.findAll", query = "SELECT s FROM SubProcess s")
    , @NamedQuery(name = "SubProcess.findBySubProcessId", query = "SELECT s FROM SubProcess s WHERE s.subProcessId = :subProcessId")
    , @NamedQuery(name = "SubProcess.findByName", query = "SELECT s FROM SubProcess s WHERE s.name = :name")
    , @NamedQuery(name = "SubProcess.findByAbbreviation", query = "SELECT s FROM SubProcess s WHERE s.abbreviation = :abbreviation")})
public class SubProcess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_process_id", nullable = false)
    private Integer subProcessId;
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;
    @Size(max = 5)
    @Column(name = "abbreviation", length = 5)
    private String abbreviation;
    @OneToMany(mappedBy = "subProcessId")
    @JsonIgnore
    private List<FeedbackEntry> feedbackEntryList;

    public SubProcess() {
    }

    public SubProcess(Integer subProcessId) {
        this.subProcessId = subProcessId;
    }

    public Integer getSubProcessId() {
        return subProcessId;
    }

    public void setSubProcessId(Integer subProcessId) {
        this.subProcessId = subProcessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @XmlTransient
    public List<FeedbackEntry> getFeedbackEntryList() {
        return feedbackEntryList;
    }

    public void setFeedbackEntryList(List<FeedbackEntry> feedbackEntryList) {
        this.feedbackEntryList = feedbackEntryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subProcessId != null ? subProcessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubProcess)) {
            return false;
        }
        SubProcess other = (SubProcess) object;
        if ((this.subProcessId == null && other.subProcessId != null) || (this.subProcessId != null && !this.subProcessId.equals(other.subProcessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SubProcess[ subProcessId=" + subProcessId + " ]";
    }
    
}
