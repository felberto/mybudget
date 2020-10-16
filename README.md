[![Build Status](https://travis-ci.com/felberto/mybudget.svg?branch=release)](https://travis-ci.com/felberto/mybudget)

# MyBudget
This application helps to keep an eye on the inputs and outputs, to create and manage budgets

### Components
| Component                         |                        |
|:----------------------------------|:-----------------------|
| [Backend](./backend/readme.md)    | Java/Spring Boot       |
| [Frontend](./frontend/readme.md)  | Angular                |
| [Docker](./docker/readme.md)      | Docker                 |

---

### Setup

##### Install database
Download [postgres database](https://www.postgresql.org/download/) and install

##### Initialize database
Create user and schema mybudget_appl

##### Set environment variable
set environment variables for database
- MYBUDGET_DB_URL = jdbc:postgresql://[HOST]:[PORT]/[DATABASE_NAME]
- MYBUDGET_DB_USERNAME = [USERNAME]
- MYBUDGET_DB_PASSWORD = [PASSWORD]

---

### Build and run application

##### Build application
```mvn clean install```

##### Build application without tests
```mvn clean install -DskipTests```

##### Run application
```java -jar backend/target/backend-[VERSION].jar```

After the start the following url are available  
[Swagger UI](localhost:8080/swagger-ui.html)  
[Angular GUI](localhost:8080/gui)
