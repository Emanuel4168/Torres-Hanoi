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
		if(view.subir(2)) {
			return;
		}
		if(view.moverDisco(new Movimiento(2,0,1)))
			return;
		view.bajar(new Movimiento(2,0,1));
	}

}
