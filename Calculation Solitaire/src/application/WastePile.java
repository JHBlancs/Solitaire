package application;

import java.util.ArrayList;

public class WastePile 
{
	/*
	 * Class: WastePile
	 * Created By: Joe Blanco
	 * Modified by: Miles Sakmar, James Edwards
	 * Summary: A class with an ArrayList of Cards, starting empty. This WastePile can have Cards added or removed from it, an keeps track of the Cards on it.
	 */
	private ArrayList<Card> pile;
	private int pileSize;
	
	/*
	 * CONSTRUCTOR: initializes a new, empty WastePile. 
	 */
	public WastePile()
	{
		pile = new ArrayList<Card>();
		pileSize = 0;
	}
	
	/*
	 * ACCESSORS: Methods to access instance variables topCard and pileSize
	 */
	public Card getTopCard()
	{
		return pile.get(pile.size()-1);
	}
	
	public int getPileSize()
	{
		return pileSize;
	}
	
	/*
	 * placeCard: Places a new top Card at the end of the ArrayList, appends pileSize by one.
	 */
	public void placeCard(Card c)
	{
		pile.add(c);
		pileSize++;
	}
	
	/*
	 * removeCard: removes the top Card, lessens pileSize by one
	 */
	public Card removeCard()
	{
		Card temp = pile.get(pile.size()-1);
		pile.remove(pile.size()-1);
		pileSize--;
		return temp;
	}
	
}
