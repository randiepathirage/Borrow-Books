package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	Label lblWelcome;
	
	public void displayName(String username) {
		lblWelcome.setText("Welcome "+username);
	}
	
	
	public void logout(ActionEvent event){
		
		try {
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
