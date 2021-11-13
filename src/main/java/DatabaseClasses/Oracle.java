package DatabaseClasses;

import MainClasses.Accounts;
import MainClasses.Customers;

import java.sql.*;

public class Oracle extends DatabaseHandler
{
    @Override
    public void addcustomerstodatabase(Customers object)
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger12345");
            String sql = "INSERT INTO CUSTOMERS (NAME,ADDRESS,PHONE,ACCOUNTNUMBER) VALUES (?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,object.getName());
            statement.setString(2,object.getAddress());
            statement.setLong(3,object.getPhone());
            statement.setLong(4,object.getaccountnumbers().get(0));
            if(statement.executeUpdate()>0)
            {
                System.out.println("Record added to customer database successfully");
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void addaccountstodatabase(Accounts object)
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger12345");
            String sql = "INSERT INTO ACCOUNTS (ACCOUNTNUMBER,BALANCE,ACCOUNTTYPE,DATECREATED) VALUES (?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1,object.getAccountnumber());
            statement.setDouble(2,object.getBalance());
            statement.setString(3,object.getaccounttype());
            statement.setString(4,object.getDatecreated());
            if(statement.executeUpdate()>0)
            {
                System.out.println("Record added to customer database successfully");
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
