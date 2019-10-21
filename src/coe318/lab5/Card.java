package coe318.lab5;
//Michael Karimizadeh 500831189
public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  boolean faceUp = false;
  int suit,rank;
 
  public Card(int rank, int suit, boolean faceUp) {
    this.faceUp = faceUp;
    this.suit = suit; 
    this.rank = rank;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    if(this.faceUp==true){
          return true;
      }
    return false;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return this.rank; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return this.suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    if(c.getSuit()==getSuit() && c.getRank()==getRank()){
        return true; 
    }
    return false;
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
    if(getRank()>=c.getRank()){//See if card has higher/equal rank
        if(getSuit()>=c.getSuit()){//See if card has higher/equal suit
            return getRank();
        }
        else{
            return c.getRank();//Returns other card's rank
        }
    }
    else{
        return c.getRank();//Returns other card's rank
    }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    if(getRank()>1 && getRank()<11){//See if input is in the integer range
        return Integer.toString(getRank());// String version of integer
      }
    else if(getRank()==11){
          return "Jack";
      }
    else if(getRank()==12){
          return "Queen";
      }
    else if(getRank()==13){
          return "King";
      }
    else if(getRank()==14 || getRank()==1){
          return "Ace";
      }
    return "INVALID RANK";
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    String cardSuit = "INVALID; SUIT UNREGISTERED";
      switch (getSuit()){
          case HEART:
              cardSuit = "Hearts";
              break;
          case SPADE:
              cardSuit = "Spades";
              break;
          case DIAMOND:
              cardSuit = "Diamonds";
              break;
          case CLUB:
              cardSuit = "Clubs";
              break;
          default:
      }
      return cardSuit;
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {

    return (isFaceUp())?("Suit: "+getSuitString()+" Rank: "+getRankString()):"?";
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
