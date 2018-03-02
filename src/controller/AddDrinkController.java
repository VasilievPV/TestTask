package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddDrinkController extends Stage implements Initializable
{
	private Store store;
	
	@FXML
	private Button btn_Cancel;
	@FXML
	private Button btn_Add;
	@FXML
	private Button btn_AddAndExit;
	
	@FXML
	private TextField txtField_Name;
	@FXML
	private TextField txtField_Price;
	@FXML
	private TextField txtField_Kind;
	@FXML
	private TextField txtField_Volume;
	@FXML
	private TextField txtField_Amount;
	@FXML
	private TextField txtField_AlcoAmount;
	@FXML
	private TextArea txtArea_Composition;
	
	
	public AddDrinkController(Store store)
	{
		this.store = store;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AddDrinkView.fxml"));
		loader.setController(this);
		try
		{
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			this.setScene(scene);
			this.showAndWait();
		}
		catch(IOException e)
		{
			throw new RuntimeException();
		}
	}
	
	@FXML
	public void btn_Add_Click()
	{
		try
		{
			String name = this.txtField_Name.getText();
			
			if (this.store.getProductRange().containsKey(name))
			{
				this.store.printReport("Drink \"" + name + "\" already exists!");
				return;
			}
			
			double price = Double.parseDouble(this.txtField_Price.getText());
			String kind = this.txtField_Kind.getText();
			double volume = Double.parseDouble(this.txtField_Volume.getText());
			int amount = Integer.parseInt(this.txtField_Amount.getText());
			double alcoAmount = Double.parseDouble(this.txtField_AlcoAmount.getText());
			String[] composition = this.txtArea_Composition.getText().split("\n");
			if (this.txtArea_Composition.getText().equals(""))
				composition = null;
			
			this.store.addDrink(name, price, kind, volume, amount, alcoAmount, composition);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@FXML
	public void btn_AddAndExit_Click()
	{
		
	}
	@FXML
	public void btn_Cancel_Click()
	{
		this.close();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	}

}
