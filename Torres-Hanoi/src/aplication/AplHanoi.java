package aplication;

import controller.MainController;
import models.MainModel;
import models.Movimiento;
import views.MainView;

public class AplHanoi {

	public static void main(String[] args) {
		MainView view = new MainView();
		MainModel model = new MainModel();
	
		MainController controller = new MainController(view,model);
		view.setController(controller);

	}

}
