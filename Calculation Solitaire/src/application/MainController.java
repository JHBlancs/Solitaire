package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class MainController extends Application
{
	Deck d;
	ArrayList<FoundationPile> fp;
	ArrayList<Pile> wp;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		d = new Deck();
		fp = new ArrayList<FoundationPile>();
		wp = new ArrayList<Pile>();
		fp.add(new FoundationPile(1));
		fp.add(new FoundationPile(2));
		fp.add(new FoundationPile(3));
		fp.add(new FoundationPile(4));
		wp.add(new Pile());
		wp.add(new Pile());
		wp.add(new Pile());
		wp.add(new Pile());
		deal(fp, d);
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Calculation Solitaire");
		primaryStage.setScene(scene);
		primaryStage.show();
		refresh();
	}
	

	
	// declare variable for fxml document - ids for scenebuilder
	@FXML
	public Button cardChoose;
	@FXML
	public ImageView randCard;
	@FXML
	public Button foundationPileButton1;
	@FXML
	public ImageView foundationPileImage1;
	@FXML
	public Button foundationPileButton2;
	@FXML
	public ImageView foundationPileImage2;	
	@FXML
	public Button foundationPileButton3;
	@FXML
	public ImageView foundationPileImage3;	
	@FXML
	public Button foundationPileButton4;
	@FXML
	public ImageView foundationPileImage4;	
	@FXML
	public Button wastePileButton1;
	@FXML
	public ImageView wastePileImage1;
	@FXML
	public Button wastePileButton2;
	@FXML
	public ImageView wastePileImage2;	
	@FXML
	public Button wastePileButton3;
	@FXML
	public ImageView wastePileImage3;	
	@FXML
	public Button wastePileButton4;
	@FXML
	public ImageView wastePileImage4;	
	@FXML
	public Button deckButton;
	@FXML
	public ImageView deckImage;
	@FXML
	public Button topCardButton;
	@FXML
	public ImageView topCardImage;
	

	public static void deal(ArrayList<FoundationPile> fp, Deck d)
	{
		for(int i = 1; i < 5; i++)
		{
			Card temp = d.removeOneOfRank(i); 
			//System.out.println(temp.getRank());
			fp.get(i-1).setStartCard(temp);
		}
	}
	public void refresh()
	{
		System.out.println(foundationPileImage1);
		foundationPileImage1.setImage(fp.get(0).getTopCard().getImage());
		foundationPileImage2.setImage(fp.get(1).getTopCard().getImage());
		foundationPileImage3.setImage(fp.get(2).getTopCard().getImage());
		foundationPileImage4.setImage(fp.get(3).getTopCard().getImage());
		if(wp.get(0).getTopCard() != null)
		{
			wastePileImage1.setImage(wp.get(0).getTopCard().getImage());
			wastePileImage2.setImage(wp.get(1).getTopCard().getImage());
			wastePileImage3.setImage(wp.get(2).getTopCard().getImage());
			wastePileImage4.setImage(wp.get(3).getTopCard().getImage());
		}

	}
	
	@FXML
	public void clickTopCard(ActionEvent event)
	{
		
	}
	@FXML
	public void clickCheckPile(ActionEvent event)
	{
		
	}
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
