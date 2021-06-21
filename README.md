# Micro-service-pet
###### Projeto Back-end 
API Rest contendo operações e fluxo completo.
A aplicação esta sendo executada no Heroku, pode ser que em algum momento ela possa estar off-line.

## Tecnologias

- Java JDK 8      -> https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- Maven           -> https://maven.apache.org/
- Swagger         -> https://swagger.io/
- SpringBoot      -> https://spring.io/projects/spring-boot
- Log4j 2         -> https://logging.apache.org/log4j/2.x/
- Lombok          -> https://projectlombok.org/
- Hibernate       -> https://hibernate.org/
- Heroku-Clound   -> https://www.heroku.com/


## Serviços


| Metodo |   End-Point  						  | Descrição                                                                  |  
|--------|---------------------------------------------------------------------------------------------------------------------|
|POST    | /v1/api/petz/save                      | Cria o Cadastro do Cliente juntamente com seu(s) Pets                      |
|POST    | /v1/api/petz/save/{idCliente}/pet	  | Cria ou Atualiza o cadastro do Pet.                                        |
|GET     | /v1/api/petz/listar/{idCliente}/pets   | Obtém a informação de um Cliente e seus Pets, através do IdCliente .       | 
|GET     | /v1/api/petz/search/cliente/{celular}/ | Obtém a informação de um Cliente e seus Pets, através do número do celular |
|GET     | /v1/api/petz/listar/clientes			  | Obtém a lista de todos os clientes e seus pets. 						   |
|DELETE  | /v1/api/petz/delete/cliente/{id}       | Exclui o Cadastro do Cliente. 											   |
|DELETE  | /v1/api/petz/delete/pet/{id}           | Exclui o Cadastro do pet. 												   |
|PUT     | /v1/api/petz/update/cliente            | Atualiza o Cadastro do Cliente.											   |



## Testes:

Swagger Link:
https://petz.herokuapp.com/swagger-ui.html


 **Contato**
* leonardobarrosbhz@gmail.com