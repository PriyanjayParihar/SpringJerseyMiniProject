package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

    String id;
    String name;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @XmlElement
    @JsonProperty("age")
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }
    @XmlElement
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    int age;
    String address;

}
