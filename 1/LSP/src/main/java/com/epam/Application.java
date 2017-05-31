package com.epam;

import java.util.Arrays;
import java.util.List;

public class Application {

	private List<Rectangle> rectangles = Arrays.asList(new Rectangle(10, 20), new Square(10), new Rectangle(30, 40));

	public static void main(String[] args) {
		Application application = new Application();
		application.matchsides();
		if (application.checkSideMatch()) {
			System.out.println("Perfect!");
		} else {
			System.out.println("We have a bug!");
		}
	}

	public void matchsides() {
		boolean first = true;
		double lastSideB = 0D;
		for (int i=0; i < rectangles.size();i++) {
			double sideB = rectangles.get(i).getSideB();
			if (!first) {
				if (rectangles.get(i).getClass() == Rectangle.class){
					rectangles.set(i,new Rectangle(lastSideB,sideB));
				}
				if(rectangles.get(i).getClass() == Square.class){
					rectangles.set(i,new Square(lastSideB));
				}
			}
			lastSideB = rectangles.get(i).getSideB();
			first = false;
		}
	}

	public boolean checkSideMatch() {
		boolean ok = true;
		for (int i = 1; i < rectangles.size() && ok; i++) {
			ok = (rectangles.get(i).getSideA() == rectangles.get(i - 1).getSideB());
		}
		return ok;
	}

}
