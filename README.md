# Spring Boot Mongo and Angular

**MongoDB Setup**
```
docker run -d --volume /data/db --name vc_mongo_shared alpine echo Data container
docker run -d --volumes-from vc_mongo_shared -p 27017-27019:27017-27019 --name my_mongodb mongo:4.0.4
```

**RabbitMQ Setup**
```
docker run -d --hostname sy-rabbitmq --name my_rabbit -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:3.8-management
```

**Start Centos Docker**
```
#Constantly running a centos docker container in the background
docker run -d centos tail -f /dev/null 
# ssh into the centos container
docker exec -it [container_id] bash
>yum install java
```

**Normal Development**
With mongoDB running locally, we can run springboot on localhost \
from either IDE or maven `mvn spring-boot:run`

**How to build docker image from maven**
```
#When build docker image, change datasource from localhost to my_mongodb, then
mvn clean package docker:build

#Now we can run app by connecting two containers together
docker run --name bookStore -p 8080:8080 \
--link my_mongodb:my_mongodb \
siyongdocker/springmongodocker
docker log -f [container_id]

#Or after building docker image, we can start both mongodb and microservice together
docker-compose up -d
docker-compose down
```

**MongoDB Setup**
Commands for mongoDB
```
> use angularSpring
> db.createCollection("Books")
> show collections
> db.Books.find().pretty()
> db.Books.insert([
   {
      title: 'MongoDB Overview', 
      description: 'MongoDB is no sql database',
      by: 'tutorials point',
      url: 'http://www.tutorialspoint.com',
      tags: ['mongodb', 'database', 'NoSQL'],
      likes: 100
   },	
   {
      title: 'NoSQL Database', 
      description: "NoSQL database doesn't have tables",
      by: 'tutorials point',
      url: 'http://www.tutorialspoint.com',
      tags: ['mongodb', 'database', 'NoSQL'],
      likes: 20, 
      comments: [	
         {
            user:'user1',
            message: 'My first comment',
            dateCreated: new Date(2013,11,10,2,35),
            like: 0 
         }
      ]
   }
])

> db.Books.find({title: "MongoDB Overview"});
> db.Books.find({likes: {$lt: 30}}) $gt etc...
   You can perform text search 
   We put authors and title as textIndex first
> db.Books.find({$text: { $search: "golden"}});
```


**Export/Import MongoDB data**
```
docker exec -it my_mongodb /bin/bash
```
Inside docker shell, export data 
```
mongoexport -d angularSpring -c Books -o /data/books.json --jsonArray
```
Copy data out from docker container
```
docker cp <containerId>:/data/books.json /host/path/target
```

Import follow the same process, but using `mongoimport`
```
mongoimport --d angularSpring -c Books --file books.json --jsonArray
```

To package the web app
```
cd path/to/spring-angular-mongo
mvn clean install
mvn spring-boot:run
java -jar target/spring-angular-mongo-0.0.1-SANPSHOT.jar

```


