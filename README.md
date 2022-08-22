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


# NOTE
This is not supposed to be the final project unless time is critical these days with my normal work and this project need to be fine-tuned with
adding logging, pulling out configurations, adding unit testing and commenting on some methods. Also, I could not manage to understand clearly the last functional requirement adding periodic task to check battery information of drones.
But anyway I tried to add technological knowledge in the programming to demostrate my experience, knowledge and the approach.

This exact scenario is pretty applicable with kafka streaming to handle flawless events from devices. but need more time to research before moving on.
Application is buildable and runnable using executable jar or docker. 



