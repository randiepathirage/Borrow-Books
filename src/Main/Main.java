package Main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            Scene scene = new Scene(root);

            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //Image logo = new Image("icon.png");

        //logo
        //ImageView imageView = new ImageView(logo);
        //imageView.setX(20);
        //imageView.setY(20);
        //imageView.setFitHeight(60);
        //imageView.setFitWidth(60);

        //root.getChildren().add(imageView);

        //title text
        //Text title = new Text();
        //title.setText("Borrow-Books Library");
        //title.setX(90);
        //title.setY(50);
        //title.setFont(Font.font("verdana",20));
        //title.setFill(Color.rgb(9, 51, 63));

        //root.getChildren().add(title);

        //line
        //Line line = new Line();
        //line.setStartX(90);
        //line.setStartY(60);
        //line.setEndX(800);
        //line.setEndY(60);

        //root.getChildren().add(line);

        //primaryStage.getIcons().add(logo);

        primaryStage.setTitle("Library Management System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
