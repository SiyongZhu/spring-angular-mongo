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
Commands to setup mongoDB
```
> use angularSpring
> db.createCollection("Book")
> db.Book.find().pretty()
> db.Book.insert([
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
```
