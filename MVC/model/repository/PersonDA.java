package model.repository;
import model.entity.Person;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class PersonDA {
    private Connection connection;
    private CallableStatement callableStatement;


    public PersonDA()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "...", "...");

    }
    public void invokep3(Person p) throws Exception {
        callableStatement = connection.prepareCall("{call p3 (?,?,?,?)}");
        callableStatement.setLong(1,p.getId());
        callableStatement.setString(2, p.getName());
        callableStatement.setString(3,p.getFamily());
        callableStatement.setLong(4,p.getSalary());
        callableStatement.execute();
        callableStatement.close();
        connection.close();

    }


}
