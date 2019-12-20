package chapter1;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;
/*Serialization code using a simple POJO (plain old Java Object*/

public class PojoForPost {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  //  @JsonPropertyOrder({"name","id"})
    public PojoForPost(){
        this.name="Amazing";
        this.id="1234";
    }



}
