package taskpackage;
 
import java.io.Serializable;
 
public class TaskObject implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int id;
    private String text;
    private String start;
    private String end;
     
    public TaskObject(){ }
    
    public TaskObject(String text, String start, String end){
        this.text = text;
        this.start = start;
        this.end = end;
    }
    
    public TaskObject(int id, String text, String start, String end){
        this.id = id;
        this.text = text;
        this.start = start;
        this.end = end;
    }
     
    public int getId() {
        return id;
    }
     
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
 
    public String getStart() {
        return start;
    }
 
    public void setStart(String start) {
        this.start = start;
    }
    
    public String getEnd() {
        return end;
    }
    
    public void setEnd(String end) {
        this.end = end;
    }
}