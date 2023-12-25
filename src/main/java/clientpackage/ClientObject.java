package clientpackage;

import java.io.Serializable;
 
public class ClientObject implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int id;
    private String name;
    private int lesson;
     
    public ClientObject(){}
    
    public ClientObject(String name, int lesson){
        this.name = name;
        this.lesson = lesson;
    }
    
    public ClientObject(int id, String name, int lesson){
        this.id = id;
    	this.name = name;
        this.lesson = lesson;
    }
     
    public int getId() {
        return id;
    }
     
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getLesson() {
        return lesson;
    }
 
    public void setLesson(int lesson) {
        this.lesson = lesson;
    }
}