package controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.Constants;
import application.Reader;
import application.Store;
import application.Writer;
import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable
{
	private Store store;
	
	@FXML
	private Button btn_Test;
	@FXML
	private TextArea txtArea_Output;
	@FXML
	private TextArea txtArea_ProductRange;
	@FXML
	private TextField txtField_Profit;
	@FXML
	private TextField txtField_Date;
	@FXML
	private TextField txtField_Extracharge;
	@FXML
	Timer timer;
	
	@FXML
	private void btn_Test_Click()
	{
		this.store.cellProducts();
		this.store.purchaseExistingDrink("Первак", 100);
		//this.store.close();
		//s.cellProducts();
		/*s.addDrink("NIMMIROFF", 90.3, "крепкие напитки", 0.5, 20, 40.0, null);
		s.addDrink("Наш Сок яблочный", 25, "Соки", 2.0, 35, 0, "Мякоть яблока", "E200", "E554");
		s.addDrink("Наш Сок абрикосовый", 25, "Соки", 2.0, 35, 0, "Мякоть абрикоса", "E200", "E554");
		s.addDrink("Наш Сок апельсиновый", 25, "Соки", 2.0, 35, 0, "Мякоть апельсина", "E200", "E554");
		s.addDrink("Первак", 70.5, "крепкие напитки", 0.5, 30, 39.5, null);
		s.addDrink("Первак", 70.5, "крепкие напитки", 0.5, 30, 39.5, null);
		s.purchaseExistingDrink("NIMMIROFF", 10);
		s.close();
		//s.setProductRange(Reader.read(Constants.DATABASE_FILE_NAME));*/
		
		int a=0;
		a++;
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		this.store = new Store(this.txtArea_Output);
		this.txtField_Profit.textProperty().bind(this.store.getStatistics().getProfitProperty());
		this.txtField_Extracharge.textProperty().bind(this.store.getExtraChargeProperty());
		this.txtArea_ProductRange.textProperty().bind(this.store.getProductRangeProperty());
		
		this.timer = new Timer("Clocks");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, 5);
		Date now = calendar.getTime();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run()
			{
				txtField_Date.setText(Calendar.getInstance().getTime().toString());
			}
		}, now, 1000);
	}

}
