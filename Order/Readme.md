# Order

Idea: grab a document and send via email.

Document: XML file.(src/main/resources/order1.xml)

# Installation and running

- install features and bundle
  ```yaml
  feature:repo-add camel latest-version-of-camel
  feature:install camel-blueprint camel-mail camel-velocity camel-stream
  install -s mvn:org.abondar.experimental.order/Orde
  ```

- Run a dummy smtp server on localhost
E.G sudo python3 -m smtpd -n -c DebuggingServer localhost:25

- Create a directory named ordersin in karaf directory and put there order1.xml from resources

- After these steps you will see an order in karaf console and in console where smtp server is started.

