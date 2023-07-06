package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.ConnectionFactory;
import Model.Project;
import java.sql.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectControler {
    
    
    
    public void Save(Project project)
    {
        String sql = "INSERT INTO projects (Name,Description,CreationAt,UpdateAt) VALUES"
                + "(?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2,project.getDescription());
            statement.setDate(3,new Date(project.getCreationAt().getTime()));
            statement.setDate(4,new Date(project.getUpdateAt().getTime()));
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro", ex);
            
        }finally{
            ConnectionFactory.closeConnection(conn , statement);
        }
    }
    
    public void UpdateProject(Project project){
    
        String sql = "UPDATE Projects SET name = ?, Description = ?, CreationAt = ?"
                + "UpdateAt = ?, WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1,project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3,new Date(project.getCreationAt().getTime()));
            statement.setDate(4,new Date(project.getUpdateAt().getTime()));
            statement.setInt(5,project.getID());
            
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao Atualizar");
            
        } finally {
           ConnectionFactory.closeConnection(conn,statement);
           
        }
    
    }
    
    public List<Project> getAll()
    {
        String sql = "SELECT * FROM projects WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<Project>();
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
             Project project = new Project();
             
             project.setID(resultSet.getInt("ID"));
             project.setName(resultSet.getString("Name"));
             project.setDescription(resultSet.getString("Description"));
             project.setCreationAt(resultSet.getDate("CreationAt"));
             project.setUpdateAt(resultSet.getDate("UpdateAt"));
             
             projects.add(project);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Projetos");
        } finally {
            ConnectionFactory.closeConnection(conn,statement,resultSet);
        }
        return projects;
    }
    
    
    public void DeleteProject(int ID){
    
        String sql = "DELETE FROM project WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1,ID);
            
            statement.execute();    
            
        } catch (Exception e) {
            
            throw new RuntimeException("erro ao deletar o projeto");
            
        } finally {
            
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
}
