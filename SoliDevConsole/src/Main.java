import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
	static Deck d;
	static ArrayList<FoundationPile> fp;
	static ArrayList<Pile> wp;
	static Scanner in;
	static String[][] emptyCard =  {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};
	static String[][] deckCard =   {{"d", "e", "c", "k", "d", "e", "c", "k", "d", "e"},
									{"c", "k", "d", "e", "c", "k", "d", "e", "c", "k"},
									{"d", "e", "c", "k", "d", "e", "c", "k", "d", "e"},
									{"c", "k", "d", "e", "c", "k", "d", "e", "c", "k"},
									{"d", "e", "c", "k", "d", "e", "c", "k", "d", "e"},
									{"c", "k", "d", "e", "c", "k", "d", "e", "c", "k"},
									{"d", "e", "c", "k", "d", "e", "c", "k", "d", "e"}};
			
	public static void main(String[] args)
	{
		System.out.print("Welcome to Calculation Solitaire!");
		helpSplashStart();
		d = new Deck(); 						//Initializes Piles and Deck, and populates them. 
		fp = new ArrayList<FoundationPile>();
		wp = new ArrayList<Pile>();
		in = new Scanner(System.in);
		fp.add(new FoundationPile(1)); 
		fp.add(new FoundationPile(2));
		fp.add(new FoundationPile(3));
		fp.add(new FoundationPile(4));
		wp.add(new Pile());
		wp.add(new Pile());
		wp.add(new Pile());
		wp.add(new Pile());
		deal(); 
		while(gameEndCheck()) //The iteration of a game
		{
			displayGame();
			System.out.println("Input: ");
			String s = in.next();
			switch(s)
			{
				case "f1":					//Foundation choices
				{
					if(fp.get(0).cardRuleCheck(d.getTop().getRank()))
						fp.get(0).placeCard(d.removeTop());
					break;
				}
				case "f2":
				{
					if(fp.get(1).cardRuleCheck(d.getTop().getRank()))
						fp.get(1).placeCard(d.removeTop());
					break;
				}
				case "f3":
				{
					if(fp.get(2).cardRuleCheck(d.getTop().getRank()))
						fp.get(2).placeCard(d.removeTop());
					break;
				}
				case "f4":
				{
					if(fp.get(3).cardRuleCheck(d.getTop().getRank()))
						fp.get(3).placeCard(d.removeTop());
					break;
				}
				case "w1":			//Waste choices
				{
					wp.get(0).placeCard(d.removeTop());
					break;
				}
				case "w2":
				{
					wp.get(1).placeCard(d.removeTop());
					break;
				}
				case "w3":
				{
					wp.get(2).placeCard(d.removeTop());
					break;
				}
				case "w4":
				{
					wp.get(3).placeCard(d.removeTop());
					break;
				}
				case "h":			//Help choice
				{
					helpSplash();
					break;
				}
				case "w":			//move from waste pile choice
				{
					wastePilePlace();
					break;
				}
				default:			//error message
				{
					System.out.print("Sorry, this move is illegal!");
				}
			}
            System.out.print("=================================================" + "\n");
		}	
		checkEndGame();
	}
	/*
	 * deal(): Sets up the game by dealing the FoundationPiles their starting Cards
	 */
	public static void deal()
	{
		for(int i = 1; i < 5; i++)
			
		{
			Card temp = d.removeOneOfRank(i); 
			fp.get(i-1).setStartCard(temp);
		}
	}
	/*
	 * helpSplashStart(): help screen that immediately cuts to the game board.
	 */
	public static void helpSplashStart()
	{
		System.out.println("\n" +
				"Rules: You need to get all four Kings on the top of the Foundation Piles. " + "\n" + 
				"Foundations are as follows: \nAce Pile goes up by 1's: A,2,3,4,5,6,7,8,9,10,J,Q,K" + "\n" +
				"Two Pile goes up by 2's: 2,4,6,8,10,Q,A,3,5,7,9,J,K" + "\n" + 
				"Three Pile goes up by 3's: 3,6,9,Q,2,5,8,J,A,4,7,10,K" + "\n" +
				"Four Pile goes up by 4's: 4,8,Q,3,7,J,2,6,10,A,5,9,K" + "\n" + 
				"Cards can go Deck -> Foundation Pile, Deck -> Waste Pile, or Waste Pile -> Foundation Pile" +"\n" +
				"Type \'f1-f4\' to place the Card from the Deck on to a Foundation Pile " + "\n" +
				"Type \'w1-w4\' to place the Card from the Deck on to a Waste Pile " + "\n" +
				"Type \'w\' to place a Card from one of the Waste Piles!" + "\n" +
				"Type \'h\' for help!"
				);
	}
	/*
	 * helpSplash(): help screen that asks for input before cutting back to the game board.
	 */
	public static void helpSplash()
	{
		System.out.println("\n" +
				"Rules: You need to get all four Kings on the top of the Foundation Piles. " + "\n" + 
				"Foundations are as follows: \nAce Pile goes up by 1's: A,2,3,4,5,6,7,8,9,10,J,Q,K" + "\n" +
				"Two Pile goes up by 2's: 2,4,6,8,10,Q,A,3,5,7,9,J,K" + "\n" + 
				"Three Pile goes up by 3's: 3,6,9,Q,2,5,8,J,A,4,7,10,K" + "\n" +
				"Four Pile goes up by 4's: 4,8,Q,3,7,J,2,6,10,A,5,9,K" + "\n" + 
				"Cards can go Deck -> Foundation Pile, Deck -> Waste Pile, or Waste Pile -> Foundation Pile" +"\n" +
				"Type \'f1-f4\' to place the Card from the Deck on to a Foundation Pile " + "\n" +
				"Type \'w1-w4\' to place the Card from the Deck on to a Waste Pile " + "\n" +
				"Type \'w\' to place a Card from one of the Waste Piles!" + "\n" +
				"Type \'h\' for help!" + "\n" +
				"Give any input to go back to the game..."
				);
		in.next();
		
	}
	/*
	 * displayGame(): Refreshes the screen for the player.
	 */
	public static void displayGame()
	{
		String[][][] Cards = new String[4][][]; 		//temp holding place for Card image arrays.
		Cards[0] = fp.get(0).getTopCard().getImage(); 
		Cards[1] = fp.get(1).getTopCard().getImage();
		Cards[2] = fp.get(2).getTopCard().getImage();
		Cards[3] = fp.get(3).getTopCard().getImage();
		for(int i = 0; i < 7; i++)						//prints FoundationPile Card images
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[0][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[1][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[2][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[3][i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("=================================================" + "\n");
		if(wp.get(0).getPileSize() != 0)				//prints WastePile card images. If the WastePile is empty, takes the emptyCard array.
		{
		Cards[0] = wp.get(0).getTopCard().getImage();
		}
		else
		{
			Cards[0] = emptyCard;
		}
		if(wp.get(1).getPileSize() != 0)
		{
			Cards[1] = wp.get(1).getTopCard().getImage();
		}
		else
		{
			Cards[1] = emptyCard;
		}
		if(wp.get(2).getPileSize() != 0)
		{
			Cards[2] = wp.get(2).getTopCard().getImage();
		}
		else
		{
			Cards[2] = emptyCard;
		}
		if(wp.get(3).getPileSize() != 0)
		{
			Cards[3] = wp.get(3).getTopCard().getImage();
		}
		else
		{
			Cards[3] = emptyCard;
		}
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[0][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[1][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[2][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[3][i][j]);
			}
			System.out.print("\n");
		}
		if(d.getCount() >= 1)				//If the Deck is populated, deck card image and topCard image will be shown.
		{
		Cards[0] = deckCard;
		Cards[1] = d.getTop().getImage();
		}
		else if(d.getCount() == 1)			//If the Deck has one Card left, the emptyCard and topCard will be shown.
		{
			Cards[0] = emptyCard;
			Cards[1] = d.getTop().getImage();
		}
		else								//if the Deck is empty, two emptyCards will be shown.
		{
			Cards[0] = emptyCard;
			Cards[1] = emptyCard;
		}
		for(int i = 0; i < 7; i++)
		{
			System.out.print("|            ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[0][i][j]);
			}
			System.out.print(" | ");
			for(int j = 0; j < 10; j++)
			{
				System.out.print(Cards[1][i][j]);
			}
			System.out.print("\n");
		}
		
	}
	/*
	 * wastePilePlace: Steps the user through selecting a Waste Pile to place the Card onto, then does so.
	 */
	public static void wastePilePlace()
	{
		String s = "";
		System.out.println("Which Waste Pile do you want to select? (w1-w4): ");
		s = in.next();
		switch(s)
		{
			case "w1": 
			{
				if(wp.get(0).getPileSize() != 0)
					wastePileOneMove();
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
			case "w2": 
			{
				if(wp.get(1).getPileSize() != 0)
					wastePileTwoMove();
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
			case "w3": 
			{
				if(wp.get(2).getPileSize() != 0)
					wastePileThreeMove();
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
			case "w4": 
			{
				if(wp.get(3).getPileSize() != 0)
					wastePileFourMove();
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
		}
	}
	public static void wastePileOneMove()
	{
		System.out.println("Which Foundation Pile do you want to select? (f1-f4): ");
		String s = in.next();
		switch(s)
		{
			case "f1": 
			{
				fp.get(0).placeCard(wp.get(0).removeCard());
				break;
			}
			case "f2": 
			{
				fp.get(1).placeCard(wp.get(0).removeCard());
				break;
			}
			case "f3": 
			{
				fp.get(2).placeCard(wp.get(0).removeCard());
				break;
			}
			case "f4": 
			{
				fp.get(3).placeCard(wp.get(0).removeCard());
				break;
			}
		}
	}
	public static void wastePileTwoMove()
	{
		System.out.println("Which Foundation Pile do you want to select? (f1-f4): ");
		String s = in.next();
		switch(s)
		{
			case "f1": 
			{
				fp.get(0).placeCard(wp.get(1).removeCard());
				break;
			}
			case "f2": 
			{
				fp.get(1).placeCard(wp.get(1).removeCard());
				break;
			}
			case "f3": 
			{
				fp.get(2).placeCard(wp.get(1).removeCard());
				break;
			}
			case "f4": 
			{
				fp.get(3).placeCard(wp.get(1).removeCard());
				break;
			}
		}
	}
	public static void wastePileThreeMove()
	{
		System.out.println("Which Foundation Pile do you want to select? (f1-f4): ");
		String s = in.next();
		switch(s)
		{
			case "f1": 
			{
				fp.get(0).placeCard(wp.get(2).removeCard());
				break;
			}
			case "f2": 
			{
				fp.get(1).placeCard(wp.get(2).removeCard());
				break;
			}
			case "f3": 
			{
				fp.get(2).placeCard(wp.get(2).removeCard());
				break;
			}
			case "f4": 
			{
				fp.get(3).placeCard(wp.get(2).removeCard());
				break;
			}
		}
	}
	public static void wastePileFourMove()
	{
		System.out.println("Which Foundation Pile do you want to select? (f1-f4): ");
		String s = in.next();
		switch(s)
		{
			case "f1": 
			{
				fp.get(0).placeCard(wp.get(3).removeCard());
				break;
			}
			case "f2": 
			{
				fp.get(1).placeCard(wp.get(3).removeCard());
				break;
			}
			case "f3": 
			{
				fp.get(2).placeCard(wp.get(3).removeCard());
				break;
			}
			case "f4": 
			{
				fp.get(3).placeCard(wp.get(3).removeCard());
				break;
			}
		}
	}
	/*
	 * gameEndCheck(): true if the game is still going on, false if there are no more valid moves.
	 */
	public static boolean gameEndCheck()
	{
		boolean ans = false;
		if(d.getCount() ==0)
		{
			for(int i = 0; i < 4; i++)
			{
				for(int j = 0; j < 4; j++)
				{
					if(fp.get(i).cardRuleCheck(wp.get(j).getTopCard().getRank()))
					{
						ans = true;
						break;
					}
				}
			}
		}
		else
		{
			ans = true;
		}
		return ans;
	}
	
	/*
	 * checkEndGame(): Checks the status of the endgame. Triggered when gameEndCheck's cycle says there are no more valid moves.
	 * If all four Foundation Piles have a topCard value of 13, a victory scenario has occurred. In all other cases, a loss scenario has occurred. 
	 * Either way, the user will be notified through a message.
	 */
	public static void checkEndGame()
	{
		if(fp.get(0).isDone() && fp.get(1).isDone() && fp.get(2).isDone() && fp.get(3).isDone())
		{
			System.out.println("Congratulations, you've won!");
		}
		else 
		{
			System.out.println("Sorry, you've lost!");
		}
	}
}
