# Person Service demo

Tutorial how to creat Apache CXF based service.
This time we use blueprint manually

TODO: replace xmls with java code 

# Installation and running

- install
  ```yaml
  feature:repo-add cxf
  feature:install http cxf cxf-jaxws http-whiteboard
  install -s mvn:org.abondar.experimental.personservice/personservice-model/
  install -s mvn:org.abondar.experimental.personservice/personservice-server/
  install -s mvn:org.abondar.experimental.personservice/personservice-webui/
  ```
- run
localhost:8181/cxf/persoservice - REST API
localhost:8181/personserviceui - UI

- ps
Sometimes there are issues with importing jaxrs.ws so after install start each bundle manually
