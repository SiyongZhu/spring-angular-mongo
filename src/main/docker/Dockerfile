FROM openjdk

VOLUME /tmp
ADD maven/spring-angular-mongo-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-jar","/myapp.jar"]