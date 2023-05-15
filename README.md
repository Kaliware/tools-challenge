<h1 align="center">:file_cabinet: Tools Challenge</h1>

## :memo: Descrição
Este desafio tem como objetivo propor um cenário de problema para ser resolvido de acordo com os requisitos apresentados. O foco está em demonstrar suas habilidades de desenvolvimento, aplicando conceitos como orientação a objetos, tratamento de exceções, validação de dados, testes unitários e uso do Git para versionamento.

## :wrench: Tecnologias utilizadas
* Java;
* Spring;
* Bean Validation;

## :rocket: Rodando o projeto
Para rodar o repositório é necessário clonar o mesmo, dar o seguinte comando para compilar o projeto:
```
mvn clean install
```
Após fazer isso basta entrar na pasta target criada após compilar o projeto e localizar o arquivo `tools.challenge.jar` e dar o seguinte comando:
```
java -jar tools-challenge.jar
```
Certifique-se de ter o Maven e o Java 17 instalados em seu ambiente de desenvolvimento.

Agora você pode realizar pagamentos chamando os endpoint fornecidos pela API

## Documentação do Endpoint: Realizar Pagamento
O endpoint "Realizar Pagamento" permite que os usuários da API efetuem pagamentos através do método `POST` recurso: /payments

### Requisição

A requisição deve ser feita com um payload JSON contendo as informações do pagamento. O formato esperado do payload é o seguinte:

```json
{
  "transacao": {
    "cartao": "55190832202274767",
    "id": "1",
    "descricao": {
      "valor": "50.00",
      "dataHora": "01/12/2021 18:30:00",
      "estabelecimento": "PetShop Mundo Cão"
    },
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    }
  }
}
```
### Resposta
A resposta da API será um JSON contendo as informações atualizadas da transação de pagamento. O formato de resposta é o seguinte:
```json
{
  "transacao": {
    "id": "1",
    "cartao": "55190832202274767",
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    },
    "descricao": {
      "nsu": "20230515012720107813",
      "status": "AUTORIZADO",
      "valor": "50.00",
      "dataHora": "01/12/2021 18:30:00",
      "estabelecimento": "PetShop Mundo Cão",
      "codigoAutorizacao": "96917577"
    }
  }
}

```



## Documentação do Endpoint: Realizar Estorno
O endpoint "Realizar Estorno" permite que os usuários da API realizem o estorno de um pagamento previamente realizado através do método `POST` e recurso: /payments/cancel/{id}

### Resposta
A resposta da API será um JSON contendo as informações atualizadas da transação de pagamento. O formato de resposta é o seguinte:
```json
{
  "transacao": {
    "id": "1",
    "cartao": "55190832202274767",
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    },
    "descricao": {
      "nsu": "20230515012720107813",
      "status": "CANCELADO",
      "valor": "50.00",
      "dataHora": "01/12/2021 18:30:00",
      "estabelecimento": "PetShop Mundo Cão",
      "codigoAutorizacao": "96917577"
    }
  }
}

```

## Documentação do Endpoint: Buscar por ID
O endpoint "Buscar por ID" permite que os usuários da API busquem o pagamento ou estorno através do método `GET` e recurso: /payments/{id}

### Resposta
A resposta da API será um JSON contendo as informações da transação de pagamento ou estorno. O formato de resposta é o seguinte:
```json
{
  "transacao": {
    "id": "1",
    "cartao": "55190832202274767",
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    },
    "descricao": {
      "nsu": "20230515012720107813",
      "status": "AUTORIZADO",
      "valor": "50.00",
      "dataHora": "01/12/2021 18:30:00",
      "estabelecimento": "PetShop Mundo Cão",
      "codigoAutorizacao": "96917577"
    }
  }
}

```

## Documentação do Endpoint: Buscar todas as transações
O endpoint "Buscar todas as transações" permite que os usuários da API busquem todos os pagamentos e estornos através do método `GET` e recurso: /payments

### Resposta
A resposta da API será um JSON contendo as informações das transação de pagamento. O formato de resposta é o seguinte:
```json
[
  {
    "transacao": {
      "id": "10002356809840531",
      "cartao": "55190832202274766",
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      },
      "descricao": {
        "nsu": "20230515012740139824",
        "status": "NEGADO",
        "valor": "50.00",
        "dataHora": "01/12/2021 18:30:00",
        "estabelecimento": "PetShop Mundo Cão",
        "codigoAutorizacao": "58375493"
      }
    }
  },
  {
    "transacao": {
      "id": "10002356809840530",
      "cartao": "55190832202274767",
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      },
      "descricao": {
        "nsu": "20230515012720107813",
        "status": "AUTORIZADO",
        "valor": "50.00",
        "dataHora": "01/12/2021 18:30:00",
        "estabelecimento": "PetShop Mundo Cão",
        "codigoAutorizacao": "96917577"
      }
    }
  },
  {
    "transacao": {
      "id": "1000235680984053~0",
      "cartao": "55190832202274767",
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      },
      "descricao": {
        "nsu": "20230515012658579038",
        "status": "AUTORIZADO",
        "valor": "50.00",
        "dataHora": "01/12/2021 18:30:00",
        "estabelecimento": "PetShop Mundo Cão",
        "codigoAutorizacao": "29319990"
      }
    }
  }
]
```















