# Objetivo do Projeto

Esta é uma aplicação ficticia para aprofundar os estudos de API's e possibilitar integrações com fronts e testes automatizados.

## Funcionalidades

A aplicação foi desenvolvida com o framework SpringBoot e implementa os seguintes verbos Http:
* `GET` - Buscar todos os carros
* `POST` - Criar novo carro
* `GET` - Buscar carro específico
* `PUT` - Atualizar carro
* `DELETE` - Deletar Carro

## Estrutura do projeto

Este projeto possui a estrutura básica de pastas de um projeto Java:
* `src/main/java`
* `src/test/java`

## Como executar a aplicação

Há duas formas de executa-la.

#### Via linha de comando

Dentro de sua IDE, ou através do Prompt de Comando ou Terminal, você deverá:
* navegar até a pasta `cd api-carros`
* executar o comando `mvn spring-boot:run`

Para parar a execução da aplicação, pressione `CTRL + C`

#### Através de uma classe

Você pode abrir a classe principal de execução.
* no projeto vá até o diretório `api-carros`
* Abra a classe `ApiCarrosApplication.java` no diretório `src/main/java/com/lusa/apicarros`

Controle, através da sua IDE, a execução e termino de execução da classe.

## Como acessar a aplicação

A aplicação é uma API, logo não terá interface gráfica.

A URL inicial da aplicação é [http://localhost:8089](http://localhost:8089).

## Como acessar a Documentação da Aplicação

Foi implementado a documentação Open-API nesta aplicação, disponível em:

Swagger: [http://localhost:8089/swagger-ui.html](http://localhost:8089/swagger-ui.html).



