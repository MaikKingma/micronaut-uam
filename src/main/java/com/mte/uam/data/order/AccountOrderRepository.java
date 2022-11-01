package com.mte.uam.data.order;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

/**
 * @author Maik Kingma
 */

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AccountOrderRepository extends CrudRepository<AccountOrderEntity, String> {
}
