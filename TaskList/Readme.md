# Tasklist Demo.

Basic web app consiting of 4 bundles:
- UI
- Features(contains features.xml for combining bundles)
- Model(data model)
- Persistence(layer for saving data(e.g to db))

# Installation and running

```
feature:repo-add mvn:org.abondar.experimental.tasklist/tasklist-features/1.0.0-SNAPSHOT/xml
feature:install tasklist
feature:install tasklist-bundlename(e.g tasklist-ui)

localhost:8181/tasklist
```
