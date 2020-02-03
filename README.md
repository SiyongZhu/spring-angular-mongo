# Spring Boot Mongo and Angular


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

**How to build docker image from maven**
```
mvn clean package docker:build
docker run -d -p 8080:8080 [image_name]
docker log -f [container_id]
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
