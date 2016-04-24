package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.AnchorPane;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

//import java.awt.event.ActionEvent;



public class CardGame extends Application
{

	
	public static void main(String [] args)
	{
		launch(args);
	}


	public void start(Stage primaryStage)throws Exception
	{
		//stage=primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Calculation Solitaire");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}