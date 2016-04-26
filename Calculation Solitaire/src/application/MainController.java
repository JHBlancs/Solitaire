package application;


import java.net.URL;
import java.util.Map;

import javax.annotation.Resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class MainController
{
	// declare variable for fxml document - ids for scenebuilder
	 @FXML
	 public Button cardChoose;
	 @FXML
	 public ImageView randCard;
	
	 
	 
	@FXML
	public void deckCardDisplay(ActionEvent event)
	{
		
		//Model deckOption = new Model();
		//deckOption.loadDeck();
		//randCard = new ImageView();
		
		Image image = new Image("/img/10_of_spades.png"); 
        randCard.setImage(image);
        

      //  setOnAction(new deckOptions<ActionEvent>();
       // HBox box = new HBox();
        //box.getChildren().add(randCard);
        //box.setAlignment(Pos.BOTTOM_CENTER);
        
        System.out.println("code found");
	}
	 
}
