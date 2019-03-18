package views;

import java.awt.*;
import java.util.Vector;
import java.util.Random;

import javax.swing.*;

import controller.MainController;
import models.*;
public class MainView extends JFrame {
	
	private Graphics g;
	private Image backbuffer = null;
	private int nDiscos;
	private static final Color[] COLORS = {Color.RED,Color.green,Color.blue,Color.CYAN,Color.YELLOW,Color.ORANGE, Color.PINK,Color.WHITE};
	private Disco[] discos;
	private Torre[] torres = {new Torre(20,250,0),new Torre(140,250,0),new Torre(260,250,0)};
	private Timer timer;
	private boolean isGoingDown = false, substractOance = false, addOance = false;
	private MainController controller;
	private Vector<Movimiento> movements;
	private Movimiento currentMovement;
	private int numberMovement;
	
	public MainView() {
		super("Torres de Hanoi");
		setSize(380,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		numberMovement = 0;
		nDiscos = new Random().nextInt(7)+1;
		discos = new Disco[nDiscos];
		setVisible(true);
		backbuffer = createImage(getWidth(), getHeight());
		g =backbuffer.getGraphics();
		initializaDiscos();
		drawTowers();
	}
	
	public void paint(Graphics g){
		g.drawImage(backbuffer, 0, 0, getWidth(), getHeight(), this);
	}
	
	public void drawTowers() {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(20, 250, 100, 20);
		g.fillRect(60, 50, 10, 200);
		g.fillRect(140, 250, 100, 20);
		g.fillRect(180, 50, 10, 200);
		g.fillRect(260, 250, 100, 20);
		g.fillRect(300, 50, 10, 200);
			
		for(int i = 0; i < nDiscos; i++) {
			g.setColor(COLORS[i]);
			g.fillRect(discos[i].getxPosition(),discos[i].getyPosition(),discos[i].getWidth(),discos[i].getHeigth());
		}
		
		repaint();
	}
	
	private void initializaDiscos() {
		int tamaño = 90, yAxis = 240,xAxis = 25;
		for(int i = nDiscos -1; i >= 0; i--) {
			discos[i] = new Disco(xAxis,yAxis,tamaño,10);
			g.fillRect(discos[i].getxPosition(),discos[i].getyPosition(),discos[i].getWidth(),discos[i].getHeigth());
			tamaño -= 10;
			yAxis -= 10;
			xAxis += 5;
		}
		torres[0].setDiscos(nDiscos);
	}
	
	
	public boolean moverDisco(Movimiento movimiento) {
		int torreInicio = movimiento.getTorreInicio(), 
				torreDestino = movimiento.getTorreDestino(),
				disco = movimiento.getDisco()-1,
				aux = (nDiscos*5) - (disco * 5);
		if(discos[disco].getxPosition() == torres[torreDestino].getxPosition()+aux)
			return false;
		
		if(torres[torreInicio].getxPosition() < torres[torreDestino].getxPosition()) {
			discos[disco].setxPosition(discos[disco].getxPosition()+5);
			drawTowers();
			return true;
		}
		
		discos[disco].setxPosition(discos[disco].getxPosition()-5);
		drawTowers();
		return true;
	}
	
	public boolean subir(Movimiento movimiento) {
		super.paint(g);
		int disco = movimiento.getDisco()-1,
					torreInicio = movimiento.getTorreInicio();
		if(discos[disco].getyPosition() > 40 && !isGoingDown) {
			discos[disco].setyPosition(discos[disco].getyPosition() -5);
			drawTowers();
			return true;
		}
		if(!substractOance) {
			torres[torreInicio].setDiscos(torres[torreInicio].getDiscos() -1);
			System.out.println(torres[torreInicio].getDiscos());
			substractOance = true;
		}
		return false;
	}
	
	public boolean bajar(Movimiento movimiento) {
		super.paint(g);
		int disco = movimiento.getDisco()-1,torreDestino = movimiento.getTorreDestino(),
				posFinal = 235 - (torres[torreDestino].getDiscos() * 10);

		if(discos[disco].getyPosition() <= posFinal) {
			isGoingDown = true;
			discos[disco].setyPosition(discos[disco].getyPosition() +5);
			drawTowers();
			return true;
		}
		numberMovement++;
		if(numberMovement >= movements.size()) {
			timer.stop();
			return false;
		}
		torres[torreDestino].setDiscos(torres[torreDestino].getDiscos() + 1);
		currentMovement = movements.get(numberMovement);
		isGoingDown = false;
		substractOance = false;
//		System.out.println(torres[torreDestino].getDiscos());
		return false;
	}
	
	public void start() {
		repaint();
	}
	
	public void setController(MainController controller) {
		this.controller = controller;
		timer = new Timer(100,controller);
		timer.start();
	}

	public Vector<Movimiento> getMovements() {
		return movements;
	}

	public void setMovements(Vector<Movimiento> movements) {
		this.movements = movements;
		System.out.println("Movimientos: "+movements.size());
		currentMovement = this.movements.get(0);
	}

	public Movimiento getCurrentMovement() {
		return currentMovement;
	}

	public int getnDiscos() {
		return nDiscos;
	}
}
