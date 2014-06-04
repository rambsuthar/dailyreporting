package com.gsli.dr.domain.generic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class GenericEntity
  implements Serializable
{
  private static final long serialVersionUID = -1058457290976565669L;
  private Date createdDate;
  private Date updatedDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="CREATED_DATE", insertable=true, updatable=false)
  public Date getCreatedDate()
  {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="MODIFIED_DATE", insertable=true, updatable=true)
  public Date getUpdatedDate() {
    return this.updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }


  @PrePersist
  void onCreate() {
    setCreatedDate(new Date());
    setUpdatedDate(new Date());
  }

  @PreUpdate
  void onPersist() {
    setUpdatedDate(new Date());
  }
}