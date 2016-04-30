package application;

public class FoundationPile 
{
	/*
	 * Class: FoundationPile
	 * Created by: Joe Blanco
	 * Modified by: James Edwards, Miles Sakmar
	 * Summary: There are four FoundationPiles in the game, each with a unique multRule and topCard. 
	 * The topCard holds the current, well, top Card. This Card is ALWAYS a multiple of the multRule.
	 * The multRule determines what Card can be placed on top of the current topCard, by only 
	 * allowing cards whose rank is equal to (topCard.getRank() + multRule)
	 */
	Card topCard;
	int multRule;
	
	/*
	 * CONSTRUCTOR: sets multRule.
	 */
	public FoundationPile(int mr)
	{
		multRule = mr;
	}
	
	/*
	 * ACCESSORS: Access the multRule and topCard instance variables.
	 */
	public Card getTopCard()
	{
		return topCard;
	}
	
	public int getMultRule()
	{
		return multRule;
	}
	/*
	 * MUTATOR: Sets topCard, used at the start of the game
	 */
	public void setStartCard(Card c)
	{
		topCard = c;
	}
	
	/*
	 * placeTopCard: If the multRule is satisfied, places c onto topCard, deleting the last topCard.
	 */
	public void placeTopCard(Card c)
	{
		if(topCard.getRank() + multRule == c.getRank())
		{
			topCard = c;
			
		}
	}
	
	/*
	 * isDone: checks whether this pile is complete (if the topCard has a rank 13, then it is done)
	 */
	public boolean isDone()
	{
	if(topCard.getRank() == 13)
		return true;
	else return false;
	}
}
