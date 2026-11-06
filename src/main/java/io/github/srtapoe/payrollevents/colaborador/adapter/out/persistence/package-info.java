/**
 * TODO (Joanice): persistência
 *  - ColaboradorJpaEntity (@Entity, @Table("colaborador"))
 *  - ColaboradorJpaRepository extends JpaRepository
 *  - ColaboradorPersistenceAdapter implements ColaboradorRepositoryPort (converte entity <-> domínio)
 *  - migration V1__create_colaborador.sql em src/main/resources/db/migration
 *
 * Lembre: ddl-auto=validate. Quem cria tabela é o Flyway, nunca o Hibernate.
 */
package io.github.srtapoe.payrollevents.colaborador.adapter.out.persistence;
