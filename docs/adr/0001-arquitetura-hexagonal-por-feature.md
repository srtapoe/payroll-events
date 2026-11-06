# ADR 0001: Arquitetura hexagonal organizada por feature

- **Status:** aceito
- **Data:** 2026-11-05

## Contexto
O projeto vai crescer com mensageria (SQS/SNS, Kafka), segurança e observabilidade.
Queremos trocar a infraestrutura (ex.: SQS ↔ Kafka) sem reescrever regra de negócio.

## Decisão
Organizar o código por feature (`colaborador/`, depois `ferias/`, `consignado/`) e, dentro de cada uma,
em camadas hexagonais: `domain` → `application` (casos de uso e portas) → `adapter` (web, persistência, mensageria).

## Consequências
- (+) Domínio testável sem Spring e sem banco.
- (+) Trocar o publicador de eventos = nova implementação da porta, sem mexer no caso de uso.
- (−) Mais classes e mapeamentos (entity ↔ domínio ↔ DTO) do que um CRUD em camadas simples.
