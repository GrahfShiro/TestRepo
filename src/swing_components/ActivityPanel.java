package swing_components;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ActivityPanel extends JPanel {

	JLabel title;
	JLabel name;
	JLabel description;
	
	float fontScalar = Toolkit.getDefaultToolkit().getScreenSize().height/1800f;

	 public ActivityPanel() {

		 
		 
		//Set Label variables and fonts    - TODO make variables class variables for later access
		 title = new JLabel("Activity Interface");
		 
		Font fs30 = title.getFont().deriveFont(fontScalar*30f);
		Font fs50 = title.getFont().deriveFont(fontScalar*50f);


		title.setFont(fs50);
		 
		name = new JLabel("Activity Title Here");
		description = new JLabel("Activity Description Here");
		
		name.setFont(fs30);
		description.setFont(fs30);
		
		
		 //Set the Layout
		 this.setLayout(new GridBagLayout());
		 GridBagConstraints constraints = new GridBagConstraints();
		 
		
		 constraints.gridx = 0;
		 constraints.gridy = 0;
		 constraints.weightx = 1;
		 constraints.weighty = 1;
		 constraints.gridwidth = 4;
		 constraints.anchor = GridBagConstraints.NORTHWEST;
		 constraints.insets = new Insets(0,10,0,0);
		 
		
		 this.add(title, constraints);
		 
		 constraints.fill = GridBagConstraints.HORIZONTAL;
		 constraints.gridwidth = 1;
	 
		 
		 
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		BufferedImage blurBackground = null;
		
		try {
			blurBackground = ImageIO.read(new File("blur.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	
		g.drawImage(blurBackground, 0, 0, getWidth(), getHeight(), null);
		}
}
