package model;


public class Pair {

	int first;
	int second;
	
	public Pair(int x, int y) {
		this.first = x;
		this.second = y;
	}
	
	int getFirst() {
		return this.first;
	}
	
	int getSecond() {
		return this.second;
	}
	
	public void print() {
		System.out.printf("(%d,%d)\n", this.first, this.second);
	}
	

	
}
