1. init roles table
 
   INSERT INTO roles(id, name) VALUES (1, 'ADMIN');

   INSERT INTO roles(id, name) VALUES (2, 'USER');

2. docker build (with springboot version 3 no need Dockerfile but for this we use it just for demo)

   mvn spring-boot:build-image

   or

   docker build -t spring-boot-3-security-jwt:1.0.0 .

3. run image locally

   docker run --tty --publish 8080:8080 spring-boot-3-security-jwt:1.0.0

4. stop container 

    docker ps -a

    docker stop container_id

5. create tag

   docker tag spring-boot-3-security-jwt:1.0.0 spring-boot-3-security-jwt:1.0.1

6. push image to dockerhub

   docker tag spring-boot-3-security-jwt:1.0.1 adjodamawuli/spring-boot-3-security-jwt:1.0.1

   docker push adjodamawuli/spring-boot-3-security-jwt:1.0.1

