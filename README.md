# desafio-banco
Desafio de Java - Sistema Bancário

##### Para cadastrar uma pessoa:

http://localhost:8080/api/bank/v1/person

O Json enviado deve seguir os seguintes exemplos: 

Pessoa Física:
>{
>	"type": "PF",
>	"name": "Teste PF",
>	"cpf": "70433960000"
>}

Para gerar CPF's válidos pode ser utilizado: https://www.4devs.com.br/gerador_de_cpf 

Pessoa Jurídica:
>{
>	"type": "PJ",
>	"name": "Teste PJ",
>	"cnpj": "71961822000187"
>}

Para gerar CNPJ'S válidos pode ser utilizado: https://www.4devs.com.br/gerador_de_cnpj


##### Para buscar pessoas:

http://localhost:8080/api/bank/v1/persons

Exemplo de Response: 
>[
>    {
>        "id": 1,
>        "name": "Teste PF",
>        "score": 6,
>        "account": {
>            "type": "C",
>            "id": 1,
>            "account": "000001",
>            "agency": "0001",
>            "overdraftLimit": 2000.0,
>            "creditCardLimit": 2000.0
>        },
>        "cpf": "70433960000",
>        "type": "PF"
>    }
>]

##### Para buscar contas: 

http://localhost:8080/api/bank/v1/accounts

Exemplo de Response:

>[
>    {
>        "id": 1,
>        "account": "000001",
>        "agency": "0001",
>        "overdraftLimit": 2000.0,
>        "creditCardLimit": 2000.0
>    }
>]