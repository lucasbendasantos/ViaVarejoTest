# Api para calcular valor de pagamento

Api para o teste backend Via Varejo:

  - Calcula a quantiade de parcelas
  - Consulta taxa selic
  - Retorna o valor de cada parcela podendo inserir no calculo a taxa selic
  
### Tecnologias usadas:
* [Java] - Utilizado como backend
* [SpringBoot] - Framework utilizado para facilitar a configuração e publicação de nossas aplicações.
* [JUnit] - Framework utilizado para testes unitários
* [Mockito] - Utilizado em testes unitários para relizar o [mock](https://pt.wikipedia.org/wiki/Objeto_Mock)
* [Maven] - Controla as dependências do projeto

### WebServices:
* Consultar a taxa [selic](https://dadosabertos.bcb.gov.br/dataset/11-taxa-de-juros---selic)

### Configuração

 ##### Definição das variáveis
Como definir uma varivável de ambiente?[(click)](https://devcontent.com.br/artigos/windows/o-que-sao-como-alterar-criar-excluir-variaveis-de-ambiente)
| Variável | Descrição |
| ------ | ------ | 
| PARCEL_TO_INTEREST | Quantidade de parcelas para inserir juros (default: 6) |
| URL_TAX_SELIC | URL que será feita a requisição para taxa selic (default: [URL](https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json)) |
| AVERAGE_SELIC | Média da taxa selic, caso o webservice esteja fora do ar (default: 0.014227)|

Você pode alterar o default das variaveis de ambiente aqui.
 ##### application.properties
 : src/main/resources

```sh
server.port=8080
server.servlet.contextPath=/viavarejo

parcel.interest=${PARCEL_TO_INTEREST:6} 
url.tax.selic=${URL_TAX_SELIC:https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json}

average.selic=${AVERAGE_SELIC:0.014227}
```

### Executando

Após executar a aplicação, estará disponível o [SWAGGER](https://swagger.io/), onde será possível consumir a API.

para acessar o swagger:
```sh
http://<HOST>:<PORTA>/viavarejo/swagger-ui.html
```
Exemplo
```sh
http://localhost:8080/viavarejo/swagger-ui.html
```

## API
#### payment-controller - Efetua o pagamento de acordo com a parcela
##### URL da API:
http://< HOST >:< PORTA >/viavarejo/api/payment

##### Body:
```sh
{
  "condicaoPagamento": {
    "qtdeParcelas": 10,
    "valorEntrada": 20
  },
  "produto": {
    "codigo": 1234,
    "nome": "Aspirador de pó",
    "valor": 100
  }
}
```

##### Response
```sh
[
  {
    "numeroParcela": 1,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 2,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 3,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 4,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 5,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 6,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 7,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 8,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 9,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  },
  {
    "numeroParcela": 10,
    "valor": 8.011381,
    "taxaJurosAoMes": 0.014227
  }
]
```
