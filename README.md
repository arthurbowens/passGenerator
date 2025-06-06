# PassGenerator - Spring Boot Project

Este é um projeto Spring Boot com banco de dados MySQL.

## Requisitos do Sistema

- Java 17
- Maven 3.8.x ou superior
- MySQL 8.0 ou superior
- DBeaver (recomendado para gerenciamento do banco de dados)
- Postman (para testar as APIs)
- JDK 17 (caso não tenha instalado)
- Lombok Plugin (para sua IDE)

## Versões Utilizadas

- Java: 17
- Spring Boot: 3.1.4
- Maven: 3.8.x
- MySQL: 8.0

## Configuração do Banco de Dados

### Usando DBeaver (Recomendado)

1. Instale o DBeaver Community Edition
2. Conecte ao seu servidor MySQL
3. Crie um novo banco de dados chamado `passGenerator`:
   ```sql
   CREATE DATABASE passGenerator;
   ```
4. Configure o arquivo `application.properties` com suas credenciais:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/passGenerator
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

## Configuração do Projeto

1. Clone o repositório:
   ```bash
   git clone [URL_DO_REPOSITÓRIO]
   cd passGenerator
   ```

2. Importe o projeto em sua IDE preferida (IntelliJ IDEA, Eclipse, VS Code)

3. Configure o arquivo `application.properties` com suas credenciais do banco de dados

4. Instale as dependências necessárias:
   - JDK 17: Baixe e instale do site oficial da Oracle ou use o OpenJDK
   - Lombok Plugin: Instale o plugin Lombok na sua IDE
     - IntelliJ IDEA: File > Settings > Plugins > Marketplace > Busque por "Lombok"
     
## Executando o Projeto

1. Localize a classe `PassGeneratorApplication.java` no projeto
2. Clique com o botão direito na classe ou ao lado de `public class PassGeneratorApplication`
3. Selecione "Run" ou "Run PassGeneratorApplication"
4. Se a aplicação não iniciar, verifique se:
   - O JDK 17 está instalado e configurado corretamente
   - O plugin Lombok está instalado na IDE
   - As credenciais do banco de dados estão corretas no `application.properties`

O servidor será iniciado na porta 8080 por padrão.

## Testando a Aplicação

### Testando o Banco de Dados
- Use o DBeaver para verificar se as tabelas foram criadas corretamente

### Testando as APIs
- Importe a coleção do Postman incluída no projeto
- Execute as requisições para testar os endpoints da API

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br.com.passGenerator/
│   │       ├── config/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── PassGeneratorApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

