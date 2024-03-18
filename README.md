# CRUD com JDBC usando Spring Boot

Este é um projeto de exemplo que demonstra como realizar operações CRUD (Create, Read, Update, Delete) em um banco de dados utilizando JDBC (Java Database Connectivity) com Spring Boot.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JDBC
- Maven

## Configuração do Banco de Dados

Antes de executar a aplicação, é necessário configurar o banco de dados. Por padrão, este projeto utiliza o banco de dados H2 para facilitar a configuração e execução.

Para alterar as configurações do banco de dados, edite o arquivo `application.properties` localizado no diretório `src/main/resources`. Você pode modificar as configurações conforme necessário para se conectar ao seu banco de dados preferido.

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## Licença

Este projeto é distribuído sob a licença [MIT](https://opensource.org/licenses/MIT). Sinta-se livre para utilizar e modificar conforme necessário.

--- 
