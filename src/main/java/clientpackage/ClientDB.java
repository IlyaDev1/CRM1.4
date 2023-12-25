package clientpackage;


import java.sql.*;
import java.util.ArrayList;

import taskpackage.TaskObject;
 
public class ClientDB {
 
    private static String url = "jdbc:mysql://localhost:3306/CRM14?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "neilyanoilyA_1";
    public static ArrayList<ClientObject> select() {
         
        ArrayList<ClientObject> clients = new ArrayList<ClientObject>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM client");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int lesson = resultSet.getInt(3);
 
                    ClientObject client = new ClientObject(id, name, lesson);
                    clients.add(client);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return clients;
    }
    
    public static ClientObject selectOne(int id) {
         
        ClientObject client = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM client WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int clientId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int lesson = resultSet.getInt(3);
                        client = new ClientObject(clientId, name, lesson);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return client;
    }
    
    public static int update(ClientObject client) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE client SET name = ?, lesson = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, client.getName());
                    preparedStatement.setInt(2, client.getLesson());
                    preparedStatement.setInt(3, client.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int insert(ClientObject client) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO client (name, lesson) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, client.getName());
                    preparedStatement.setInt(2, client.getLesson());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM client WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}