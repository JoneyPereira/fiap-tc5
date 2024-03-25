# Tech Challenge 

Bem-vindo(a) a documentação oficial desenvolvida para este Tech Challenge.

## Link do Repositório

- [Tech Challenge](https://github.com/JoneyPereira/fiap-tc5)

## Tecnologias e Ferramentas
- Java 17 e 21
- Maven
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger
- Spring Web
- Postman
- IntelliJ
- Git
- GitHub
- Docker

## Como inicar o projeto

Para inicar o projeto, utilize o `maven`. Caso não tenha o Maven instalado, você pode utilizar o wrapper que
acompanha o projeto. Neste caso, entre na pasta raiz de cada Serviço e utilize o comando `./mvnw`.
É necessário estar com `Docker` rodando para conexão com banco de dados.

| Comando                  | Descrição                       | Requisitos                  |
|--------------------------|---------------------------------|-----------------------------|
| `docker-compose up -d`   | Subir os serviços da aplicação  | Docker instalado na máquina |
| `./mvnw spring-boot:run` | Roda a aplicação localmente     | Postgres rodando            |

## Diagramas
![arquitetura](arquitetura.png)

## Postman Collection
Tc-5.postman_collection.json

--------------------------------------------------------------------------------------------
### tc5-login-users

| Método | Url               | Descrição                 |
|--------|-------------------|---------------------------|
| POST   | /auth/register    | Registra um novo usuario  |
| POST   | /auth/login       | Faz o login de um usuario |
| GET    | /user/all         | Busca todos os usuarios   |
| PUT    | /user/update/{id} | Atualiza um usuario       |
| DELETE | /user/delete/{id} | Apaga um usuario          |

### Exemplos de entrada

##### <a>POST - /auth/register</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl -X 'POST' \
  'http://localhost:8080/auth/register' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "login": "teste-3",
  "password": "senha123",
  "role": "ADMIN"
}'
```
##### <a>POST - /auth/login</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl -X 'POST' \
  'http://localhost:8080/auth/login' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "login": "teste-3",
  "password": "senha123"
}'
```
##### <a>GET - /users/all</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8080/users/all' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzE4Mjh9.yDxXasb18nTaGLGuM--nYoo0zejTOWXu5rGrx8l5ljE'
```
##### <a>PUT - /users/update/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'http://localhost:8080/users/update/3' \
--header 'Content-Type: application/javascript' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzI1NTV9.1iR0XSLbnZZEWDV_l202q_ltyXYg4dDmEMIGC1jg9Ig' \
--data '{
    "role": "USER"
}'
```
##### <a>DELETE - /users/delete/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request DELETE 'http://localhost:8080/users/delete/4' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzI1NTV9.1iR0XSLbnZZEWDV_l202q_ltyXYg4dDmEMIGC1jg9Ig'
```
--------------------------------------------------------------------------------------------
### tc5-api-products

| Método | Url              | Descrição                            |
|--------|------------------|--------------------------------------|
| GET    | /products        | Busca todos os produto               |
| GET    | /products/{uuid} | Busca produto por uuid               |
| POST   | /products        | Cria um novo produto                 |
| PUT    | /products/{uuid} | Atualiza um produto                  |
| DELETE | /products/{uuid} | Apaga um produto                     |
| GET    | /stock           | Busca todos os produtos no estoque   |
| GET    | /stock/{uuid}    | Busca um produto no estoque          |
| POST   | /stock/input     | Dar entrada de um produto no estoque |
| POST   | /stock/output    | Faz a saida de um produto no estoque |

### Exemplos de entrada

##### <a>GET - /products</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/products' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzYyNTF9.F1ko8-ng22rLUCwvObA-PckD3PmNzc6-w3X8MG0ctwc'
```

