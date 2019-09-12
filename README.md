# ControlePrograma
IFSP Birigui - Engenharia de Computação 
Programa desenvolvido na disciplina de programação orientada a eventos | 
Mysql / Maven / Hibernate 


## Requisitos
- Eclipse 4.12.0+
- Maven: 1.8
- JavaSE: 1.8

## Configurações Iniciais
/src/main/java/META-INF/`persistence.xml`

Mysql database `controle`
Mysql User `root`
Mysql Pass ` `

```kotlin
 <!--  Ip do Banco -->
          <property name="javax.persistence.jdbc.url" value="jdbc:mysql://127.0.0.1:3306/controle" />
 <!--  Usuario Banco -->
          <property name="javax.persistence.jdbc.user" value="root" />
 <!--  Senha Banco -->
          <property name="javax.persistence.jdbc.password" value="" />
 
       
```
