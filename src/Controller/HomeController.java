package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Model.HomeModel;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    public HomeModel homeModel = new HomeModel();

    @FXML
    public Label lblStatus;
    @FXML
    public TextField txtBookId;
    @FXML
    public TextField txtMemberId;
    @FXML
    public TextField txtDate;
    @FXML
    public TextField txtBookId2;
    @FXML
    public TextField txtMemberId2;
    @FXML
    public TextField txtDate2;
    @FXML
    public Label lblStatus2;

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


    public void addBook(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AddBook.fxml"));
            root =loader.load();


            //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void allBooks(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AllBooks.fxml"));
            root =loader.load();


            //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void addMember(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AddMember.fxml"));
            root =loader.load();


            //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void allMembers(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AllMembers.fxml"));
            root =loader.load();


            //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void issueBook(ActionEvent event){
        try {
            if(homeModel.isBookIssued(txtBookId.getText(), txtMemberId.getText(),txtDate.getText())) {
                lblStatus.setText("Book issued");

            }else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void isReturnBook(ActionEvent event){
        try {
            if(homeModel.isReturnBook(txtBookId2.getText(), txtMemberId2.getText(),txtDate2.getText())) {
                lblStatus2.setText("Book returned");

            }else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
