# tc5-api-cart

API desenvolvida para gestão do carrinho de compras.

## Workflow

![modelo-relacional](src/main/resources/modelo-relacional.png)

## Como rodar esta aplicação springboot

1° - No terminal, rode os seguintes comandos (de preferência na mesma ordem):

```
docker network create redelocal --driver=bridge
docker run --name carts -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=api_carts_db --network redelocal -p 5434:5432 -d postgres
```

2° - Insira essas variáveis de ambiente na aplicação, basta copiar e colar:

```
SPRING_SERVER_PORT=8082
SPRING_DATA_SOURCE_URL=jdbc:postgresql://localhost:5434/api_carts_db
SPRING_DATA_SOURCE_USERNAME=admin
SPRING_DATA_SOURCE_PASSWORD=admin
SPRING_JWT_SECRET=YmF0bWFuIGJhdG1hbiBiYXRtYW4=
SPRING_URL_PRODUCT=http://localhost:8081
```

> **_NOTA:_**  Ao rodar a aplicação, para acessar o swagger da api basta acessar a seguinte url a depender da porta escolhida
> na variável SERVER_PORT. Ex: http://localhost:8082/swagger-ui/index.html#/

## Squad
Grupo 21

## Repositório

- [tc5-api-cart](https://github.com/JoneyPereira/fiap-tc5)

## Commits Guideline

Nós possuimos regras e padrões sobre como as nossas mensagens de commit devem ser formatadas. Isso nós oferece uma
melhor experiência na hora de acompaharmos o history do projeto.

Utilizamos o padrão de [conventional commits](https://www.conventionalcommits.org/), logo todos os commits neste
repositório deverão seguir essa convenção.

### Formato do Commit

Cada mensagem de commit pode conter um **header**, um **body** e um **footer**. O header possui um formato especial
que pode conter um **type**, uma **task** (task ou história do jira) e um **subject**.

```
<type>(<task>): <subject>
<body>
<footer>
```

O **type** e o **subject** são obrigatórios.

Exemplo:

`docs: change README about CICD`

### Tipos de Commits

| Tipo    | Função                                                                      |
| ------- | --------------------------------------------------------------------------- |
| _feat_  | Uma nova implementação / feature                                            |
| _build_ | Modificações que afetam as ferramentas de build                             |
| _ci_    | Modificações nos arquivos e nos scripts de configuração de CI               |
| _docs_  | Modificações em documentações e afins                                       |
| _fix_   | Correção de um bug                                                          |
| _perf_  | Modificações de código para otimizar performance                            |
| _impr_  | Modificações que não necessariamente é um fix ou nova feature               |
| _style_ | Mudanças que não modifiquem lógica (white-space, formatting, prettier, etc) |
| _test_  | Testes que foram adicionados ou corrigidos                                  |
| _chore_ | Uma modificação geral que não se enquandra em nenhum outro padrão           |