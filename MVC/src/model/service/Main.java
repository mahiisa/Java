package model.service;

import model.entity.Person;
import model.repository.PersonDA;

public class Main {
    public static void main(String[] args) throws Exception {
        // for insert
        /*Person person1 = new Person(1,"AA","BB",1000);
        PersonDA personDA = new PersonDA();
        personDA.insert(person1);
        personDA.commit();*/

        //for select
        /*PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.select();
        personDA.commit();
        for (Person p :personList){
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getFamily());
            System.out.println(p.getSalary());
        }*/

        //for delete
        /*PersonDA personDA = new PersonDA();
        personDA.delete(2);
        personDA.commit();*/

        //for update
        PersonDA personDA = new PersonDA();
        Person p2 = new Person(3, "CC","DD", 4000);
        personDA.update(p2);
        personDA.commit();


    }
}
