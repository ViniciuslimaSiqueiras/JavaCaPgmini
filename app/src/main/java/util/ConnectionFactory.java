package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
        
        }catch(Exception ex)
        {
            throw new RuntimeException("Erro no factory");
        }
    }
    public static Connection closeConnection(Connection Connection){
       try{
          if(Connection != null)
          {
            Connection.close();
          }
       }
         catch(Exception ex){
             throw new RuntimeException("Erro no close  factory");
             
         }
        return null;
    }
    public static Connection closeConnection(Connection connection,PreparedStatement statement)
    {
       try
       {
          if(connection != null)
          {
            connection.close();
          }
          if(statement != null)
          {
            statement.close();
          }
       }
       
         catch(Exception ex)
         {
             
         }
        return null;
    }
    public static Connection closeConnection(Connection connection,PreparedStatement statement,ResultSet resultSet)
    {
       try
       {
          if(connection != null)
          {
            connection.close();
          }
          if(statement != null)
          {
            statement.close();
          }
          if(resultSet != null)
          {
            resultSet.close();
          }
       }
         catch(Exception ex)
         {
             
         }
        return null;
    }
    
}
