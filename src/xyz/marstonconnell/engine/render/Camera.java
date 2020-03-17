package xyz.marstonconnell.engine.render;

public class Camera{
	int x;
	int y;
	
	public Camera() {
		this.x = 0;
		this.y = 0;
		
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void shiftX(int x) {
		this.x = this.x + x;
	}
	
	public void shiftY(int y) {
		this.y = this.y + y;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
