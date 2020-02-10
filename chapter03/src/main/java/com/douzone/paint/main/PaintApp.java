package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

import chapter03.Global;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point(2, 5);
		//point1.setX(2);
		//point1.setY(5);		
		point1.show(true);
		//drawPoint(point1);
		draw(point1);
		
		Point point2 = new Point(10, 23);
		//drawPoint(point2);
		point1.show();
		draw(point2);
		
		Point point3 = new ColorPoint(50, 100, "red");
		//drawPoint(point3);
		draw(point3);
		point3.show(false);
		point3.show(true);

		Rect rect = new Rect();
		//drawRect(rect);  //클래스
		//drawShape(rect);  //추상클래스
		draw(rect);  //인터페이스
		
		Triangle triangle = new Triangle();
		//drawTriangle(triangle);
		//drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("hello"));
		
		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 형제끼리 비교 불가, 클래스는 hierachy 상위 하위만 instanceof 연산 사용 가능
		//System.out.println(circle instanceof Rect); 
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		// Interface는 hierachy 상관없이 instanceof 연산 사용 가능
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
		
		
	}
	
	public static void draw(Drawable d) {
		d.draw();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}
	
	/*
	public static void drawRect(Rect rect) {
		rect.draw();
	}
	
	public static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
	
	*/
	
	
	public static void drawPoint(Point point) {
		point.show(false);		
	}
	
	public static void globalTest() {
		System.out.println(Global.globalVar);
		Global.globalFunc(); // 다른 패키지에 있는 변수, 함수를 사용하고 싶으면 static -> 객체생성 없이 사용 가능		
	}

}
