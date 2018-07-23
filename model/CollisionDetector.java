package model;

import java.awt.Rectangle;

public class CollisionDetector {
	
	Rectangle x;
	ShapeList s;
	
	public CollisionDetector(Rectangle x, ShapeList s) {
		this.x = x;
		this.s = s;
	}

	public boolean collides(Pair l1, Pair r1, Pair l2, Pair r2) {
		boolean toReturn = true;
		
		// If one rectangle is on left side of other
		if (l1.getX() > r2.getX() || l2.getX() > r1.getX())
			toReturn = false;

		// If one rectangle is above other
		if (l1.getY() < r2.getY() || l2.getY() < r1.getY())
		    toReturn = false;

		return toReturn;
		

		
	}
	
	
	
}
