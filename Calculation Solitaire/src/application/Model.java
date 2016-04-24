package application;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Model 
{
		
	public void loadDeck()
	{    	
		
		
	        //StackPane root = new StackPane();
	      //  int randCard = (int) (Math.random() * 52);
	       // ImageView newCard = new ImageView(new Image("src/img/"+(++randCard)+".png"));
	        // root.add(newCard);
	                        
	       //  Image card = new Image("src/img/"+(++randCard)+".png");
	//	ImageView card = new ImageView(getClass().getResource("src/img/1.png").toExternalForm());
	         	//Image card = new Image("/src/deck/1.png");
	        	
	        	//ImageView iv1 = new ImageView();
	       
	        	//Image card = new Image("10.png");
	         	//iv1.setImage(card);
	         	
	         //	root.getChildren().add(new ImageView(card));
	         	
	         //	root.getChildren().add(iv1);

	         	//root.add(card);
	
	        
	     // load the image
	         Image image = new Image("/10.png");
	 
	         // simple displays ImageView the image as is
	         ImageView iv1 = new ImageView();
	         iv1.setImage(image);
	       //  setOnAction(new deckOptions<ActionEvent>();
	         HBox box = new HBox();
	         box.getChildren().add(iv1);
	         box.setAlignment(Pos.BOTTOM_CENTER);

	         System.out.println("looking over code");
	}
	
	
	
}
