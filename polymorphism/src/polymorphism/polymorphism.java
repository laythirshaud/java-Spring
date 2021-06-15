package polymorphism;

import java.util.Date;

public class polymorphism {
	private String color = "white";
	private boolean filled = false;
	private Date dateCreatedDate=new Date();

	public polymorphism() {
	}
	
	public polymorphism(String color, boolean filled) {
		this.color = color;
		this.filled = filled;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreatedDate() {
		return dateCreatedDate;
	}

	public void setDateCreatedDate(Date dateCreatedDate) {
		this.dateCreatedDate = dateCreatedDate;
	}
	


}