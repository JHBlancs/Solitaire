

import java.util.ArrayList;

public class Deck 
{
	/*
	 * Class: Deck
	 * Created by: Joe Blanco
	 * Modified by: James Edwards, Miles Sakmar
	 * Summary: This class holds the 52 Cards of a full deck at the initialization of the game.
	 * Instance variables are: an ArrayList of Cards, an array of Suits and a counter. The counter keeps track of how many Cards are in the Deck. 
	 */
	private ArrayList<Card> d;
	private String[] suits = {"spades", "hearts", "clubs", "diamonds"};
	int counter = 0;
	/*
	 * CONSTRUCTOR: Initialized at the start of the game, this creates a Deck of 52 unique playing Cards. It also initializes the counter.
	 */
	public Deck()
	{
		d = new ArrayList<Card>();
		for(int i = 1; i < 14; i++)
		{
			for(int j = 0; j < suits.length; j++)
			{
				d.add(new Card(suits[j], i));
				counter++;
			}
		}
	}
	/*
	 * ACCESSORS: These return values of instance variables.
	 */
	public int getCount()
	{
		return counter;
	}
	
	public Card getTop()
	{
		return d.get(counter-1);
	}
	
	/*
	 * removeTop(): Returns the top card and deletes it from this Deck instance.
	 */
	public Card removeTop()
	{
		Card temp = d.get(counter-1);
		d.remove(counter-1);
		counter--;
		return temp;
	}
	/*
	 * remove: used for starting the game; removes a Card of specified rank from the Deck.
	 */
	public Card removeOneOfRank(int r)
	{
		Card temp = null;
		for(int i = 0; i < counter; i++)
		{
			if(d.get(i).getRank() == r)
			{
				temp = d.get(i);
			}
		}
		return temp;
	}
	
	/*
	 * isEmpty(): returns whether or not this Deck is empty.
	 */
	public boolean isEmpty()
	{
		return (counter == 0);
	}
}
