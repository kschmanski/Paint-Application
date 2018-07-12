package model;


public class Pair {

	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return this.x;
	}
	
	int getY() {
		return this.y;
	}
	
	public void print() {
		System.out.printf("(%d,%d)\n", this.x, this.y);
	}
	

	
}
