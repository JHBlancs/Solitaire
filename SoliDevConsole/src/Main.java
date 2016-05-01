import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
	static Deck d;
	static ArrayList<FoundationPile> fp;
	static ArrayList<Pile> wp;
	static Scanner in;
	public static void main(String[] args)
	{
		System.out.print("Welcome to Calculation Solitaire!");
		helpSplashStart();
		d = new Deck();
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
		while(gameEndCheck())
		{
			displayGame();
			System.out.println("Input: ");
			String s = in.next();
			switch(s)
			{
				case "f1":
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
				case "w1":
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
				case "h":
				{
					helpSplash();
					break;
				}
				case "w":
				{
					wastePilePlace();
					break;
				}
				default:
				{
					System.out.print("Sorry, this move is illegal!");
				}
			}
            System.out.print("=======================================================================");
		}		
	}

	public static void deal()
	{
		for(int i = 1; i < 5; i++)
		{
			Card temp = d.removeOneOfRank(i); 
			fp.get(i-1).setStartCard(temp);
		}
	}
	
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
				"Type \'h\' for help!"
				);
	}
	/*
	 * displayGame(): Refreshes the screen for the player.
	 */
	public static void displayGame()
	{
		System.out.println("Game Board: \n");
		System.out.println("F.P. 1: " + fp.get(0).getTopCard().getRank() + " of " + fp.get(0).getTopCard().getSuit() + " | " + 
							"F.P. 2: " + fp.get(1).getTopCard().getRank() + " of " + fp.get(1).getTopCard().getSuit() + " | " + 
							"F.P. 3: " + fp.get(2).getTopCard().getRank() + " of " + fp.get(2).getTopCard().getSuit() + " | " + 
							"F.P. 4: " + fp.get(3).getTopCard().getRank() + " of " + fp.get(3).getTopCard().getSuit());
		if(wp.get(0).getPileSize() == 0)
		{
			System.out.print("W.P. 1: Empty");
		}
		else
		{
			System.out.print("W.P. 1: " + wp.get(0).getTopCard().getRank() + " of " + wp.get(0).getTopCard().getSuit() + " | ");
		}
		System.out.print(" | ");
		if(wp.get(1).getPileSize() == 0)
		{
			System.out.print("W.P. 2: Empty");
		}
		else
		{
			System.out.print("W.P. 2: " + wp.get(1).getTopCard().getRank() + " of " + wp.get(1).getTopCard().getSuit() + " | ");
		}
		System.out.print(" | ");
		if(wp.get(2).getPileSize() == 0)
		{
			System.out.print("W.P. 3: Empty");
		}
		else
		{
			System.out.print("W.P. 3: " + wp.get(2).getTopCard().getRank() + " of " + wp.get(2).getTopCard().getSuit() + " | ");
		}
		System.out.print(" | ");
		if(wp.get(3).getPileSize() == 0)
		{
			System.out.print("W.P. 4: Empty");
		}
		else
		{
			System.out.print("W.P. 4: " + wp.get(3).getTopCard().getRank() + " of " + wp.get(3).getTopCard().getSuit() + " | ");
		}
		System.out.print("\n");
		if(d.getCount() == 0)
		{
			System.out.print("Deck: Empty");
		}
		else
		{
			System.out.print("Deck: " + d.getTop().getRank() + " of " +d.getTop().getSuit());
		}		
		System.out.print("\n");
	}
	/*
	 * wastePilePlace: Steps the user through selecting a Waste Pile to place the Card onto, then does so.
	 */
	public static void wastePilePlace()
	{
		String s = "";
		Pile temp = null;
		System.out.println("Which Waste Pile do you want to select? (w1-w4): ");
		s = in.next();
		switch(s)
		{
			case "w1": 
			{
				if(wp.get(0).getPileSize() != 0)
					temp = wp.get(0);
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
			case "w2": 
			{
				if(wp.get(1).getPileSize() != 0)
					temp = wp.get(1);
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
			case "w3": 
			{
				if(wp.get(2).getPileSize() != 0)
					temp = wp.get(2);
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
			case "w4": 
			{
				if(wp.get(3).getPileSize() != 0)
					temp = wp.get(3);
				else 
					System.out.println("Sorry, this Waste Pile has no Cards to place!");
				break;
			}
		}
		System.out.println("Which Foundation Pile do you want to select? (f1-f4): ");
		s = in.next();
		switch(s)
		{
			case "f1": 
			{
				fp.get(0).placeCard(temp.removeCard());
				break;
			}
			case "w2": 
			{
				fp.get(1).placeCard(temp.removeCard());
				break;
			}
			case "w3": 
			{
				fp.get(2).placeCard(temp.removeCard());
				break;
			}
			case "w4": 
			{
				fp.get(3).placeCard(temp.removeCard());
				break;
			}
		}
	}
	/*
	 * gameEndCheck(): true if the game is still going on, false if there are no more moves.
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
}
