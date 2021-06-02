# JWT-Auth-With-MySql-SpringBoot[Rest API]

This Rest API App is the basic setup JWT authentication and authorization using Mysql. You can easly run using springboot IDE or any supported IDE.

# TOOLS

## IDE
You can download from [here]](https://spring.io/tools)

## Postman

Download postman for testing the application. Click [here](https://www.postman.com/downloads/)

## Mysql

Download MySql and setup the database.

### Mysql setup
Database Name: DemoDB
Table Name: User

```mysql
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `active` int DEFAULT NULL,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `roles` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

INSERT INTO `DemoDB`.`users`
(`id`,
`active`,
`username`,
`password`,
`roles`)
VALUES
(<{id: }>,
<{active: }>,
<{username: }>,
<{password: }>,
<{roles: }>);
```
Export the data from the **Database_UserTable.csv**

**Default Database port**: localhost:3306
#### Note: Refer src/main/resources/application.properties
---
# How to Run?
1. git clone https://github.com/SeeTheC/JWT-Authentication-SpringBoot.git 
2. Open "SpringToolSuite4"
3. One project "File->Open Project From File System" & select <your path>/JWT-Authentication-SpringBoot/SimpleJwtAuth
4. Run Project: Right Click on Project "SimpleJwtAuth" > Run As > Sprint Boot App

# How to Test?
1. Open Postman
2. Create WorkSpace
3. Create Collection
4. Create Request-1:
  Post Request. URl http://localhost:8080/auth
  Body JSON:
  ## Admin Role
```json
  {
    "username": "foo",
    "password": "pass"
  }
```
  ## User Role
```json
  {
    "username": "fun",
    "password": "pass"
  }
```

5. Send Request-1 by clicking on send button
  You will get response something like this
```json
  {
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE2MjIzNTYwNzEsImlhdCI6MTYyMjMyMDA3MX0.RzOb5TUHym7jDCB1-uRMCtDggq8g7V2DRwvygwDim64"
  }
```
6. Create Request-2 **ADMIN ROLE**.

   Get Request. Url http://localhost:8080/admin or http://localhost:8080/user
  
   Header: 
  
   Key as "Authorization"
  
   Value as "Bearer <your jwt token result of step 5>"
8. Send Request-2 by clicking on send button
  
   You will get response as "Hello admin" for 200 Response code
7. Create Request-3 [**User ROLE**]
   
   Get Request. Url http://localhost:8080/user
  
   Header:
  
   Key as "Authorization"
  
   Value as "Bearer <your jwt token result of step 5>"

9. Send Request-4 by clicking on send button
  
    You will get response as "Hello user" for 200 Response code
