package controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.Constants;
import application.Reader;
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
		/*s.addDrink("NIMMIROFF", 90.3, "крепкие напитки", 0.5, 20, 40.0, null);
		s.addDrink("Наш Сок яблочный", 25, "Соки", 2.0, 35, 0, "Мякоть яблока", "E200", "E554");
		s.addDrink("Наш Сок абрикосовый", 25, "Соки", 2.0, 35, 0, "Мякоть абрикоса", "E200", "E554");
		s.addDrink("Наш Сок апельсиновый", 25, "Соки", 2.0, 35, 0, "Мякоть апельсина", "E200", "E554");
		s.addDrink("Первак", 70.5, "крепкие напитки", 0.5, 30, 39.5, null);
		s.addDrink("Первак", 70.5, "крепкие напитки", 0.5, 30, 39.5, null);
		s.purchaseExistingDrink("NIMMIROFF", 10);
		Writer.write("dataBase.csv", s.getProductRange());
		s.setProductRange(Reader.read(Constants.DATABASE_FILE_NAME));
		
		int a=0;
		a++;*/
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	}

}
