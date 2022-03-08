<div align="center">
  <img src="https://user-images.githubusercontent.com/18688446/157254728-e1cc5ab0-7b04-4791-899f-cd86c89257dd.png" alt="Microservice Logo" /> 
  <br/> 
  <h1>MS-Email</h1>
  <h3>Exemplo de MicroService de Envio de E-mail feito em Java com Springboot</h3>
</div>

<p align="center">
    <img src="https://img.shields.io/static/v1?label=Java&message=11&color=DC143C&style=flat-square&logo=Java" alt="Java" />
    <img src="https://img.shields.io/static/v1?label=SpringBoot&message=2.6.4&color=7CFC00&style=flat-square&logo=SpringBoot" alt="SpringBoot" />
    <img src="https://img.shields.io/static/v1?label=Apache Maven&message=3.6.3&color=DC143C&style=flat-square&logo=Apache Maven" alt="Apache Maven" />
    <img src="https://img.shields.io/static/v1?label=PostgreSQL&message=14.2&color=1E90FF&style=flat-square&logo=PostgreSQL&logoColor=1E90FF" alt="PostgreSQL" />
    <img src="https://img.shields.io/static/v1?label=RabbitMQ&message=3.8.5&color=ffae00&style=flat-square&logo=RabbitMQ" alt="RabbitMQ" />

</p>

## Como usar
- Precisará criar um banco de dados com o nome `ms-email` em PostgreSQL, para isso rode o Script localizado na raiz do projeto:
  ```
  $ ./script-create-data-base.sh
  ```

- Após, execute no terminal:
  ```
  $ mvn clean install
  ```

- Entao execute a API pela IDE;

## Exemplo de uso
### Comunicação Sincrona:

> BRANCH: ``main``

Metodo: ```POST``` </br>
EndPoint: ```localhost:8080/person/create``` </br>
Body:
```json
{
    "ownerRef": "Rafael",
    "emailFrom":"****@gmail.com",
    "emailTo": "****@outlook.com",
    "subject": "Assunto Teste",
    "body": "Mensagem Teste"
}
```
Response:
```json
{
    "id": "64949215-ee6f-4c06-869a-46b97a46c015",
    "ownerRef": "Rafael",
    "emailFrom": "****@gmail.com",
    "emailTo": "****@outlook.com",
    "subject": "Assunto Teste",
    "body": "Mensagem Teste",
    "sendDate": "2022-03-08T10:15:34.77282787",
    "situation": "SENT"
}
```
</br>

### Comunicação Assíncrona:

> BRANCH: ``RabbitMQ`` <br/>
> BRANCH: ``HexArch`` (com Arquitetura Hexagonal)

1. Acesse o RabbitMQ Management </br>
2. Na fila ``ms.email`` vá na sessão ``Publish message`` </br>
3. E em ``Payload`` envie a seguinte estrutura JSON: </br>
```json
{
    "ownerRef": "Rafael",
    "emailFrom":"****@gmail.com",
    "emailTo": "****@outlook.com",
    "subject": "Assunto Teste",
    "body": "Mensagem Teste"
}
```
4. Então a mensageria será acionada e o microserviço entrará em execução

---
<p align="center">
  Desenvolvido com 💜 por <a href="https://www.linkedin.com/in/rafael-balconi/">RBalconi</a>
</p>
