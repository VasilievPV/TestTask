package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
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

public class MainViewController implements Initializable
{
	private Store store;
	
	@FXML
	private Button btn_Test;
	@FXML
	private TextArea txtArea_Output;
	
	@FXML
	private void btn_Test_Click()
	{
		this.store.cellProducts();
		//s.cellProducts();
		/*s.addDrink("NIMMIROFF", 90.3, "������� �������", 0.5, 20, 40.0, null);
		s.addDrink("��� ��� ��������", 25, "����", 2.0, 35, 0, "������ ������", "E200", "E554");
		s.addDrink("��� ��� �����������", 25, "����", 2.0, 35, 0, "������ ��������", "E200", "E554");
		s.addDrink("��� ��� ������������", 25, "����", 2.0, 35, 0, "������ ���������", "E200", "E554");
		s.addDrink("������", 70.5, "������� �������", 0.5, 30, 39.5, null);
		s.addDrink("������", 70.5, "������� �������", 0.5, 30, 39.5, null);
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
		this.store.open();
	}

}
