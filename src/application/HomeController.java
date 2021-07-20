package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	Label lblWelcome;
	
	@FXML 
	private AnchorPane sceneHome;
	
	public void displayName(String username) {
		lblWelcome.setText("Welcome "+username);
	}
	
	
	public void logout(ActionEvent event){
		
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Are you sure you want to logout");
			
			if(alert.showAndWait().get() == ButtonType.OK) {
				//root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				stage =(Stage)sceneHome.getScene().getWindow();
				stage.close();

			}
		

	}

}
