package model.entity;

public class Person {
    public  long id;
    public String name;
    public String family;
    public long salary;

    public Person(){};
    public Person (long id , String name , String family, long salary){
        this.id = id;
        this.name = name;
        this.family = family;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }
}
