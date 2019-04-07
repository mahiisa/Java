package model.repository;
import model.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDA {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "...", "...");
        connection.setAutoCommit(false);
    }
    public void insert (Person p) throws Exception{
        preparedStatement = connection.prepareStatement("insert into person (id, name, family, salary) values (?,?,?,?)");
        preparedStatement.setLong(1, p.getId());
        preparedStatement.setString(2, p.getName());
        preparedStatement.setString(3, p.getFamily());
        preparedStatement.setLong(4, p.getSalary());
        preparedStatement.executeUpdate();
    }
    public List<Person> select ()throws Exception{
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()){
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setFamily(resultSet.getString("family"));
            person.setSalary(resultSet.getLong("salary"));
            personList.add(person);
        }
        return personList;
    }
    public void update (Person p) throws Exception{
        preparedStatement = connection.prepareStatement("update person set name=? ,family=? , salary=? where id=?");
        preparedStatement.setString(1, p.getName());
        preparedStatement.setString(2, p.getFamily());
        preparedStatement.setLong(3, p.getSalary());
        preparedStatement.setLong(4, p.getId());
        preparedStatement.executeUpdate();

    }
    public void delete (long id)throws Exception{
        preparedStatement = connection.prepareStatement("delete from person where id=?");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();

    }
    public void commit()throws Exception{
        connection.commit();
        connection.close();
        preparedStatement.close();
    }


}
