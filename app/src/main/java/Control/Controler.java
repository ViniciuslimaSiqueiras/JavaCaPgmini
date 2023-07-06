package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Date;
import Model.tarefa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Controler {
    
    
    
    public void update(tarefa tarefa){
        
        String sql = "UPDATE tarefa SET ProjectId = ?,nome = ?, description = ?,"
                + "State = ? , Note =?, deadline = ?, createdAt = ?, UpdateAt = ?"
                + "Where id = ?";
        
        Connection conn = null;
        PreparedStatement Statement = null;
        try{
          //estabelecendo a conexao com o banco de dados
          conn = ConnectionFactory.getConnection(); 
          //preparando a query
          Statement = conn.prepareCall(sql);
          //setando os valores no statement
          Statement.setInt(1,tarefa.getProjectId());
          Statement.setString(2,tarefa.getName());
          Statement.setString(3,tarefa.getDescription());
          Statement.setBoolean(4,tarefa.getState());
          Statement.setString(5, tarefa.getNote());
          Statement.setDate(6,new Date(tarefa.getCreateAt().getTime()));
          Statement.setDate(7, new Date(tarefa.getUpdateAt().getTime()));
          Statement.setInt(8,tarefa.getID());
          
          //Executando a Query
          Statement.execute();
            
        }catch(Exception e)
        {
            
        }finally
        {
        
            ConnectionFactory.closeConnection(conn, Statement);
        }
    }
    
    //SAVE A TASK
    public void save(tarefa tarefa) throws SQLException
    {
        String sql = "INSERT INTO tarefa (projectID,Nome,description,State,notes,"
                + "DeadLine,CreatAt,UpdateAt) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        
         Connection conn = null;
         PreparedStatement Statement = null;
         
        try{
         //estabelecendo a conexao com o banco de dados
         conn = ConnectionFactory.getConnection();
         //preparando a query
         Statement = conn.prepareStatement(sql);
         //setando os valores no statement
         Statement.setInt(1,tarefa.getProjectId());
         Statement.setString(2,tarefa.getName());
         Statement.setString(3,tarefa.getDescription());
         Statement.setBoolean(4,tarefa.getState());
         Statement.setString(5,tarefa.getNote());
         Statement.setDate(6, new Date(tarefa.getDeadLine().getTime()));
         Statement.setDate(7,new Date(tarefa.getCreateAt().getTime()));
         Statement.setDate(8,new Date(tarefa.getUpdateAt().getTime()));
         //executando a Query
         Statement.execute();
        }catch(Exception e)
        {
         throw new RuntimeException("Erro ao salvar a tarefa"+e.getMessage(),e);   
            
        }finally
        {
            ConnectionFactory.closeConnection(conn,Statement);
        }
    }
    
    //REMOVE A TASK
    public void removeById(int tarefaID) throws SQLException
    {
        String sql = "DELETE FROM projects WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        try{
          conn = ConnectionFactory.getConnection();
          statement = conn.prepareStatement(sql);
          statement.setInt(1,tarefaID);
          statement.execute();
            
        }catch(Exception e)
        {
           throw new RuntimeException("Erro ao deletar a tarefa");
        }finally
        {
            ConnectionFactory.closeConnection(conn, statement);
        }
            
    }
    
    public List<tarefa> GetAll(int idProject)
    {
        String sql = "SELECT * FROM tarefas WHERE projectID = ? ";
        
        Connection conn = null;
        PreparedStatement Statement = null;
        ResultSet resultSet = null;
        //Criando uma lista de tarefas
        List<tarefa> tarefa = new ArrayList<tarefa>();
        
        try {
            
            conn = ConnectionFactory.getConnection();
            Statement = conn.prepareStatement(sql);
            //setando o valor correspondente ao filtro de busca
            Statement.setInt(1,idProject);
            
            //valor retornado pela execução da Query
            resultSet = Statement.executeQuery();
            
            //Enquando houverem valores a serem percorrido o meu resultSet
            while (resultSet.next())
            {
             tarefa task = new tarefa();
             task.setID(resultSet.getInt("ID"));
             task.setProjectId(resultSet.getInt("projectId"));
             task.setName(resultSet.getString("Nome"));
             task.setDescription(resultSet.getString("Description"));
             task.setState(resultSet.getBoolean("State"));
             task.setNote(resultSet.getString("Notes"));
             task.setDeadLine(resultSet.getDate("deadLine"));
             task.setCreateAt(resultSet.getDate("CreatedAt"));
             task.setUpdateAt(resultSet.getDate("UpdatedAt"));
             
             tarefa.add(task);
            }
            
        } catch (Exception e) {
            
        }finally{
            
             ConnectionFactory.closeConnection(conn,Statement,resultSet);
        
        }
        //lista de tarefas
        return tarefa;
    }

    private Object ConnectionFactory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
