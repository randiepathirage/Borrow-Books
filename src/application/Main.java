package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Group root =new Group();
		Scene scene = new Scene(root,Color.rgb(9, 51, 63));
		
		Text title = new Text();
		title.setText("Borrow Books Library");
		title.setX(10);
		title.setY(10);
		
		Image logo = new Image("icon.png");
		
		primaryStage.getIcons().add(logo);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Library Management System");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
