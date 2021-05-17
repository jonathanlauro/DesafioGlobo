
# Desafio-basico


## Aplicação JAVA utilizando SpringBoot

**Requisitos:**
- Java8+
- Testes Unitarios
- Maven/Gradle
- Git
- MongoDB


### Serviço simples de cadastro e busca de usuario com 2 endpoints:



#### Endpoint de cadastro de usuario com os seguintes dados de entrada:
	- Nome
	- Data Nascimento
	- CEP
	- Documento


**O Serviço utilizar uma api para preencher os dados de endereço com o CEP:**
	
- **https://viacep.com.br/**

Obs: Uso com JSON


**Etapas**:
1. Caso CEP seja inválido, retorna um erro amigavel.

2. Data de nascimento com o padrão dd/MM/YYYY.

3. Caso tudo esteja correto será armazenado no banco de dados os seguintes dados:
	- Nome do usuario
	- Idade
	- Cidade
	- Bairro
	- Estado
	- Documento


### Endpoint de busca de usuario pelo documento:

**Regras**:

 1. Caso documento invalido, retorna um erro amigavel.

 2. Caso tudo esteja correto, retorna os seguintes dados do usuario:
	- Nome do usuario
	- Idade
	- Cidade
	- Bairro
	- Estado
	- Documento



