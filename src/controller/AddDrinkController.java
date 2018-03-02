package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddDrinkController extends Stage implements Initializable
{
	@FXML
	Button btn_Cancel;
	@FXML
	Button btn_Add;
	@FXML
	Button btn_AddAndExit;
	
	public AddDrinkController()
	{
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
