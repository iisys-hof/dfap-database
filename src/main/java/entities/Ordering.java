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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
@Table(name = "ordering", catalog = "DFAP", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o")
    , @NamedQuery(name = "Ordering.findByOrderingId", query = "SELECT o FROM Ordering o WHERE o.orderingId = :orderingId")
    , @NamedQuery(name = "Ordering.findByDate", query = "SELECT o FROM Ordering o WHERE o.date = :date")
    , @NamedQuery(name = "Ordering.findBySnr", query = "SELECT o FROM Ordering o WHERE o.snr = :snr")
    , @NamedQuery(name = "Ordering.findByTotalQuantity", query = "SELECT o FROM Ordering o WHERE o.totalQuantity = :totalQuantity")
    , @NamedQuery(name = "Ordering.findByTotalQuantityUnit", query = "SELECT o FROM Ordering o WHERE o.totalQuantityUnit = :totalQuantityUnit")
    , @NamedQuery(name = "Ordering.findByTypeOfContainer", query = "SELECT o FROM Ordering o WHERE o.typeOfContainer = :typeOfContainer")
    , @NamedQuery(name = "Ordering.findByQuantityPerContainer", query = "SELECT o FROM Ordering o WHERE o.quantityPerContainer = :quantityPerContainer")
    , @NamedQuery(name = "Ordering.findByPiecesPerContainer", query = "SELECT o FROM Ordering o WHERE o.piecesPerContainer = :piecesPerContainer")
    , @NamedQuery(name = "Ordering.findByQuantityOfContainer", query = "SELECT o FROM Ordering o WHERE o.quantityOfContainer = :quantityOfContainer")
    , @NamedQuery(name = "Ordering.findByShortage", query = "SELECT o FROM Ordering o WHERE o.shortage = :shortage")
    , @NamedQuery(name = "Ordering.findByLengthOfArticle", query = "SELECT o FROM Ordering o WHERE o.lengthOfArticle = :lengthOfArticle")
    , @NamedQuery(name = "Ordering.findByPrintDescription", query = "SELECT o FROM Ordering o WHERE o.printDescription = :printDescription")
    , @NamedQuery(name = "Ordering.findByProfileBody", query = "SELECT o FROM Ordering o WHERE o.profileBody = :profileBody")
    , @NamedQuery(name = "Ordering.findByProfileGasket", query = "SELECT o FROM Ordering o WHERE o.profileGasket = :profileGasket")
    , @NamedQuery(name = "Ordering.findByProfileGasketQuantity", query = "SELECT o FROM Ordering o WHERE o.profileGasketQuantity = :profileGasketQuantity")
    , @NamedQuery(name = "Ordering.findBySchufoO", query = "SELECT o FROM Ordering o WHERE o.schufoO = :schufoO")
    , @NamedQuery(name = "Ordering.findBySchufoU", query = "SELECT o FROM Ordering o WHERE o.schufoU = :schufoU")
    , @NamedQuery(name = "Ordering.findByFinishedQuantity", query = "SELECT o FROM Ordering o WHERE o.finishedQuantity = :finishedQuantity")
    , @NamedQuery(name = "Ordering.findByOrderActive", query = "SELECT o FROM Ordering o WHERE o.orderActive = :orderActive")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderingId")
public class Ordering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ordering_id", nullable = false)
    private Long orderingId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "snr")
    private Integer snr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_quantity", precision = 53)
    private Double totalQuantity;
    @Column(name = "total_quantity_unit")
    private Integer totalQuantityUnit;
    @Size(max = 1)
    @Column(name = "type_of_container", length = 1)
    private String typeOfContainer;
    @Column(name = "quantity_per_container", precision = 53)
    private Double quantityPerContainer;
    @Column(name = "pieces_per_container")
    private Integer piecesPerContainer;
    @Column(name = "quantity_of_container", precision = 53)
    private Double quantityOfContainer;
    @Column(name = "shortage", precision = 53)
    private Double shortage;
    @Column(name = "length_of_article")
    private Integer lengthOfArticle;
    @Size(max = 200)
    @Column(name = "print_description", length = 200)
    private String printDescription;
    @Size(max = 50)
    @Column(name = "profile_body", length = 50)
    private String profileBody;
    @Size(max = 50)
    @Column(name = "profile_gasket", length = 50)
    private String profileGasket;
    @Column(name = "profile_gasket_quantity")
    private Integer profileGasketQuantity;
    @Size(max = 15)
    @Column(name = "schufo_o", length = 15)
    private String schufoO;
    @Size(max = 15)
    @Column(name = "schufo_u", length = 15)
    private String schufoU;
    @Column(name = "finished_quantity", precision = 53)
    private Double finishedQuantity;
    @Column(name = "order_active")
    private Integer orderActive;
    @Column(name = "order_finished")
    private Short orderFinished;
    @OneToMany(mappedBy = "orderingId")
    private List<Process> processList;
    @JoinColumn(name = "article_id", referencedColumnName = "id_article")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "article")
    private Article articleId;
    @JoinColumn(name = "machine_id", referencedColumnName = "machine_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "machine")
    private Machine machineId;
    @JoinColumn(name = "tool_id", referencedColumnName = "tool_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(value = "tool")
    private Tool toolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderingId")
    @JsonProperty(value = "parts")
    private List<OrderingPartsList> orderingPartsListList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderingId")
    private List<FeedbackEntry> feedbackEntryList;

    public Ordering() {
    }

    public Ordering(Long orderingId) {
        this.orderingId = orderingId;
    }

    public Long getOrderingId() {
        return orderingId;
    }

    public void setOrderingId(Long orderingId) {
        this.orderingId = orderingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSnr() {
        return snr;
    }

    public void setSnr(Integer snr) {
        this.snr = snr;
    }

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getTotalQuantityUnit() {
        return totalQuantityUnit;
    }

    public void setTotalQuantityUnit(Integer totalQuantityUnit) {
        this.totalQuantityUnit = totalQuantityUnit;
    }

    public String getTypeOfContainer() {
        return typeOfContainer;
    }

    public void setTypeOfContainer(String typeOfContainer) {
        this.typeOfContainer = typeOfContainer;
    }

    public Double getQuantityPerContainer() {
        return quantityPerContainer;
    }

    public void setQuantityPerContainer(Double quantityPerContainer) {
        this.quantityPerContainer = quantityPerContainer;
    }

    public Integer getPiecesPerContainer() {
        return piecesPerContainer;
    }

    public void setPiecesPerContainer(Integer piecesPerContainer) {
        this.piecesPerContainer = piecesPerContainer;
    }

    public Double getQuantityOfContainer() {
        return quantityOfContainer;
    }

    public void setQuantityOfContainer(Double quantityOfContainer) {
        this.quantityOfContainer = quantityOfContainer;
    }

    public Double getShortage() {
        return shortage;
    }

    public void setShortage(Double shortage) {
        this.shortage = shortage;
    }

    public Integer getLengthOfArticle() {
        return lengthOfArticle;
    }

    public void setLengthOfArticle(Integer lengthOfArticle) {
        this.lengthOfArticle = lengthOfArticle;
    }

    public String getPrintDescription() {
        return printDescription;
    }

    public void setPrintDescription(String printDescription) {
        this.printDescription = printDescription;
    }

    public String getProfileBody() {
        return profileBody;
    }

    public void setProfileBody(String profileBody) {
        this.profileBody = profileBody;
    }

    public String getProfileGasket() {
        return profileGasket;
    }

    public void setProfileGasket(String profileGasket) {
        this.profileGasket = profileGasket;
    }

    public Integer getProfileGasketQuantity() {
        return profileGasketQuantity;
    }

    public void setProfileGasketQuantity(Integer profileGasketQuantity) {
        this.profileGasketQuantity = profileGasketQuantity;
    }

    public String getSchufoO() {
        return schufoO;
    }

    public void setSchufoO(String schufoO) {
        this.schufoO = schufoO;
    }

    public String getSchufoU() {
        return schufoU;
    }

    public void setSchufoU(String schufoU) {
        this.schufoU = schufoU;
    }

    public Double getFinishedQuantity() {
        return finishedQuantity;
    }

    public void setFinishedQuantity(Double finishedQuantity) {
        this.finishedQuantity = finishedQuantity;
    }

    public Integer getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(Integer orderActive) {
        this.orderActive = orderActive;
    }

    public Short getOrderFinished() {
        return orderFinished;
    }

    public void setOrderFinished(Short orderFinished) {
        this.orderFinished = orderFinished;
    }

    @XmlTransient
    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
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

    public List<OrderingPartsList> getOrderingPartsListList() {
        return orderingPartsListList;
    }

    public void setOrderingPartsListList(List<OrderingPartsList> orderingPartsListList) {
        this.orderingPartsListList = orderingPartsListList;
    }

    public List<FeedbackEntry> getFeedbackEntryList() {
        return feedbackEntryList;
    }

    public void setFeedbackEntryList(List<FeedbackEntry> feedbackEntryList) {
        this.feedbackEntryList = feedbackEntryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderingId != null ? orderingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.orderingId == null && other.orderingId != null) || (this.orderingId != null && !this.orderingId.equals(other.orderingId))) {
            return false;
        }
        return true;
    }

    public boolean isSame(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordering that = (Ordering) o;

        return orderingId.equals(that.orderingId) &&

                Objects.equals(snr, that.snr) &&
                Objects.equals(totalQuantity, that.totalQuantity) &&
                Objects.equals(totalQuantityUnit, that.totalQuantityUnit) &&
                Objects.equals(typeOfContainer, that.typeOfContainer) &&
                Objects.equals(quantityPerContainer, that.quantityPerContainer) &&
                Objects.equals(piecesPerContainer, that.piecesPerContainer) &&
                Objects.equals(quantityOfContainer, that.quantityOfContainer) &&
                Objects.equals(shortage, that.shortage) &&
                Objects.equals(lengthOfArticle, that.lengthOfArticle) &&
                Objects.equals(printDescription, that.printDescription) &&
                Objects.equals(profileBody, that.profileBody) &&
                Objects.equals(profileGasket, that.profileGasket) &&
                Objects.equals(profileGasketQuantity, that.profileGasketQuantity) &&
                Objects.equals(schufoO, that.schufoO) &&
                Objects.equals(schufoU, that.schufoU);
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "orderingId=" + orderingId +
                ", date=" + date +
                ", articleId=" + articleId +
                ", machineId=" + machineId +
                ", toolId=" + toolId +
                ", orderingPartsListList=" + orderingPartsListList +
                '}';
    }
}
