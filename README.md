# Projeto - Teste Técnico

Este projeto contém uma aplicação **Spring Boot** conectada a um banco **PostgreSQL** utilizando **Docker Compose**.

## Como executar

1. Certifique-se de ter o **Docker** e **Docker Compose** instalados.
2. Suba o banco PostgreSQL:
   ```
   docker-compose up -d
   ```
3. Depois, execute o projeto Spring Boot:
   ```
   ./mvnw spring-boot:run
   ```
   ou, se usar Gradle:
   ```
   ./gradlew bootRun
   ```

## Estrutura

- `docker-compose.yml` → configura o container do PostgreSQL.
- `src/main` → código fonte da aplicação Spring Boot.
- `application.properties` → configurações da aplicação.

## Credenciais do banco

- **User:** admin  
- **Password:** admin123  
- **Porta:** 5432

## Observação

Deixe o Docker rodando antes de iniciar o Spring.
