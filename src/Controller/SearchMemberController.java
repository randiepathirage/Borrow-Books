package Controller;

import Model.Book;
import Model.Member;
import Model.SearchMemberModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchMemberController implements Initializable {

    @FXML public TextField txtId;
    @FXML public TextField txtName;
    @FXML public TextField txtMobile;
    @FXML public TextField txtEmail;

    public ArrayList<Member> details = new ArrayList();
    public SearchMemberModel searchMemberModel=new SearchMemberModel();

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

    public void updateMember(ActionEvent event){
        try {
            if(searchMemberModel.isUpdate(txtId.getText(),txtName.getText(),txtMobile.getText(),txtEmail.getText())) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
                root = loader.load();


                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("/Main/main.css");
                stage.setScene(scene);
                stage.show();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void deleteMember(ActionEvent event){
        try {
            if(searchMemberModel.isDelete(txtId.getText())){
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void displayDetails(String id) {

        searchMemberModel.getDetails(id,details);

        txtId.setText(id);
        txtName.setText(String.valueOf(details.get(1)));
        txtEmail.setText(String.valueOf(details.get(2)));
        txtMobile.setText(String.valueOf(details.get(3)));
    }
}
