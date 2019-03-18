package models;

public class Movimiento {
	
	private int disco, torreInicio, torreDestino;
	
	public Movimiento(int disco, int torreInicio, int torreDestino) {
		this.disco = disco;
		this.torreInicio = torreInicio;
		this.torreDestino = torreDestino;
	}

	public int getDisco() {
		return disco;
	}
	
	public void setDisco(int disco) {
		this.disco = disco;
	}
	
	public int getTorreInicio() {
		return torreInicio;
	}

	public void setTorreInicio(int torreInicio) {
		this.torreInicio = torreInicio;
	}

	public int getTorreDestino() {
		return torreDestino;
	}

	public void setTorreDestino(int torreDestino) {
		this.torreDestino = torreDestino;
	}
	
}

