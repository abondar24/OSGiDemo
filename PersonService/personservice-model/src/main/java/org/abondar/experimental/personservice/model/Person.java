package org.abondar.experimental.personservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    String id;
    String name;
    String url;

    public Person(){}

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
