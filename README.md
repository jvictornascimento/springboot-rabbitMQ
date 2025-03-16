<h1 align="center">API de Newsletter com RabbitMQ</h1>

![Badge Concluído](https://img.shields.io/static/v1?label=Status&message=Concluido&color=brightgreen&style=for-the-badge)
![Badge Java](https://img.shields.io/static/v1?label=Java&message=21&color=brightgreen&style=for-the-badge&logo=java)
![Badge Spring](https://img.shields.io/static/v1?label=SpringBoot&message=V3.4.3&color=brightgreen&style=for-the-badge&logo=SpringBoot)
![Badge Maven](https://img.shields.io/static/v1?label=Maven&message=V4.0.0&color=C71A36&style=for-the-badge&logo=apachemaven)

## Introdução

Esta API demonstra o funcionamento do RabbitMQ como sistema de mensageria para troca de mensagens entre microserviços. A solução é composta por três microserviços:

- **ms-user**: Responsável pelo gerenciamento de usuários.

- **ms-send-email**: Consumer do RabbitMQ que processa e envia emails.

- **ms-newsLetter**: Cliente OpenFeign que consulta o ms-user, publica mensagens no RabbitMQ e aciona o envio de emails diários.

A plataforma **CloudAMQP** é utilizada para o gerenciamento da instância RabbitMQ.

## Arquitetura da Solução

A API segue uma arquitetura baseada em microserviços, onde a comunicação entre os serviços ocorre via **RabbitMQ**.
````
+---------------+       +-------------------+       +-------------------+
|   ms-user    | ----> |  ms-newsLetter    | ----> |  ms-send-email    |
| (Usuarios)   |       | (Producer Rabbit) |       | (Consumer Rabbit) |
+---------------+       +-------------------+       +-------------------+
````
## Fluxo de Funcionamento

1. **ms-newsLetter** faz uma requisição para ms-user buscando todos os emails cadastrados.

2. Para cada email, ms-newsLetter publica uma mensagem no RabbitMQ.

2. **ms-send-email** consome as mensagens do RabbitMQ e envia emails para os usuários.

## Endpoints

### ms-user

**Buscar Usuário por Email**
````
GET /users?email={email}
````
**Resposta:**
````json
{
    "id": 1,
    "name": "João Silva",
    "email": "joao@email.com"
}
````
**Listar Todos os Usuários**
````
GET /users/list
````
**Resposta:**
````json
[
    {"id": 1, "name": "João Silva", "email": "joao@email.com"},
    {"id": 2, "name": "Maria Souza", "email": "maria@email.com"}
]
````
### ms-newsLetter

**Enviar Newsletter para Todos os Usuários**
````
POST /newsletter
````
Resposta: 200 OK (Os emails serão enviados de forma assíncrona pelo RabbitMQ)

### ms-send-email

**Enviar Email Manualmente**
````
POST /email
````
**Body:**
````json
{
    "emailTo": "joao@email.com",
    "subject": "Notícias Diárias",
    "text": "Aqui estão as notícias do dia..."
}
````
Resposta: 200 OK

## Configuração do RabbitMQ (CloudAMQP)

O RabbitMQ é utilizado como sistema de fila de mensagens para desacoplar o envio de emails. Os serviços se comunicam da seguinte forma:

- ms-newsLetter é um Producer, publicando mensagens na fila.

- ms-send-email é um Consumer, consumindo as mensagens e processando o envio de emails.

As mensagens publicadas seguem este formato JSON:
````json
{
    "id": 1,
    "email": "joao@email.com",
    "subject": "Notícias Diárias",
    "text": "Aqui estão as notícias do dia..."
}
````
## Conclusão

Esta API demonstra como usar o RabbitMQ para permitir a comunicação entre microserviços, garantindo um fluxo assíncrono e eficiente para envio de emails em lote. O uso do **CloudAMQP** facilita o gerenciamento da instância do RabbitMQ na nuvem.

## Tecnologias usadas:

- `Java 21`
- `Spring Boot, Spring open feign, Spring amqp, Spring JPA, Spring web, Spring validation, Spring mail`
- `RabbitMQ`
- `H2 Database`
- `Intellij`