//*******************************************************************
//  Hand
//
// Holds the Hand class and its appropriate variables and methods
//*******************************************************************
public class Hand
{
  //Variables
  Card[] hand; //A hand of five cards used for Texas Hold'Em
  int winCon;  //The highest win condition the hand has
  int highPair; //The higher pair in twoPair. Also used for one pair.
  int lowPair; //The lower pair in twoPair



  //*******************************************************************
  //  Hand
  //
  // The default constructor for the Hand object
  //*******************************************************************
  public Hand()
  {
    this.hand = new Card[5];
    this.winCon = 0;
  }//Hand

  //*******************************************************************
  //  Hand
  //
  // The constructor for a hand with a set card array
  //*******************************************************************
  public Hand(Card[] cards)
  {
    this.hand = new Card[5];
    this.winCon = 0;
    for(int i = 0; i < 5; i++)
    {
      hand[i] = new Card();
      this.hand[i].setValue(cards[i].getValue());
      this.hand[i].setSuit(cards[i].getSuit());
    }//for
  }//Hand

  //*******************************************************************
  //  getWinCon
  //
  // Returns the winning condition for the Hand
  //*******************************************************************
  public int getWinCon()
  {
    return winCon;
  }//getWinCon

  //*******************************************************************
  //  getHighPair
  //
  // Returns the highest pair in two pairs and regular pair
  //*******************************************************************
  public int getHighPair()
  {
    return highPair;
  }//getHighPair

  //*******************************************************************
  //  getLowPair
  //
  // Returns the highest pair in two pairs and regular pair
  //*******************************************************************
  public int getLowPair()
  {
    return lowPair;
  }//getLowPair

  //*******************************************************************
  //  sortCards
  //
  // Sorts the cards based off of value using insertion sort
  //*******************************************************************
  public void sortCards()
  {
    Card temp = new Card();
    for(int i = 0; i < 5; i++)
    {
      for(int j = 1; j < 5; j++)
      {
        if(hand[j-1].getValue() > hand[j].getValue())
        {
          temp = hand[j-1];
          hand[j-1] = hand[j];
          hand[j] = temp;
        }//if
      }//for
    }//for

  }//sortCards

  //*******************************************************************
  //  printHand
  //
  // Prints the players current hand
  //*******************************************************************
  public void printHand()
  {
    for(int i = 0; i < 5; i++)
    {
      System.out.print(hand[i].getValue() + "" + hand[i].getSuit() + " ");
    }//for
    System.out.println();
  }//printHand

  //*******************************************************************
  //  straightFlush
  //
  // Determines whether player has straight flush in hand.
  // Straight flushes have five cards of the same suit with
  // consecutive values.
  //*******************************************************************
  public boolean straightFlush(boolean straight, boolean flush)
  {
    if(straight && flush)
    {
      return true;
    }
    return false;
  }//straightFlush

  //*******************************************************************
  //  fourKind
  //
  // Determines whether player has four of the same valued
  // card in hand
  //*******************************************************************
  public boolean fourKind()
  {
    int checkValue = hand[0].getValue();
    if(hand[1].getValue() == checkValue)
    {
      for(int i = 0; i < 4; i++)
      {
        if(hand[i].getValue() != checkValue)
        {
          return false;
        }//if
      }//for
      return true;
    }//if first two are same value
    checkValue = hand[1].getValue();
    if(hand[2].getValue() == checkValue)
    {
      for(int i = 1; i < 5; i++)
      {
        if(hand[i].getValue() != checkValue)
        {
          return false;
        }//if
      }//for
      return true;
    }//if
    return false;
  }//fourKind

  //*******************************************************************
  //  fullHouse
  //
  // Determines whether player has a full house in hand.
  // A full house has three cards of the same value with the
  // other two making a pair.
  //*******************************************************************
  public boolean fullHouse(boolean hasThree, boolean hasPair)
  {
    if(hasThree && hasPair)
    {
      return true;
    }
    return false;
  }//fullHouse

  //*******************************************************************
  //  flush
  //
  // Determines whether player has a flush.
  // Flushes contain five cards of the same suit.
  // High card determines ties.
  //*******************************************************************
  public boolean flush()
  {
    char checkSuit = hand[0].getSuit();
    for(int i = 0; i < 5; i++)
    {
      if(hand[i].getSuit() != checkSuit)
      {
        return false;
      }//if
    }//for
    return true;
  }//flush

