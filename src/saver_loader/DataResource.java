package saver_loader;

import java.util.ArrayList;

import resources.Projects;

public class DataResource {

	public static ArrayList<Projects> projectList = new ArrayList<Projects>();
	public static boolean listView = true;
	public static Projects selectedProject;
	
	public static Projects getProjectbyProjectId(int projectId){
		
		for(Projects project: projectList){
			
			if(project.getId() == projectId)
				return project;
		}
		return null;
	}
	
	public static Projects getProjectbyProjectName(String name){
		
		for(Projects project: projectList){
			
			if(project.getProjectName() == name)
				return project;
		}
		return null;
	}
	
}
