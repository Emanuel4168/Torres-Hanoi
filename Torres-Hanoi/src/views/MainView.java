package views;

import java.awt.*;
import javax.swing.*;

import controller.MainController;
import models.*;
public class MainView extends JFrame {
	
	Graphics g;
	Image backbuffer = null;
	int nDiscos;
	private static final Color[] COLORS = {Color.RED,Color.green,Color.blue,Color.CYAN,Color.YELLOW};
	private Disco[] discos;
	private Torre[] torres = {new Torre(20,250,0),new Torre(140,250,0),new Torre(260,250,0)};
	private Timer timer;
	private boolean isGoingDown = false;
	private MainController controller;
	
	public MainView() {
		super("Torres de Hanoi");
		setSize(380,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nDiscos = 3;
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
		for(int i = 0; i < nDiscos; i++) {
			discos[i] = new Disco(xAxis,yAxis,tamaño,10);
			g.fillRect(discos[i].getxPosition(),discos[i].getyPosition(),discos[i].getWidth(),discos[i].getHeigth());
			tamaño -= 10;
			yAxis -= 10;
			xAxis += 5;
		}
	}
	
	
	public boolean moverDisco(Movimiento movimiento) {
		int torreInicio = movimiento.getTorreInicio(), 
				torreDestino = movimiento.getTorreDestino(),
				disco = movimiento.getDisco();
		if(discos[disco].getxPosition() == torres[torreDestino].getxPosition()+10)
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
	
	public boolean subir(int disco) {
		super.paint(g);
		if(discos[disco].getyPosition() > 40 && !isGoingDown) {
			discos[disco].setyPosition(discos[disco].getyPosition() -5);
			drawTowers();
			return true;
		}
		return false;
	}
	
	public boolean bajar(Movimiento movimiento) {
		super.paint(g);
		int disco = movimiento.getDisco(),torreDestino = movimiento.getTorreDestino(),
				posFinal = 235 - (torres[torreDestino].getDiscos() * 10);
		if(discos[disco].getyPosition() <= posFinal) {
			isGoingDown = true;
			discos[disco].setyPosition(discos[disco].getyPosition() +5);
			drawTowers();
			return true;
		}
		isGoingDown = false;
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
}
