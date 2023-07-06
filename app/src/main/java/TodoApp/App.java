package TodoApp;

import Control.ProjectControler;
import Model.Project;

public class App {
    public static void main(String[] args) 
    {
        ProjectControler projectControler = new ProjectControler();
        
        Project project = new Project();
        project.setName("Cuzaum");
        project.setDescription("novo project");
        
        projectControler.Save(project);
    }
}
