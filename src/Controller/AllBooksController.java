package Controller;

import Model.AllBooksModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AllBooksController {

    public AllBooksModel allBooksModel = new AllBooksModel();

    @FXML
    public TextField txtSearch;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void back(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
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

    public void search(ActionEvent event){
       /* try {

            if(allBooksModel.getBook(txtSearch.getText())) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/SearchBook.fxml"));
                root =loader.load();

                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else {
                System.out.println("error");
            }

        } catch (IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    }
}
