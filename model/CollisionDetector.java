package model;

import java.awt.Rectangle;

public class CollisionDetector {
	
	Rectangle rect;
	ShapeList shapelist;
	
	public CollisionDetector(Rectangle rect, ShapeList shapelist) {
		this.rect = rect;
		this.shapelist = shapelist;
	}

	//returns true if the selection area intersects with the shape in question
	public boolean collides(Pair l1, Pair r1, Pair l2, Pair r2) {
		boolean toReturn = true;
		
		//l2, r2 is for selected area
		//l1, r1 is for drawn shape

		if (Math.min(l1.getX(), r1.getX()) >  r2.getX() || l2.getX() > Math.max(r1.getX(), l1.getX()))
			toReturn = false;
		
		if (Math.min(l1.getY(), r1.getY()) > r2.getY() || l2.getY() > Math.max(r1.getY(), l1.getY()))
			toReturn = false;
			
		return toReturn;
		

		
	}
	
	
	
}
