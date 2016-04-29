package application;


import java.net.URL;
import java.util.ArrayList;
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
	public Button deckMake;
	
	private ArrayList<Image> ia = new ArrayList<Image>();
	private int i;
	
	@FXML 
	public void makeDeck(ActionEvent event)
	{
		String[] suits = {"spades", "hearts", "clubs", "diamonds"};

		for(i = 1; i < 14; i++)
		{
			for(int j = 0; j < suits.length; j++)
			{
				String imageName = "/img/" + i + "_of_" + suits[j] + ".png";
				System.out.println(imageName);
				ia.add(new Image(imageName));
			}
		}
		i = 0;
	}
	
	@FXML
	public void deckCardDisplay(ActionEvent event)
	{
		
	    randCard.setImage(ia.get(i));
	    i++;
	    System.out.println("code found");
	}
	 
}
