package soli;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application 
{

	private Stage primaryStage;
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) 
	{
		 this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("SolitaireApp");

	        initRootLayout();

	        showStartLayout();
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
	/**
	 * Shows the menu bar
	 */
	public void initRootLayout() 
    {
        try 
        {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	/**
     * Shows the person overview inside the root layout.
     */
    public void showStartLayout() 
    {
        try 
        {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StartLayout.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