  //*******************************************************************
  //  straight
  //
  // Determines whether player has straight in hand.
  // Straights have five cards with consecutive values.
  // Ties are determined by the highest card.
  //*******************************************************************
  public boolean straight()
  {
    for(int i = 1; i < 5; i++)
    {
      if(hand[i-1].getValue() != (hand[i].getValue()-1))
      {
        return false;
      }//if
    }
    return true;
  }//straight

  //*******************************************************************
  //  threeKind
  //
  // Determines whether player has three cards of the same value
  //*******************************************************************
  public boolean threeKind()
  {
    if(hand[0].getValue() == hand[1].getValue())
    {
      if (hand[0].getValue() == hand[2].getValue())
      {
        return true;
      }
    }
    if(hand[1].getValue() == hand[2].getValue())
    {
      if (hand[1].getValue() == hand[3].getValue())
      {
        return true;
      }
    }
    if(hand[2].getValue() == hand[3].getValue())
    {
      if (hand[2].getValue() == hand[4].getValue())
      {
        return true;
      }
    }
    return false;
  }//threeKind

  //*******************************************************************
  //  twoPair
  //
  // Determines whether player has two different pairs.
  // Ties are determined by the higher pair, then the second pair,
  // and finally the value of the final card.
  //*******************************************************************
  public boolean twoPair()
  {
    int checkValue = 0;
    int counter = 0;
    int pairs = 0;

    //Run through each value and see if counter = 2
    for(int i = 0; i < 5; i++)
    {
      checkValue = hand[i].getValue();
      counter = 0;
      for(int j = 0; j < 5; j++)
      {
        if(hand[j].getValue() == checkValue)
        {
          counter++;
        }
      }
      if(counter == 2)
      {
        pairs++;
      }
      if(pairs == 1)
      {
        lowPair = checkValue;
      }
      if(pairs == 3)
      {
        highPair = checkValue;
      }
      if(pairs == 4)
      {
        return true;
      }
    }//for

    return false;
  }//twoPair

  //*******************************************************************
  //  pair
  //
  // Determines whether player has pair in hand.
  // Ties are determined by the higher value pair and then high cards.
  // Returns value of highest pair.
  //*******************************************************************
  public boolean pair()
  {
    int checkValue = 0;
    int counter = 0;
    int winVal = 0;
    int pairs = 0;

    //Run through each value and see if counter = 2
    for(int i = 0; i < 5; i++)
    {
      checkValue = hand[i].getValue();
      counter = 0;
      for(int j = 0; j < 5; j++)
      {
        if(hand[j].getValue() == checkValue)
        {
          counter++;
        }
      }
      if(counter == 2)
      {
        pairs++;
      }
      if(pairs == 2)
      {
        highPair = checkValue;
        return true;
      }
    }//for
    if(pairs == 2)
    {
      highPair = winVal;
      return true;
    }

    return false;
  }//pair

  //*******************************************************************
  //  highCard
  //
  // Determines the highest value card
  //*******************************************************************
  public int highCard()
  {
    return hand[4].getValue();
  }//highCard

  //*******************************************************************
  //  winner
  //
  // Determines Hand's winning condition
  //*******************************************************************
  public void winner()
  {
    if(this.straight() && this.flush())
    {
      winCon = 9;
      return;
    }
    else if(this.fourKind())
    {
      winCon = 8;
      return;
    }
    else if(this.threeKind() && this.pair())
    {
      winCon = 7;
      return;
    }
    else if(this.flush())
    {
      winCon = 6;
      return;
    }
    else if(this.straight())
    {
      winCon = 5;
      return;
    }
    else if(this.threeKind())
    {
      winCon = 4;
      return;
    }
    else if(this.twoPair())
    {
      winCon = 3;
      return;
    }
    else if(this.pair())
    {
      winCon = 2;
      return;
    }
    else
    {
      winCon = 1;
      return;
    }
  }//winner

  public String printWin()
  {
    switch(winCon)
    {
      case 9:
        return "straight flush: " + this.highCard();
      case 8:
        return "four of a kind: " + hand[2].getValue();
      case 7:
        {
          if(hand[0].getValue() == hand[2].getValue())
          {
            return "full house: " + hand[0].getValue() + " over " + hand[4].getValue();
          }
          else
          {
            return "full house: " + hand[4].getValue() + " over " + hand[0].getValue();
          }
        }//case 7
      case 6:
        return "flush: " + this.highCard();
      case 5:
        return "straight: " + this.highCard();
      case 4:
        return "three of a kind: " + hand[2].getValue();
      case 3:
        return "two pair: " + highPair + " over " + lowPair;
      case 2:
        return "pair: " + highPair;
      case 1:
        return "high card: " + this.highCard();
    }
    return null;
  }

}//Hand
