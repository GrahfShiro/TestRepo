package saver_loader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import resources.Activities;
import resources.Projects;
import resources.Users;

public class DataResource {

	public static ArrayList<Projects> projectList = new ArrayList<Projects>();
	
	public static Users currentUser; //this is the currently logged in user for which the projetList will be populated
	
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
	
	public static void loadFromDB()
	{
		//query user_project_relationship
		//get all projID where userID = currentUserID
		
		Connection connection = null;
        PreparedStatement ps;
        
        try{
        	connection = DriverManager.getConnection("jdbc:sqlite:ultimate_sandwich.db");
        	
        	//set projectCount to max project id from database
        	
        	PreparedStatement ps3 = connection.prepareStatement("SELECT max(id) FROM projects;");
        	ResultSet result3 = ps3.executeQuery();
        	
        	if(result3.next())
        	{
        		Projects.setProjectCount(result3.getInt(1)) ;
        	}
        	
        	//set activityCount to max activity id from database
        	ps3 = connection.prepareStatement("SELECT max(id) FROM activities;");
        	result3 = ps3.executeQuery();
        	
        	if(result3.next())
        	{
        		Activities.setActivityCount(result3.getInt(1)) ;
        	}
        	
        	
        	
        	
        	ps = connection.prepareStatement("SELECT id FROM projects "
        			+ "WHERE manager_id = ?;");
        	ps.setInt(1, currentUser.getID());
        	ResultSet result = ps.executeQuery();
        	
        	ArrayList<Integer> projIds = new ArrayList<Integer>();
        	
        	ArrayList<Integer> activityIds = new ArrayList<Integer>(); 
        	
        	
        	
        	while(result.next())
        	{
        		//we have project ids
        		//projIds.add(result.getInt(1));
        		int projectID = result.getInt(1);
        		int managerID = result.getInt(6);
        		String projectName = result.getString(2);
        		String desription = result.getString(4);
        		double budget = result.getDouble(5);
        		String date = result.getString(3);
        		
        		
        		//getting all users associated with project
        		PreparedStatement ps1 = connection.prepareStatement("SELECT user_id FROM user_project_relationships WHERE "
        				+ "project_id = ?");
        		ps1.setInt(1, projectID);
        		ResultSet result1 = ps1.executeQuery();
        		
        		ArrayList<Users> userList = new ArrayList<Users>();
        		
        		while(result1.next())
        		{
        			//memeberIds.add(result1.getInt(1));//got all userids associated with project
        			int userID = result1.getInt(1);
        			
        			PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM users WHERE "
            				+ "id = ?");
            		ps2.setInt(1, userID);
            		ResultSet result2 = ps1.executeQuery();
            		
            		
            		
            		while(result2.next())
            		{
            			String username = result2.getString(4);
            			String first_name = result2.getString(2);
            			String last_name = result2.getString(3);
            			String password = result2.getString(5);
            			int id = result2.getInt(1);
            			String userType = result2.getString(6);
            			
            			userList.add(new Users(username, first_name, last_name, password, id, userType));
            		}
        			
        			
        		}
        		//creates projects with no activities
        		projectList.add(new Projects(projectName,userList,date,projectID,managerID,desription,budget,date));
        		//query activy relation table to get activies associated with project
        		//for each activity query activity table relation to get dependent activities
        	
        	}
          for(int x : projIds){
        	//System.out.print(x + " ");
        	  
        	  
        	  
          }
        	  
          
          
        }
        catch(Exception exception) {
        	System.out.println(exception.getMessage());
        }
        
        
        
        //close connection at end
        try{
        	connection.close();
        }catch(Exception closingException)
        {
        	System.out.println(closingException.getMessage());
        }
	
	}
	
}
