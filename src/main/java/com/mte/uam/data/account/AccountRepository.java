package com.mte.uam.data.account;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

import java.util.UUID;

/**
 * @author Jan Boonen
 */

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AccountRepository extends CrudRepository<AccountEntity, UUID> {
    List<AccountEntity> findAll();
}
