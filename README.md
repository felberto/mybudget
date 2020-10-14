# MyBudget

mvn clean install
-DskipTests

java -jar backend/target/backend-[VERSION].jar

mvn generate-resources -Pflyway

mvn generate-resources -Pjooq-generator

