package org.wipo.hague.core.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wipo.hague.core.db.model.Document;

@RepositoryRestResource
public interface DocumentRepository extends CrudRepository<Document, Long> {

  public Document findByName(String name);

  public Document findByRecord(Long id);

  @Query("Select r.username from Document d,Record r where r.id = d.record.id and d.id = :id")
  public String findUsernameDocument(@Param("id") long id);

}
