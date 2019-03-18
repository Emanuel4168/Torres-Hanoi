package views;

import java.awt.*;
import javax.swing.*;

import controller.MainController;
import models.Disco;
import models.Movimiento;

public class MainView extends JFrame {
	
	Graphics g;
	Image backbuffer = null;
	int nDiscos;
	private static final Color[] COLORS = {Color.RED,Color.green,Color.blue,Color.CYAN,Color.YELLOW};
	private Disco[] discos;
	private Timer timer;
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
			g.setColor(COLORS[i]);
			discos[i] = new Disco(xAxis,yAxis,tamaño,10);
			g.fillRect(discos[i].getxPosition(),discos[i].getyPosition(),discos[i].getWidth(),discos[i].getHeigth());
			tamaño -= 10;
			yAxis -= 10;
			xAxis += 5;
		}
	}
	
	public void moverDisco(Movimiento movimiento) {
		int torreInicio = movimiento.getTorreInicio(), 
				torreDestino = movimiento.getTorreDestino(),
				disco = movimiento.getDisco();
		if(torreInicio == 1 && torreDestino == 2) {
			discos[disco].setxPosition(discos[disco].getxPosition()+5);
		}
	}
	
	public void subir(int disco) {
		super.paint(g);
		if(discos[disco].getyPosition() > 40) {
			discos[disco].setyPosition(discos[disco].getyPosition() -5);
			repaint();
		}
	}
	
	public void bajar(int disco) {
		super.paint(g);
		if(discos[disco].getyPosition() > 40) {
			discos[disco].setyPosition(discos[disco].getyPosition() +5);
			repaint();
		}
	}
	
	public void start() {
		setVisible(true);
	}
	
	public void setController(MainController controller) {
		this.controller = controller;
		timer = new Timer(100,controller);
		timer.start();
	}
}
