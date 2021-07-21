package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
	public LoginModel loginModel = new LoginModel();
	@FXML
	public TextField txtUsername;
	@FXML
	public TextField txtPassword;
	@FXML
	Label lblStatus;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent event){
		
		try {
			if(loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) {
				lblStatus.setText("Login success");
			}else {
				lblStatus.setText("Incorrect username and password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
		try {
			root =loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HomeController homeController =loader.getController();
		homeController.displayName(txtUsername.getText());
		
		//root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
	}
}
