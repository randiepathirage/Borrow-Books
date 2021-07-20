package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Image logo = new Image("icon.png");
		
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
				
		primaryStage.getIcons().add(logo);
		
		primaryStage.setTitle("Library Management System");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
