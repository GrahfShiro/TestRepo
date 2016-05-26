package resources;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;

public class Projects {

	private int id;
	private String projectName;
	private Users[] projectMembers;
	private String date;
	private DefaultDirectedGraph<Activities,DefaultEdge> activityGraph;

	public Projects(int id, String projectName, Users[] projectMembers, String date, DefaultDirectedGraph<Activities,DefaultEdge> activityGraph) {
		this.id = id;
		this.projectName = projectName;
		this.projectMembers = projectMembers;
		this.date = date;
		this.activityGraph = activityGraph;
	}
	
	public Projects(int id, String projectName, Users[] projectMembers, String date) {
		this.id = id;
		this.projectName = projectName;
		this.projectMembers = projectMembers;
		this.date = date;
		this.activityGraph = new DefaultDirectedGraph<Activities,DefaultEdge>(DefaultEdge.class);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Users[] getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(Users[] projectMembers) {
		this.projectMembers = projectMembers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public DefaultDirectedGraph<Activities, DefaultEdge> getActivityGraph() {
		return activityGraph;
	}

	public void setActivityGraph(DefaultDirectedGraph<Activities, DefaultEdge> activityGraph) {
		this.activityGraph = activityGraph;
	}

	
	
	
	
	
	
	
}
