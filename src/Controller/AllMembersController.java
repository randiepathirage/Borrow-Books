package Controller;

import Model.AllMembersModel;
import Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllMembersController implements Initializable {

    public AllMembersModel allMembersModel=new AllMembersModel();

    @FXML public TextField txtSearch;

    @FXML private TableView<Book> table;
    @FXML private TableColumn<Book,String> id;
    @FXML private TableColumn<Book,String> name;
    @FXML private TableColumn<Book,String> mobile;
    @FXML private TableColumn<Book,String> email;

    public ObservableList<Book> details = FXCollections.observableArrayList();

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
            scene.getStylesheets().add("/Main/main.css");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void search(ActionEvent event){
        try {
            if(allMembersModel.getBook(txtSearch.getText())){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/SearchMember.fxml"));
                root =loader.load();

                SearchMemberController searchMemberController =loader.getController();
                searchMemberController.displayDetails(txtSearch.getText());

                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                scene.getStylesheets().add("/Main/main.css");
                stage.setScene(scene);
                stage.show();

            }else {
                System.out.println("error");
            }

        } catch (IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allMembersModel.loadTable(details);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.setItems(details);
    }
}
