
# Desafio-basico-be

**A ideia do desafio é testar não só o conhecimento técnico, mas também a qualidade do código.**


## Criar aplicação JAVA utilizando SpringBoot

**Requisitos:**
- Java8+
- Testes Unitarios
- Maven/Gradle
- Git
- MongoDB


*Não há restrições de uso de frameworks/ferramentas.*


### Criar um serviço simples de cadastro e busca de usuario com 2 endpoints:



#### Criar Endpoint de cadastro de usuario com os seguintes dados de entrada:
	- Nome
	- Data Nascimento
	- CEP
	- Documento


**O Serviço deve obrigatoriamente utilizar uma api para preencher os dados de endereço com o CEP:**
	
- **https://viacep.com.br/**

Obs: De preferencia ao uso com JSON


**Regras**:
1. Caso CEP seja inválido deve retornar um erro amigavel.

2. Data de nascimento deve ter o padrão dd/MM/YYYY.

3. Caso tudo esteja correto deve ser armazenado no banco de dados os seguintes dados:
	- Nome do usuario
	- Idade
	- Cidade
	- Bairro
	- Estado
	- Documento


### Criar endpoint de busca de usuario pelo documento:

**Regras**:

 1. Caso documento invalido retornar um erro amigavel.

 2. Caso tudo esteja correto deve-se retornar os seguintes dados do usuario:
	- Nome do usuario
	- Idade
	- Cidade
	- Bairro
	- Estado
	- Documento



#### OBS:
**Criar uma documentação descrevendo como rodar o projeto.**


