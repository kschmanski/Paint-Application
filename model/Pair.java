package model;


public class Pair {

	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void print() {
		System.out.printf("(%d,%d)\n", this.x, this.y);
	}
	

	
}
