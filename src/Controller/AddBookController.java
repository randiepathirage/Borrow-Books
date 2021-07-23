package Controller;

import Model.AddBookModel;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {

    public AddBookModel addBookModel = new AddBookModel();
    @FXML
    public TextField txtCode;
    @FXML
    public TextField txtTitle;
    @FXML
    public TextField txtAuthor;
    @FXML
    public TextField txtPublisher;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void cancel(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
            root =loader.load();


            //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            scene.getStylesheets().add("/Main/main.css");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void addBook(ActionEvent event){
        try {
            if(addBookModel.isBookAdded(txtCode.getText(), txtTitle.getText(),txtAuthor.getText(),txtPublisher.getText(),"available")) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Home.fxml"));
                try {
                    root =loader.load();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                HomeController homeController =loader.getController();
                homeController.displayName("Book Added");

                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow(); // open the next window in the curent window
                scene=new Scene(root);
                scene.getStylesheets().add("/Main/main.css");
                stage.setScene(scene);
                stage.show();
            }else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
