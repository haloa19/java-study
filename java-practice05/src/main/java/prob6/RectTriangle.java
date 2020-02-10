package prob6;

public class RectTriangle extends Shape {
	public double width;
	public double height;

	public RectTriangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		
		return width * height * 0.5;
	}

	@Override
	public double getPerimeter() {
		
		return width + height + Math.sqrt((width * width) + (height * height));
	}

}
