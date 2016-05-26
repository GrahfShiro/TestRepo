package resources;
public class Activities {

	private int id;
	private String description;
	private int duration;
	private double xpos, ypos;
	
	
	public Activities() {
		this.id = -1;
		this.description = null;
		this.duration = -1;
		this.xpos = -1;
		this.ypos = -1;
	}
	
	public Activities(int id, String description, int duration, double xpos, double ypos) {
		this.id = id;
		this.description = description;
		this.duration = duration;
		this.xpos = xpos;
		this.ypos = ypos;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getXpos() {
		return xpos;
	}


	public void setXpos(double xpos) {
		this.xpos = xpos;
	}


	public double getYpos() {
		return ypos;
	}


	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
	
	
	
	
}
