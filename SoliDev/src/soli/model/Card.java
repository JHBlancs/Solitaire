package soli.model;



public class Card 
{

	private String suit;
	private int rank;
	public Card(String s, int r)
	{
		suit = s;
		rank = r;
	}
	
	public int getRank()
	{
		return rank;
	}
	public String getSuit()
	{
		return suit;
	}
}
