//*******************************************************************
//  Card
//
// Holds the classes and methods for the card object used to play
// Texas Hold'Em
//*******************************************************************
public class Card
{
  //Variables
  char suit; //C->Clubs, D->Diamonds, H->Hearts, S->Spades
  int value; //Values between 2-14, aces high



  //*******************************************************************
  //  Card
  //
  // The default constructor for the Card object with no parameters
  //*******************************************************************
  public Card()
  {
    this.suit = '0';
    this.value = 0;
  }//Card

  //*******************************************************************
  //  Card
  //
  // The constructor for a card with a set suit and value
  // newSuit - char. Hearts, Diamonds, Clubs, or Spades
  // newValue - char. Any card value between 2 and 14.
  //*******************************************************************
  public Card(char newSuit, char newValue)
  {
    switch(newSuit)
    {
      case 'H', 'h':
        this.suit = 'H';
        break;
      case 'D', 'd':
        this.suit = 'D';
        break;
      case 'C', 'c':
        this.suit = 'C';
        break;
      case 'S', 's':
        this.suit = 'S';
        break;
      default:
        System.out.println("ERROR: Invalid suit type. Exiting program...");
        System.exit(0);
    }
    switch(newValue)
    {
      case '2', '3', '4', '5', '6', '7', '8', '9':
      {
        this.value = Character.getNumericValue(newValue);
        break;
      }
      case 'T', 't':
      {
        this.value = 10;
        break;
      }
      case 'J', 'j':
      {
        this.value = 11;
        break;
      }
      case 'Q', 'q':
      {
        this.value = 12;
        break;
      }
      case 'K', 'k':
      {
        this.value = 13;
        break;
      }
      case 'A', 'a':
      {
        this.value = 14;
        break;
      }
      default:
        {
          System.out.println("ERROR: Invalid value type. Exiting program...");
          System.exit(0);
        }

    }//switch
  }//Card

  //*******************************************************************
  //  setSuit
  //
  // Set the suit for the Card object
  // newSuit - char. Hearts, Diamonds, Clubs, or Spades
  //*******************************************************************
  public void setSuit(char newSuit)
  {
    switch(newSuit)
    {
      case 'H', 'h':
        this.suit = 'H';
        break;
      case 'D', 'd':
        this.suit = 'D';
        break;
      case 'C', 'c':
        this.suit = 'C';
        break;
      case 'S', 's':
        this.suit = 'S';
        break;
      default:
        System.out.println("ERROR: Invalid suit type. Exiting program...");
        System.exit(0);
    }
  }//setSuit

  //*******************************************************************
  //  setValue
  //
  // Set the value for the Card object
  // newValue - char. Any card value between 2 and 14.
  //*******************************************************************
  public void setValue(char newValue)
  {
    switch(newValue)
    {
      case '2', '3', '4', '5', '6', '7', '8', '9':
      {
        this.value = Character.getNumericValue(newValue);
        break;
      }
      case 'T', 't':
      {
        this.value = 10;
        break;
      }
      case 'J', 'j':
      {
        this.value = 11;
        break;
      }
      case 'Q', 'q':
      {
        this.value = 12;
        break;
      }
      case 'K', 'k':
      {
        this.value = 13;
        break;
      }
      case 'A', 'a':
      {
        this.value = 14;
        break;
      }
      default:
        {
          System.out.println("ERROR: Invalid value type. Exiting program...");
          System.exit(0);
        }

    }//switch
  }//setValue

  //*******************************************************************
  //  setValue
  //
  // Set the value for the Card object
  // newValue - int. Any card value between 2 and 14.
  //*******************************************************************
  public void setValue(int newValue)
  {
    this.value = newValue;
  }//setValue

  //*******************************************************************
  //  getSuit
  //
  // Gets the suit for the Card object
  //*******************************************************************
  public char getSuit()
  {
    return suit;
  }//getSuit

  //*******************************************************************
  //  getValue
  //
  // Gets the value for the Card object
  //*******************************************************************
  public int getValue()
  {
    return value;
  }//getValue

}//Card
