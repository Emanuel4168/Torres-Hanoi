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
		if(view.getMovements() == null) {
			model.solveTowers(view.getnDiscos(), 0, 1, 2);
			view.setMovements(model.getMovements());
			return;
		}
		
		Movimiento mov = view.getCurrentMovement();
		
//		System.out.println(mov.getDisco()+" de "+mov.getTorreInicio()+" a "+mov.getTorreDestino());
		if(view.subir(mov)) {
			return;
		}
		if(view.moverDisco(mov))
			return;
		view.bajar(mov);
	}

}
