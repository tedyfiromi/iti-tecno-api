# iti-tecno-api - Validação de Senha

Este projeto realiza a validação de senhas utilizando por base um modo configurável persistido. Foram criados dois serviços, sendo eles 
(Configure) e (Valid). O (Configure), serve para gravar o padrão melhor desejado e o segundo (Valid) fará a validação
da senha digitada respeitando sempre o último registro ordenado por data e hora.

## Passos Iniciais

O projeto está disponível no repositório [iti-tecno-api](https://github.com/tedyfiromi/iti-tecno-api.git)
Ao clonar o projeto, basta executar a aplicação através da sua IDE escolhida. O profile no maven virá configurado 
como default (prod), o qual apontará para uma base de dados MongoDb Cloud. Se preferir executar localmente, 
deverá instalar o mondodb local e mudar o profile ativo para (dev) no arquivo de propriedade (application.properties)
Ex.: [spring.profiles.active=prod] para [spring.profiles.active=dev]

### Pré-requisitos

Java versão 11
Spring Tools Suite ou Intellij
MongoDb Database (Para base de dados local)
MongoDb Atlas (Criar a conta)
MongoDb Compass (Modelagem de banco de dados)
Postman (Para acessar e manipular os serviços. Como foi utilizado Swagger2 para documentação, então também
 é possível testa-lo utilizando-o.

### Testes criados

Foram criados 12 testes para os serviçoes de validação de senha, sao eles:

* testMinLengthFalse - Testa falso a quantidade minima de caracteres;
* testMinLengthTrue - Testa verdade a quantidade mínima de caracteres;
* testMaxLengthFalse - Testa falso a quantidade máxima de caracteres;
* testMaxLengthTrue - Testa verdade a quantidade máxima de caracteres;
* testUpperCaseFalse - Testa falso a existência de caracteres maiúsculo;
* testUpperCaseTrue - Testa verdade a existencia de caracter maiúsculo; 
* testLowerCaseFalse - Testa falso a existência de caracteres minúsculo;
* testLowerCaseTrue - Testa verdade a existencia de caracter minúsculo; 
* testDigitTrue - Testa verdade a existencia de dígito;
* testDigitFalse - Testa falso da existência de dígito;
* testSpecialTrue - Testa verdade a existência de caracter especial;
* testSpecialFalse - Testa falso existência de caracter especial;


## Construído Com

* [Java11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - suite de desenvolvimento Java versão 11
* [Maven](https://maven.apache.org) - Gerenciamento de Dependencias;
* [Swagger2](https://https://swagger.io) - Documentação de serviços;
* [Lombok](https://projectlombok.org) - Geração de getters e setters, builders;
* [MongoDb Atlas](https://mongodb.com) - Criar conta ou manipular base de dados;
* [MongoDb Compass](https://mongodb.com) - Gerenciamento melhor manipulação da base de dados;
* [Postman](https://www.postman.com) - Teste de serviços e vizualização de resultados;

## Versionamento

A última versão disponível no repositório [iti-tecno-api](https://github.com/tedyfiromi/iti-tecno-api.git)

## Autor

* **Tedy Firomi** - *Um dos Primeiros projetos do Itau Iti* - 

