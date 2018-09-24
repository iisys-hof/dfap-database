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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "tool_setting", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToolSetting.findAll", query = "SELECT t FROM ToolSetting t")
    , @NamedQuery(name = "ToolSetting.findByToolSettingId", query = "SELECT t FROM ToolSetting t WHERE t.toolSettingId = :toolSettingId")
    , @NamedQuery(name = "ToolSetting.findByDate", query = "SELECT t FROM ToolSetting t WHERE t.date = :date")
    , @NamedQuery(name = "ToolSetting.findByNote", query = "SELECT t FROM ToolSetting t WHERE t.note = :note")
    , @NamedQuery(name = "ToolSetting.findByOntop", query = "SELECT t FROM ToolSetting t WHERE t.ontop = :ontop")})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "toolSettingId")
public class ToolSetting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_setting_id", nullable = false)
    private Long toolSettingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 250)
    @Column(name = "note", length = 250)
    private String note;
    @Column(name = "ontop")
    private Integer ontop;
    @JoinColumn(name = "article_id", referencedColumnName = "id_article")
    @ManyToOne
    @JsonIgnore
    private Article articleId;
    @JoinColumn(name = "machine_id", referencedColumnName = "machine_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Machine machineId;
    @JoinColumn(name = "tool_id", referencedColumnName = "tool_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Tool toolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolSettingId")
    @JsonProperty(value = "settingValues")
    private List<SettingValue> settingValueList;

    public ToolSetting() {
    }

    public ToolSetting(Long toolSettingId) {
        this.toolSettingId = toolSettingId;
    }

    public ToolSetting(Long toolSettingId, Date date) {
        this.toolSettingId = toolSettingId;
        this.date = date;
    }

    public Long getToolSettingId() {
        return toolSettingId;
    }

    public void setToolSettingId(Long toolSettingId) {
        this.toolSettingId = toolSettingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getOntop() {
        return ontop;
    }

    public void setOntop(Integer ontop) {
        this.ontop = ontop;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public Machine getMachineId() {
        return machineId;
    }

    public void setMachineId(Machine machineId) {
        this.machineId = machineId;
    }

    public Tool getToolId() {
        return toolId;
    }

    public void setToolId(Tool toolId) {
        this.toolId = toolId;
    }

    public List<SettingValue> getSettingValueList() {
        return settingValueList;
    }

    public void setSettingValueList(List<SettingValue> settingValueList) {
        this.settingValueList = settingValueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toolSettingId != null ? toolSettingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToolSetting)) {
            return false;
        }
        ToolSetting other = (ToolSetting) object;
        if ((this.toolSettingId == null && other.toolSettingId != null) || (this.toolSettingId != null && !this.toolSettingId.equals(other.toolSettingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ToolSetting[ toolSettingId=" + toolSettingId + " ]";
    }
    
}
