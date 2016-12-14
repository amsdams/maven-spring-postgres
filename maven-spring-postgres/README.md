#INIT DB
createuser -P postgres
createdb -h localhost -p 5432 maven-spring-postgres
psql maven-spring-postgres
GRANT ALL PRIVILEGES ON maven-spring-postgres TO postgres
