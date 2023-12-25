package taskpackage;
 
import java.sql.*;
import java.util.ArrayList;
 
public class TaskDB {
 
    private static String url = "jdbc:mysql://localhost:3306/CRM14?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "neilyanoilyA_1";
    public static ArrayList<TaskObject> select() {
         
        ArrayList<TaskObject> tasks = new ArrayList<TaskObject>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM task");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String text = resultSet.getString(2);
                    String start = resultSet.getString(3);
                    String end = resultSet.getString(4);
                    TaskObject task = new TaskObject(id, text, start, end);
                    tasks.add(task);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return tasks;
    }
    
    public static TaskObject selectOne(int id) {
         
        TaskObject task = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM task WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int taskId = resultSet.getInt(1);
                        String text = resultSet.getString(2);
                        String start = resultSet.getString(3);
                        String end = resultSet.getString(4);
                        task = new TaskObject(taskId, text, start, end);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return task;
    }

    public static int insert(TaskObject task) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO task (text, start, end) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, task.getText());
                    preparedStatement.setString(2, task.getStart());
                    preparedStatement.setString(3, task.getEnd());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    
    public static int update(TaskObject task) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE task SET text = ?, start = ?, end = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, task.getText());
                    preparedStatement.setString(2, task.getStart());
                    preparedStatement.setString(3, task.getEnd());
                    preparedStatement.setInt(4, task.getId());
                      
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
                  
                String sql = "DELETE FROM task WHERE id = ?";
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