##### <a>GET - /products/{uuid}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/products/a26862f4-4ed9-4768-b2ac-7411942bd96a' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzYyNTF9.F1ko8-ng22rLUCwvObA-PckD3PmNzc6-w3X8MG0ctwc'
```

##### <a>POST - /products</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/products' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzYyNTF9.F1ko8-ng22rLUCwvObA-PckD3PmNzc6-w3X8MG0ctwc' \
--data '{
    "name": "Agua 1L",
    "price": 2.0,
    "description": "Agua mineral fonte São Sebastião de 1 litros.",
    "imageUri": "https://github.com/devsuperior/sds2/blob/master/assets/pizza_moda.jpg"
}'
```
##### <a>PUT - /produts/{uuid}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'http://localhost:8081/products/9e89dfd9-8698-4337-b0db-98c05a36006c' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzY0NzF9.KnlS3rh6IXGOwqv6bqUwzDsJytuE3Kfzrf2Ud5X4IeY' \
--data '{
    "name": "Agua 1L",
    "price": 3.0,
    "description": "Agua mineral fonte São Sebastião de 1 litros.",
    "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg"
}'
```
##### <a>DELETE - /products{uuid}</a> 
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request DELETE 'http://localhost:8081/products/672fd827-2ec8-45ba-a097-a54a653d9d13' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzY0NzF9.KnlS3rh6IXGOwqv6bqUwzDsJytuE3Kfzrf2Ud5X4IeY'
```
##### <a>GET - /stock</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/stock' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzY2Mzh9.HbRelwLPVPTTar2E7Yt3yNRHPHweAdCDM72_WJd945w'
```
##### <a>GET - /stock/{uuid}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/stock/c383ea7e-89f3-45c9-bab9-5b59d9c2d684' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzY2Mzh9.HbRelwLPVPTTar2E7Yt3yNRHPHweAdCDM72_WJd945w'
```
##### <a>POST - /stock/input</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/stock/input' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzY2Mzh9.HbRelwLPVPTTar2E7Yt3yNRHPHweAdCDM72_WJd945w' \
--data '{
    "id_product": "c383ea7e-89f3-45c9-bab9-5b59d9c2d684",
    "amount_stock": 10
}'
```
##### <a>POST - /stock/output</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8081/stock/output' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzY2Mzh9.HbRelwLPVPTTar2E7Yt3yNRHPHweAdCDM72_WJd945w' \
--data '{
    "id_product": "c383ea7e-89f3-45c9-bab9-5b59d9c2d684",
    "amount_stock": 2
}'
```
--------------------------------------------------------------------------------------------
### tc5-api-carts

| Método | Url             | Descrição                                                 |
|--------|-----------------|-----------------------------------------------------------|
| GET    | /orders         | Busca todos os pedidos pendentes                          |
| GET    | /orders/{uuid}  | Busca um pedido por uuid                                  |
| POST   | /orders         | Criar um pedido                                           |
| POST   | /cart/product/1 | Adiciona um produto e a quantidade ao carrinho de compras |

### Exemplos de entrada

##### <a>GET - /orders</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8082/orders' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzcyMTR9.KlberqDZIq76ZOx56vG2OJkmd8WBrnr4Jr2pzhaEWps'
```
##### <a>GET - /orders/{uuid}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8082/orders/9c6a57b7-4915-4fb9-8a33-161f9c6c04a4' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzcyMTR9.KlberqDZIq76ZOx56vG2OJkmd8WBrnr4Jr2pzhaEWps'
```
##### <a>POST - /orders</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'http://localhost:8082/orders' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3RlLTMiLCJpZCI6MywidXNlciI6InRlc3RlLTMiLCJleHAiOjE3MTExMzcyMTR9.KlberqDZIq76ZOx56vG2OJkmd8WBrnr4Jr2pzhaEWps' \
--data '{
   "products":[
      {
         "id_product":"d345c67d-2374-4daf-94cc-d8b4dacfd300"
      },
      {
         "id_product":"f629d5a3-b0f8-418a-9aca-0c007b7e7ea4"
      }
   ]
}'
```
##### <a>POST - /carts/product/{uuid}/1</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request POST 'http://localhost:8082/carts/product/f629d5a3-b0f8-418a-9aca-0c007b7e7ea4/5' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6IlRlc3RlLTIiLCJpZCI6MiwidXNlciI6IlRlc3RlLTIiLCJleHAiOjE3MTEwNTE5MjV9.D9RcCVnYsJ771SKagBhYypARMnQhRFzd1MEIqrIikFI'
```
--------------------------------------------------------------------------------------------
### tc5-payments

| Método | Url                   | Descrição                        |
|--------|-----------------------|----------------------------------|
| PUT    | /payments/{uuid}/paid | Efetuar o pagamento de um pedido |

### Exemplos de entrada

##### <a>PUT - /payments/{uuid}/paid</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'http://localhost:8083/payments/3dd58300-a79a-4e07-8a81-33db015d1762/paid' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6IlRlc3RlLTIiLCJpZCI6MiwidXNlciI6IlRlc3RlLTIiLCJleHAiOjE3MTEwNTE5MjV9.D9RcCVnYsJ771SKagBhYypARMnQhRFzd1MEIqrIikFI'
```