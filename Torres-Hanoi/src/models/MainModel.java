package models;

import java.util.Vector;

public class MainModel {

	private Vector<Movimiento> movements;

	public MainModel() {
		movements = new Vector<Movimiento>();
	}
	
	public  void solveTowers(int discs, int inicio,int  inter, int fin) {
        if (discs == 1){
            movements.add(new Movimiento(1,inicio,fin));
            return;
        }
        solveTowers(discs - 1, inicio, fin, inter);
        movements.add(new Movimiento(discs,inicio,fin));
        // llamada recursiva
        solveTowers(discs - 1, inter, inicio, fin);
	}

	public Vector<Movimiento> getMovements() {
		return movements;
	}
}
