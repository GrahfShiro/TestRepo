package listview_components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import saver_loader.DataResource;


@SuppressWarnings("serial")
public class ProjectListPane extends JPanel{

	public JList<String> list;
	public JScrollPane scrollpane;
	
	public JLabel title = new JLabel();
	float fontScalar = Toolkit.getDefaultToolkit().getScreenSize().height/1800f;

	public ProjectListPane(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		String[] projectNames = new String[100];
		
		for(int i = 0; i< 100; i++){
			Integer integer = new Integer(i);
			projectNames[i] = integer.toString();
		}
		
		//This will be the real code later
//		String[] projectNames = new String[DataResource.projectList.size()];
	//	for(int i = 0; i < DataResource.projectList.size(); i++)
		//	projectNames[i] = DataResource.projectList.get(i).getProjectName();
		
		list = new JList<String>(projectNames);
		list.setFont(list.getFont().deriveFont(fontScalar*30f));
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    list.addListSelectionListener(new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent e) {
	         	        	
	        	DataResource.selectedProject = DataResource.getProjectbyProjectName(list.getSelectedValue());
	        	
	        }
	      });
			
		
	    

		scrollpane = new JScrollPane(list);
		
		c.weightx =1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.CENTER;
		
		title.setText("Project List");
		title.setFont(title.getFont().deriveFont(fontScalar*50f));
		
		this.add(title, c);
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 0;
		c.gridy = 1;
		c.weighty = 5;
		this.add(scrollpane, c);
				
		
	}
	
	
}
