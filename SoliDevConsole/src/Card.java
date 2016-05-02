public class Card 
{
	/*
	 * Class: Card
	 * Created by: Joe Blanco
	 * Summary: A Card has suit and rank, and an Image attached to these values. Behind the scenes, the suit and rank will be used. 
	 * On the console, the image will be the only identifier of the card's suit and rank.  
	 */
	private String suit;
	private int rank;
	private String[][] image;
	/*
	 * CONSTRUCTOR: Loads in a Card's suit and rank, and makes filepath text from these two values 
	 * (e.g., the 9 of spades will create a filepath "/img/9_of_spades.png")
	 */
	public Card(String s, int r, String[][] i)
	{
		suit = s;
		rank = r;
		image = i;
	}
	/*
	 * ACCESSORS: Each function allows accessing of a separate class of this Card's instance variables: rank, suit and Image.
	 */
	public String getSuit()
	{
		return suit;
	}
	public int getRank()
	{
		return rank;
	}
	public String[][] getImage()
	{
		return image;
	}
}