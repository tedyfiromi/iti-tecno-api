# iti-tecno-api - Validação de Senha

Este projeto realiza a validação de senhas utilizando por base um de modo configurável persistido em base. Foram criados dois serviços, sendo eles 
(Configure) e (Valid). O (Configure), serve para gravar o padrão escolhido e o segundo (Valid) fará a validação
da senha digitada respeitando sempre o último padrão de senha persistido.

## Passos Iniciais

O projeto está disponível no repositorio (https://github.com/tedyfiromi/iti-tecno-api.git). Ao clonar o projeto, basta executar a aplicação através
da melhor IDE escolhida. O profile virá configurado inicialmente como (prod) o qual fará a persistencia
em uma base de dados MongoDb Cloud. Se preferir executar localmente, deverá instalar o mondodb e mudar o  
profile para (dev) no arquivo de propriedade (application.properties)

### Pré-requisitos

Java versão 11
Spring Tools Suite ou Intellij
MongoDb Database (Para base de dados local)
MongoDb Atlas (Criar a conta)
MongoDb Compass (Modelagem de banco de dados)
Postman (Para acessar os serviços, mas foi utilizado Swagger2 para documentação do serviço)

### Testes criados

Foram criados 12 testes para os serviçoes de validação de senha, sao eles:
* testMinLengthFalse
* testMinLengthTrue
* testMaxLengthFalse
* testMaxLengthTrue
* testUpperCaseFalse
* testUpperCaseTrue
* testLowerCaseFalse
* testLowerCaseTrue
* testDigitTrue
* testDigitFalse
* testSpecialTrue
* testSpecialFalse


## Construído Com

* [Java11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - suite de desenvolvimento Java versão 11
* [Maven](https://maven.apache.org/) - Gerenciamento de Dependencias
* [Swagger2](https://https://swagger.io/) - Documentação de serviços
* [MongoDb Atlas](https://https://swagger.io/) - Criar conta ou manipular base de dados
* [MongoDb Compass](https://https://swagger.io/) - Gerenciamento melhor manipulação da base de dados

## Versionamento

Fui utilizado git para versionamento. A última versão disponíve está no repositório (https://github.com/tedyfiromi/iti-tecno-api.git). 

## Autor

* **Tedy Firomi** - *Primeiro projeto Itau Iti* - [iti-tecno-api](https://github.com/tedyfiromi/iti-tecno-api.git)

