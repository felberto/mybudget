# MyBudget Docker

##### Run docker image
sudo docker run -d --env MYBUDGET_DB_URL="DB_URL" --env MYBUDGET_DB_USERNAME="DB_USERNAME" --env MYBUDGET_DB_PASSWORD="DB_PASSWORD" -p 8080:8080 felberto/mybudget:VERSION

If the database is installed locally, the db url must contain the ip address of the host instead of localhost, otherwise docker cannot connect to the database.