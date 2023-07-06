package Model;

import java.util.Date;

public class Project 
{
    private int ID;
    private String name;
    private String description;
    private Date CreationAt;
    private Date UpdateAt;
    
    public Project(int ID, String name,String description,Date CreationAt,Date UpdateAt)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.CreationAt = CreationAt;
        this.UpdateAt = UpdateAt;
    }

    public Project() {
      throw new UnsupportedOperationException("Erro Project"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationAt() {
        return CreationAt;
    }

    public void setCreationAt(Date CreationAt) {
        this.CreationAt = CreationAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date UpdateAt) {
        this.UpdateAt = UpdateAt;
    }

    @Override
    public String toString() {
        return "Project{" + "ID=" + ID + ", name=" + name + ", description=" + description + ", CreationAt=" + CreationAt + ", UpdateAt=" + UpdateAt + '}';
    }

    public void setCreationAt(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setUpdateAt(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
