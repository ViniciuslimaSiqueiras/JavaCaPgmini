package Model;

import java.util.Date;

public class tarefa 
{
    private int ID;
    private int projectId;
    private String Name;
    private String description;
    private boolean State;
    private String Note;
    private Date deadLine;
    private Date createAt;
    private Date updateAt;

    public tarefa(int ID,int projectId, String Name, String description, boolean State, String Note, Date deadLine, Date createAt, Date updateAt) {
        this.ID = ID;
        this.projectId = projectId;
        this.Name = Name;
        this.description = description;
        this.State = State;
        this.Note = Note;
        this.deadLine = deadLine;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    
    public tarefa(){
        
        this.createAt = new Date();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getProjectId(){
    
        return projectId;
    }
    public void setProjectId(int projectId){
    this.projectId = projectId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Task{" + "ID=" + ID + ", Name=" + Name + ", description=" + description + ", State=" + State + ", Note=" + Note + ", deadLine=" + deadLine + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
    
}
