package listview_components;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jgraph.graph.DefaultEdge;

import resources.Activities;
import resources.Projects;

@SuppressWarnings("serial")
public class ActivityListPane extends JPanel {

	JTable table;
	JScrollPane scrollpane;
	float fontScalar = Toolkit.getDefaultToolkit().getScreenSize().height/1800f;

	
	JLabel title;
	
	public ActivityListPane(Projects selectedProject){
		
		super();
		
		int size = selectedProject.getActivityList().size();
		
		Activities[] activityList = new Activities [size];
		selectedProject.getActivityList().toArray(activityList);
		
		String[] columnHeaders = {"Name" , "Label", "Duration", "Depedencies"};
		
		Object[][] data = new Object[size][4];
		
		for(int j = 0; j< size; j++){
			
			for(int i = 0; i < 4; i++){
				
				//We are going to need to create the list of dependencies before we can
				//assign them in our upcoming switch statement
				
				Set<DefaultEdge> edgeList=  selectedProject.getIncomingArrowsOfActivity(activityList[j]);
				String dependencies = "|";
				
				for(DefaultEdge e: edgeList){
					
					dependencies += selectedProject.getActivityBefore(e).getId()+ "| ";
					
					
				}
				switch(i){
				
				case 0: data[i][j] = activityList[j].getDescription();
				break;
				
				case 1: data[i][j] = activityList[j].getId(); //THIS SHOULD BE LABEL
				break;
				
				case 2: data[i][j] = activityList[j].getDuration();
				break;
				
				case 3: data[i][j] = dependencies;
				break;
				
				}
				
			}
			
	
		}
				
		
		table = new JTable(data, columnHeaders);
		
		scrollpane = new JScrollPane(table);
		
		this.add(scrollpane);
		
	}
	
	
	public ActivityListPane(){
		
		super();	
		
		this.setLayout(new BorderLayout());
		
				
		String[] columnHeaders = {"Name" , "Label", "Duration", "Depedencies"};
		
		Object[][] data = new Object[10][4];
		
		for(int j = 0; j< 4; j++){
			
			for(int i = 0; i < 10; i++){
				
				data[i][j] = j;
				
			}
			
	
		}
				
		
		table = new JTable(data, columnHeaders);
		
		scrollpane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setFont(table.getFont().deriveFont(fontScalar*30f));
		table.setRowHeight(35);
		table.getTableHeader().setFont(table.getFont().deriveFont(40f));
		
		title = new JLabel("               Activity ViewPort");
		title.setFont(title.getFont().deriveFont(fontScalar*50f));
		
		this.add(title, BorderLayout.PAGE_START);
	
		this.add(scrollpane);
		
	}
	
	
}
