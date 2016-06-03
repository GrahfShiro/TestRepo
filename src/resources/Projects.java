package resources;

import java.util.Set;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;
import java.util.ArrayList;

public class Projects {

	private static int projectCount = 0;
	private int id;
	private String projectName;
	private ArrayList<Users> userList;
	private String date;
	private DefaultDirectedGraph<Activities,DefaultEdge> activityGraph;
	private ArrayList<Activities> activityList;
	private int managerID;
	private Object description;
	private int budget;

	
	public Projects() {
        this.id = -1;
        this.projectName = null;
        this.userList = null;
        this.managerID = -1;
        this.date = null;
        this.description = null;
        this.budget = -1;
        this.activityGraph = null;
        this.activityList = null;
    }
	
	public Projects(String projectName, ArrayList<Users> userList, String date, int managerID,
            String description, double budget) {
        this.id = projectCount++;
        this.projectName = projectName;
        this.userList = userList;
        this.managerID = managerID;
        this.date = date;
        this.description = description;
        this.budget = (int) budget;
        this.activityGraph = new DefaultDirectedGraph<Activities,DefaultEdge>(DefaultEdge.class);
        this.activityList = new ArrayList<Activities>();
    }
	
	public Projects(String projectName, ArrayList<Users> userList, String date, int projectID, int managerID,
			String desription, double budget) {
		this.projectName = projectName;
		this.userList = userList;
		this.date = date;
		this.activityGraph = new DefaultDirectedGraph<Activities,DefaultEdge>(DefaultEdge.class);
		this.activityList = new ArrayList<Activities>();
	}
	
	public static int getProjectCount() {
		return projectCount;
	}

	public static void setProjectCount(int projectCount) {
		Projects.projectCount = projectCount;
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

	public ArrayList<Users>  getProjectMembers() {
		return userList;
	}

	public void setProjectMembers(ArrayList<Users>  userList) {
		this.userList = userList;
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
	
	/**
	 * @return the activityList
	 */
	public ArrayList<Activities> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityList the activityList to set
	 */
	public void setActivityList(ArrayList<Activities> activityList) {
		this.activityList = activityList;
	}

	public void addActivity(Activities A) {
		this.activityGraph.addVertex(A);
		this.activityList.add(A);
	}
	
	public void addArrow(Activities A, Activities B) {
		this.activityGraph.addEdge(A, B);
	}
	
	public Set<Activities> getActivitySet() {
		return this.activityGraph.vertexSet();
	}
	
	public Set<DefaultEdge> getArrowSet() {
		return this.activityGraph.edgeSet();
	}
	
	public Set<DefaultEdge> getIncomingArrowsOfActivity(Activities A) {
		return this.activityGraph.incomingEdgesOf(A);
	}
	
	public Set<DefaultEdge> getOutgoingArrowsOfActivity(Activities A) {
		return this.activityGraph.outgoingEdgesOf(A);
	}
	
	public Activities getActivityBefore(DefaultEdge e) {
		return this.activityGraph.getEdgeSource(e);
	}
	
	public Activities getActivityAfter(DefaultEdge e) {
		return this.activityGraph.getEdgeTarget(e);
	}
	
	public void setES(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setEarliestStart(n);
		}
	}
	
	public double getES(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getEarliestStart();
		}
		return -1;
	}
	
	public void setEF(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setEarliestFinish(n);
		}
	}
	
	public double getEF(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getEarliestFinish();
		}
		return -1;
	}
	
	public void setLS(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setLatestStart(n);
		}
	}
	
	public double getLS(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getLatestStart();
		}
		return -1;
	}
	
	public void setLF(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setLatestFinish(n);
		}
	}
	
	public double getLF(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getLatestFinish();
		}
		return -1;
	}
	
	public void setFloat(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setActivityFloat(n);
		}
	}
	
	public double getFloat(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getActivityFloat();
		}
		return -1;
	}
	
	public void setMaxDuration(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setMaxDuration(n);
		}
	}
	
	public double getMaxDuration(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getMaxDuration();
		}
		return -1;
	}
	
	public void calculateTimes() {
		Set<Activities> vertexList = getActivitySet();
		Set<DefaultEdge> edgeList = getArrowSet();		
		
		// forward pass
		for (Activities i : vertexList)
		{
			// check if activity is a "first level" activity, no incoming edges
			if (this.activityGraph.inDegreeOf(i) == 0)
			{
				setES(i, 0);
				setEF(i, i.getDuration());	
			}
			else
			{
				Set<DefaultEdge> inEdges = getIncomingArrowsOfActivity(i);
				double highestEF = 0;
				for (DefaultEdge e : inEdges)
				{
					if (getActivityBefore(e).getEarliestFinish() >= highestEF)
						highestEF = getActivityBefore(e).getEarliestFinish();
				}
				setES(i, highestEF);
				setEF(i, highestEF + i.getDuration());
			}
			
		}
		
		// backward pass
		
		// float
		
		// critial path
		
		// max duration
		
	}
	
	
	
}
