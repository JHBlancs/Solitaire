package application;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application 
{
	Deck d = new Deck();

	ArrayList<FoundationPile> fp = new ArrayList<FoundationPile>();
	ArrayList<WastePile> wp = new ArrayList<WastePile>();

	@Override
	public void start(Stage primaryStage) 
	{
		fp.add(new FoundationPile(1));
		fp.add(new FoundationPile(2));
		fp.add(new FoundationPile(3));
		fp.add(new FoundationPile(4));
		wp.add(new WastePile());
		wp.add(new WastePile());
		wp.add(new WastePile());
		wp.add(new WastePile());
		deal(fp, d);
		exampleMove1(fp, wp, d);
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public static void deal(ArrayList<FoundationPile> fp, Deck d)
	{
		for(int i = 1; i < 5; i++)
		{
			Card temp = d.remove(i); 
			System.out.println(temp.getRank());
			fp.get(i-1).setStartCard(temp);
			
		}
	}
	
	public static void exampleMove1(ArrayList<FoundationPile> fp, ArrayList<WastePile> wp, Deck d)
	{		
		String y = "";
		System.out.println("Choose a move!");
		Scanner in = new Scanner(System.in);
		y = in.next();
		switch(y){
		case "f1": {fp.get(0).placeTopCard(d.removeTop()); break;}
		case "f2": {fp.get(1).placeTopCard(d.removeTop()); break;}
		case "f3": {fp.get(2).placeTopCard(d.removeTop()); break;}
		case "f4": {fp.get(3).placeTopCard(d.removeTop()); break;}
		default: break;
		}
		System.out.println("meeep");
	}
}
