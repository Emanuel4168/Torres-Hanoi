package models;

public class Disco {

	private int xPosition,yPosition,width,heigth;
	

	public Disco(int xPosition, int yPosition, int width, int heigth) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.heigth = heigth;
	}


	public int getxPosition() {
		return xPosition;
	}


	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}


	public int getyPosition() {
		return yPosition;
	}


	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeigth() {
		return heigth;
	}


	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	
}
