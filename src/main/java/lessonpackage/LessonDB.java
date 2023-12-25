package lessonpackage;


import java.sql.*;
import java.util.ArrayList;

import taskpackage.TaskObject;
 
public class LessonDB {
 
    private static String url = "jdbc:mysql://localhost:3306/CRM14?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "neilyanoilyA_1";
    public static ArrayList<LessonObject> select() {
         
        ArrayList<LessonObject> lessons = new ArrayList<LessonObject>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM lesson");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String time = resultSet.getString(2);
                    String subject = resultSet.getString(3);
                    String category = resultSet.getString(4);
                    LessonObject lesson = new LessonObject(id, time, subject, category);
                    lessons.add(lesson);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return lessons;
    }
    
    public static LessonObject selectOne(int id) {
         
        LessonObject lesson = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM lesson WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int lessonId = resultSet.getInt(1);
                        String time = resultSet.getString(2);
                        String subject = resultSet.getString(3);
                        String category = resultSet.getString(4);
                        lesson = new LessonObject(lessonId, time, subject, category);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return lesson;
    }
    
    public static int update(LessonObject lesson) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE lesson SET timee = ?, subject = ?, category = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, lesson.getTime());
                    preparedStatement.setString(2, lesson.getSubject());
                    preparedStatement.setString(3, lesson.getCategory());
                    preparedStatement.setInt(4, lesson.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int insert(LessonObject lesson) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO lesson (timee, subject, stgroup, category) Values (?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, lesson.getTime());
                    preparedStatement.setString(2, lesson.getSubject());
                    preparedStatement.setString(3, lesson.getCategory());
                      
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
                  
                String sql = "DELETE FROM lesson WHERE id = ?";
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