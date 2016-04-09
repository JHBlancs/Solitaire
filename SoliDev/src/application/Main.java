package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
//TESTEST
public class Main extends Application 
{
	int mult = 50;
    public static void main(String[] args) 
    {
    	
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("SoliTest!");
        Button btn = new Button();
        btn.setText("Start Game");
        btn.setMaxHeight(3.5*mult);
        btn.setMaxWidth(2.5*mult);
        btn.setOnAction(new EventHandler<ActionEvent>() 
        { 
 
            @Override
            public void handle(ActionEvent event) 
            {
                System.out.println("Start Game");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1200, 900));
        primaryStage.show();
    }
}