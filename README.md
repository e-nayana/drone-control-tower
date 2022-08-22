# Drone-control-tower
All required data and DB will be initialized during booting process of the appliation
### By executable jar
#### pre requisitions
1. installed maven
2. JDK 11

#### steps to run (run inside the project directory)
1. run 'mvn clean package'
2. you will find the folder named 'target' and it will contain executable jar file
3. then run 'java -jar target/musalasoft-drone-control-tower-0.0.1-SNAPSHOT.jar'
4. access service through localhost:8080 and use below postman collection for all endpoints.
5. postman collection for end points - https://www.getpostman.com/collections/3c297aa3f55d09bbc42b



### By docker
#### pre requisitions
1. installed docker (https://docs.docker.com/desktop/install/linux-install/)

#### steps to run (run inside the project directory)
##### find more details in https://docs.docker.com/get-started/02_our_app/
1. run 'docker build -t docker-control-tower:latest .' to build the docker image
2. docker run -dp 8080:8080 docker-control-tower:latest



