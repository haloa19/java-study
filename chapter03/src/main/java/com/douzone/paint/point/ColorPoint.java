package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x,  y);
		//this.setX(x);
		//this.setY(y);
		// this.y = y 부모의 y가 protected인 경우 접근 가능		
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		//super.show();  부모코드를 사용
		System.out.println("점 [x=" + getX() + ",y=" + getY() + "color=" + color + "]을 그렸습니다");
	}
	
}
