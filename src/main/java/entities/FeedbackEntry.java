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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "feedback_entry", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeedbackEntry.findAll", query = "SELECT f FROM FeedbackEntry f")
    , @NamedQuery(name = "FeedbackEntry.findByFeedbackEntryId", query = "SELECT f FROM FeedbackEntry f WHERE f.feedbackEntryId = :feedbackEntryId")
    , @NamedQuery(name = "FeedbackEntry.findByAccepted", query = "SELECT f FROM FeedbackEntry f WHERE f.accepted = :accepted")
    , @NamedQuery(name = "FeedbackEntry.findByRejected", query = "SELECT f FROM FeedbackEntry f WHERE f.rejected = :rejected")
    , @NamedQuery(name = "FeedbackEntry.findByWeight", query = "SELECT f FROM FeedbackEntry f WHERE f.weight = :weight")
    , @NamedQuery(name = "FeedbackEntry.findBySpeed", query = "SELECT f FROM FeedbackEntry f WHERE f.speed = :speed")
    , @NamedQuery(name = "FeedbackEntry.findByStartTime", query = "SELECT f FROM FeedbackEntry f WHERE f.startTime = :startTime")
    , @NamedQuery(name = "FeedbackEntry.findByEndTime", query = "SELECT f FROM FeedbackEntry f WHERE f.endTime = :endTime")
    , @NamedQuery(name = "FeedbackEntry.findByShift", query = "SELECT f FROM FeedbackEntry f WHERE f.shift = :shift")
    , @NamedQuery(name = "FeedbackEntry.findByEmployeeNumber", query = "SELECT f FROM FeedbackEntry f WHERE f.employeeNumber = :employeeNumber")})

public class FeedbackEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_entry_id", nullable = false)
    private Long feedbackEntryId;
    @Column(name = "accepted")
    private Float accepted;
    @Column(name = "rejected")
    private Float rejected;
    @Column(name = "weight")
    private Float weight;
    @Column(name = "speed")
    private Float speed;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "shift")
    private Integer shift;
    @Column(name = "employee_number")
    private Integer employeeNumber;
    @JoinColumn(name = "ordering_id", referencedColumnName = "ordering_id")
    @ManyToOne
    @JsonIgnore
    private Ordering orderingId;
    @JoinColumn(name = "sub_process_id", referencedColumnName = "sub_process_id")
    @ManyToOne
    @JsonProperty(value = "subProcess")
    private SubProcess subProcessId;

    public FeedbackEntry() {
    }

    public FeedbackEntry(Long feedbackEntryId) {
        this.feedbackEntryId = feedbackEntryId;
    }

    public Long getFeedbackEntryId() {
        return feedbackEntryId;
    }

    public void setFeedbackEntryId(Long feedbackEntryId) {
        this.feedbackEntryId = feedbackEntryId;
    }

    public Float getAccepted() {
        return accepted;
    }

    public void setAccepted(Float accepted) {
        this.accepted = accepted;
    }

    public Float getRejected() {
        return rejected;
    }

    public void setRejected(Float rejected) {
        this.rejected = rejected;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Ordering getOrderingId() {
        return orderingId;
    }

    public void setOrderingId(Ordering orderingId) {
        this.orderingId = orderingId;
    }

    public SubProcess getSubProcessId() {
        return subProcessId;
    }

    public void setSubProcessId(SubProcess subProcessId) {
        this.subProcessId = subProcessId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackEntryId != null ? feedbackEntryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedbackEntry)) {
            return false;
        }
        FeedbackEntry other = (FeedbackEntry) object;
        if ((this.feedbackEntryId == null && other.feedbackEntryId != null) || (this.feedbackEntryId != null && !this.feedbackEntryId.equals(other.feedbackEntryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FeedbackEntry{" +
                "feedbackEntryId=" + feedbackEntryId +
                ", accepted=" + accepted +
                ", rejected=" + rejected +
                ", weight=" + weight +
                ", speed=" + speed +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", shift=" + shift +
                ", employeeNumber=" + employeeNumber +
                '}';
    }
}
