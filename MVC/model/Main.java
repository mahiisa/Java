package model;

import model.entity.Person;
import model.repository.PersonDA;

public class Main {
    public static void main(String[] args) throws Exception{
        PersonDA personDA = new PersonDA();
        Person person = new Person(26,"RR","YY",9000);
        personDA.invokep3(person);

    }
}
