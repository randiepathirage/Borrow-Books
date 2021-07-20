package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	TextField txtUsername;
	@FXML
	TextField txtPassword;
	@FXML
	Label lblStatus;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent event){
		try {
			String username = txtUsername.getText();
			String password = txtPassword.getText();
					
			if(username.equals("") && password.equals("") ) {
				lblStatus.setText("Login Scuess");
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
				root =loader.load();
				
				HomeController homeController =loader.getController();
				homeController.displayName(username);
				
				//root = FXMLLoader.load(getClass().getResource("Home.fxml"));
				stage =(Stage)((Node)event.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
				
			}else {
				lblStatus.setText("Login Fail");
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
