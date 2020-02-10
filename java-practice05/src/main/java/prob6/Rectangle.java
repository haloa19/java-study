package prob6;

public class Rectangle extends Shape implements Resizable {
	public double width;
	public double height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		
		return width * height;
	}

	@Override
	public double getPerimeter() {
		
		return (width + height) * 2;
	}

	@Override
	public void resize(double d) {
		this.width = (this.width * d);
		this.height = (this.height * d);
		
	}

}
