package Controller;

import Model.AllBooksModel;
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

public class AllBooksController implements Initializable {

    public AllBooksModel allBooksModel = new AllBooksModel();

    @FXML public TextField txtSearch;

    @FXML private TableView<Book> table;
    @FXML private TableColumn<Book,String> id;
    @FXML private TableColumn<Book,String> title;
    @FXML private TableColumn<Book,String> author;
    @FXML private TableColumn<Book,String> publisher;
    @FXML private TableColumn<Book,String> status;

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
            if(allBooksModel.getBook(txtSearch.getText())){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/SearchBook.fxml"));
                root =loader.load();

                SearchBookController searchBookController =loader.getController();
                searchBookController.displayDetails(txtSearch.getText());

                //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                scene.getStylesheets().add("/Main/main.css");
                stage.setScene(scene);
                stage.show();
            }else {
                System.out.println("error");
            }

            } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allBooksModel.loadTable(details);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(details);

    }
}
