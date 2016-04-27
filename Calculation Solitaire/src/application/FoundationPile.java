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
	 * placeTopCard: If the multRule is satisfied, places c onto topCard, deleting the last topCard.
	 */
	public void placeTopCard(Card c)
	{
		if(topCard.getRank() + multRule == c.getRank())
			topCard = c;
	}
}
