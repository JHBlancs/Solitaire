package application;

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
	
	/*
	 * removeTop(): returns the top Card. Does not actually delete the top Card, just moves past it. The counter instance variable assures this
	 * Card will not be duplicated in meaningful play. 
	 */
	public Card removeTop()
	{
		Card temp = d.get(counter);
		d.remove(counter);
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
