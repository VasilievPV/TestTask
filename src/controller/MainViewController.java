package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.omg.CORBA.Environment;

import application.Constants;
import application.Store;
import application.Writer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainViewController implements Initializable
{
	@FXML
	private Button btn_Test;
	
	@FXML
	private void btn_Test_Click()
	{
		Store s = new Store();
		s.open();
		s.addDrink("NIMMIROFF", 90.3, "крепкие напитки", 0.5, 20, 40.0, null);
		s.addDrink("Наш Сок", 25, "Соки", 2.0, 35, 0, "Мякоть яблока", "E200", "E554");
		Writer.write("dataBase.csv", s.getProductRange());
		int a=0;
		a++;
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	}

}
