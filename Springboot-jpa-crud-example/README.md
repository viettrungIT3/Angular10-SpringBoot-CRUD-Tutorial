## Docker to connect mysql

1. Step 1: Pull the mysql image from docker hub
docker pull mysql

2. Step 2: Create a docker network to communicate Spring boot app and Mysql databases
```
docker network create springboot-mysql-net
```
3. Step 3: Run the mysql container in the network
```
docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_USER=sa -e MYSQL_PASSWORD=12345678 -e MYSQL_DATABASE=Spring-boot-Angular-10  -p 3309:3306 -d mysql:latest
```
- `--name <nameContainer>`: is the Container name to use
- `--network <nameNetwork>`: is the Network name to use
- `-p <portChange>:<port>`: change port
- `-e <?>`: are attributes to create and use it

4. Step 4: Run "docker ps" to get CONTAINER ID
5. Step 5: Run
```
docker exec -it <CONTAINER ID> bash
mysql -u<username> -p<password>
```
eg:
```
docker exec -it eceb3610ed33 bash
mysql -usa -p12345678
```
6. Step 6: ...
- O1: "show databases;"
- O2" "show tables;"
7. Step 7: Update the application.properties file
```  
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3309/<myDB>
spring.datasource.username=<username>
spring.datasource.password=<password>
```

