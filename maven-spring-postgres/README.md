#INIT DB

1. createuser -P postgres
2. createdb -h localhost -p 5432 maven-spring-postgres
3. psql maven-spring-postgres
4. GRANT ALL PRIVILEGES ON maven-spring-postgres TO postgres
