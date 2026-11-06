# Payroll Events API

API de **eventos de folha de pagamento** (admissão, férias, consignado) construída com Java 21 e Spring Boot,
publicando eventos em mensageria. Projeto de portfólio para estudar backend em profundidade.

> 🇺🇸 English version below.

## Stack

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 3.5, Spring Web, Spring Data JPA, Hibernate, Bean Validation |
| Banco | SQL Server 2022 + Flyway |
| Documentação | OpenAPI / Swagger UI |
| Observabilidade | Spring Boot Actuator (Datadog + CloudWatch no roadmap) |
| Infra local | Docker Compose |

## Como rodar

Pré-requisitos: JDK 21, Maven 3.9+ e Docker.

```bash
cp .env.example .env          # opcional: troque a senha
docker compose up -d          # sobe o SQL Server e cria o banco "payroll"
mvn spring-boot:run           # ou rode PayrollEventsApplication pelo IntelliJ
```

- Swagger UI: http://localhost:8080/swagger-ui.html
- Status: http://localhost:8080/api/v1/status
- Health: http://localhost:8080/actuator/health

Testes: `mvn test` (o teste atual não precisa de Docker).

## Arquitetura

Hexagonal, organizada por feature. Veja [ADR 0001](docs/adr/0001-arquitetura-hexagonal-por-feature.md).

```
src/main/java/io/github/srtapoe/payrollevents
├── colaborador/
│   ├── domain/                 regras de negócio puras
│   ├── application/            casos de uso + portas
│   └── adapter/
│       ├── in/web/             REST
│       └── out/persistence/    JPA
└── shared/
    ├── config/                 OpenAPI
    ├── exception/              erros padronizados (RFC 9457 Problem Details)
    └── web/                    endpoint de status
```

## Roadmap

- [x] Esqueleto: Spring Boot, SQL Server, Flyway, Swagger, tratamento global de erros
- [ ] Admissão de colaborador (domínio, caso de uso, REST, persistência)
- [ ] Performance: Hibernate a fundo, plano de execução e índices
- [ ] Segurança: Spring Security, OAuth2/JWT, Keycloak, OWASP
- [ ] Observabilidade: Datadog + AWS CloudWatch
- [ ] Testes de integração com Testcontainers
- [ ] Eventos em AWS SNS/SQS (LocalStack) + Outbox
- [ ] Kafka
- [ ] CI/CD com GitHub Actions
- [ ] Deploy na AWS + Kubernetes

---

## 🇺🇸 English

**Payroll Events API**: a Java 21 / Spring Boot service that manages payroll events (hiring, vacation, payroll loans)
and publishes them to message brokers. Portfolio project focused on backend engineering.

**Run locally:** `docker compose up -d` then `mvn spring-boot:run`. Swagger UI at `http://localhost:8080/swagger-ui.html`.

**Architecture:** hexagonal, feature-based packages. Errors follow RFC 9457 (Problem Details).
See the roadmap above for upcoming features (security, observability with Datadog/CloudWatch, SNS/SQS, Kafka, CI/CD, AWS).
