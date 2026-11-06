/**
 * Módulo Colaborador (feature package, estilo hexagonal).
 *
 * <pre>
 * colaborador/
 *  ├── domain/                  regras de negócio puras (SEM Spring, SEM JPA)
 *  ├── application/             casos de uso + portas (interfaces)
 *  └── adapter/
 *       ├── in/web/             controllers REST + DTOs (request/response)
 *       └── out/persistence/    entidades JPA + repositories Spring Data
 * </pre>
 *
 * Regra de dependência: adapter -> application -> domain. O domínio não conhece ninguém.
 *
 * TODO (Joanice): ver a seção "Sua parte" no README.
 */
package io.github.srtapoe.payrollevents.colaborador;
