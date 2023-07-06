package Main;

import Control.ProjectControler;
import Model.Project;

public class Main {
    
    public static void main(String[] args){
    
    ProjectControler projectControler = new ProjectControler();
    
    Project project = new Project();
    project.setName("testNome");
    project.setDescription("Descrição");
    projectControler.Save(project);
    
    
    }
    
}
