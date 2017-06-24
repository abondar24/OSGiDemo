# Tasklist Demo.

Basic web app consiting of 4 bundles:

- Commands(shell access)
- Features(contains features.xml for combining bundles)
- Model(data model)
- Persistence(layer for saving data(e.g to db))

# Installation and running

Install 
- add maven repo 
feature:repo-add mvn:org.abondar.experimental.tasklist/tasklist-features/1.0.0-SNAPSHOT/xml

- install the app 
feature:install tasklist

or if you want to install just one of many bundles do:
feature:install tasklist-bundlename(e.g tasklist-ui)

- run the app
localhost:8181/tasklist
