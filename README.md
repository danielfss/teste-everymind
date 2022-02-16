
# teste-everymind
## API para cadastrar usuários

## Cenário
A empresa Oliveira Trade solicitou uma API backend para cadastramento de usuários.

## Principais dependências
Spring Web, Spring Data JPA, Spring Security, PostgreSQL Driver e Spring DevTools.

## Rotas
### Cadastrar usuário
Através de um REST Client como Postman, Insomnia ou uma aplicação frontend que faça consumo da API, é possível realizar o cadastro do usuário.

#### REQUEST

    POST /sign-up

#### RESPONSE

    {
        "username": "fulano",
        "password": 12345678,
        "fullName": "Fulano Fonseca",
        "cpf": "12563262089",
        "email": "fulano@hotmail.com",
        "birthDate": "2000-01-01"
    }
    
### (Rota extra) Listar usuários
OBS: Para acessá-lá precisa estar logado no sistema, ao tentar acessar a página pelo navegador será redirecionado para a tela de login do Spring Security e basta preencher com seu username e password cadastrado.

#### REQUEST
    GET /user
    
## Como rodar a aplicação?
- Importar como projeto Maven.
- Pode ser iniciado pela IDE Eclipse ou IntelliJ.
- Porta utilizada: 8080
