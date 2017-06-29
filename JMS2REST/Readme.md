# JMS2REST

Idea: take a file from directory, send it to JMS Queue and from JMS queue put it to another service via its REST API

# Installation and Running

- You need to have a PersonService up and running(see readme for this demo)
- Setup a JMS broker(I used activemq)
- Install features
   ```yaml
  feature:repo-add activemq latest-version-of-activemq
  feature:repo-add camel latest-version-of-camel 
  feature:install camel-blueprint camel-jms camel-http camel-saxon activemq-broker jms
  jms:create -t activemq localhost(or ip/hostname of your broker.)
  install -s mvn:org.abondar.experimental/JMS2REST
  ```
- In karaf directory create a directory named in and put person1.xml from src/main/resources
- After you start do log:tail and see that message is ok and data put to REST. 
  You can also run localhost:8181/cxf/personservice to check that data is persisted.
