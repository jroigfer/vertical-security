package org.wipo.hague.core.db.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_document")
public class Document implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 7124875085760956868L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String location;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RECORD_ID")
  @JsonBackReference
  private Record record;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Record getRecord() {
    return record;
  }

  public void setRecord(Record record) {
    this.record = record;
  }

  @Override
  public String toString() {
    return "Document [id=" + id + ", name=" + name + ", location=" + location + ", record=" + record + "]";
  }

}
