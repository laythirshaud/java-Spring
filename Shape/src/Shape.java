
public abstract class Shape {
	private String color;

	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Shape(String color) {
		super();
		this.color = color;
	}
	
	public abstract double getAria();
	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}
	
	
	
}