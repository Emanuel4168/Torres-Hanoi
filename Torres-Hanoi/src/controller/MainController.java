package controller;

import java.awt.event.*;

import models.*;
import models.Movimiento;
import views.MainView;

public class MainController implements ActionListener{

	private MainView view;
	private MainModel model;
	
	public MainController(MainView view, MainModel model) {
		this.view = view;
		this.model = model;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.moverDisco(new Movimiento(2,1,1));
		view.drawTowers();
	}

}
