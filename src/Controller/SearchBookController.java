package Controller;

import Model.Member;
import Model.SearchBookModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SearchBookController {

    public SearchBookModel searchBookModel =new SearchBookModel();
    public ArrayList<Member> details = new ArrayList();

    @FXML public TextField txtCode;
    @FXML public TextField txtTitle;
    @FXML public TextField txtAuthor;
    @FXML public TextField txtPublisher;

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

    public void updateBook(ActionEvent event){
        try {

            if(searchBookModel.isUpdate(txtCode.getText())){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
                root =loader.load();


                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                scene.getStylesheets().add("/Main/main.css");
                stage.setScene(scene);
                stage.show();

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void deleteBook(ActionEvent event){
        try {

            if(searchBookModel.isDelete(txtCode.getText())){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
                root =loader.load();


                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                scene.getStylesheets().add("/Main/main.css");
                stage.setScene(scene);
                stage.show();

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error");
        }

    }

    public void displayDetails(String id) {

        searchBookModel.getDetails(id,details);

        txtCode.setText(id);
        txtTitle.setText(String.valueOf(details.get(1)));
        txtAuthor.setText(String.valueOf(details.get(2)));
        txtPublisher.setText(String.valueOf(details.get(3)));
    }

}
