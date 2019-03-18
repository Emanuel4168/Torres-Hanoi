package models;

public class Torre {

	private int xPosition,yPosition,discos;
	
	public Torre(int xPosition, int yPosition, int discos) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.discos = discos;
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

	public int getDiscos() {
		return discos;
	}

	public void setDiscos(int discos) {
		this.discos = discos;
	}
	
	
}
