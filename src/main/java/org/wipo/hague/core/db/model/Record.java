package org.wipo.hague.core.db.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_record")
public class Record implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1319496337421000685L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String type;
  private String username;

  @OneToMany(mappedBy = "record")
  @JsonManagedReference
  private List<Document> documents;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<Document> getDocuments() {
    return documents;
  }

  public void setDocuments(List<Document> documents) {
    this.documents = documents;
  }

  @Override
  public String toString() {
    return "Record [id=" + id + ", type=" + type + ", username=" + username + ", documents=" + documents + "]";
  }

}
