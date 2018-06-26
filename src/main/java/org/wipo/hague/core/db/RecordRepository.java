package org.wipo.hague.core.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wipo.hague.core.db.model.Record;

@RepositoryRestResource
public interface RecordRepository extends CrudRepository<Record, Long> {

}
