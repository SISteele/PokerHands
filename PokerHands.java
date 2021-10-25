//Imports here
import java.util.Scanner;

//*******************************************************************
//  PokerHands
//
// Runs a game of Texas Hold Em, specifically determining what
// hand of several has the higher rank.
//*******************************************************************
public class PokerHands
{
  //*******************************************************************
  //  Main
  //
  // Runs the entire program
  //*******************************************************************
  public static void main(String[] args)
  {
    //Variables
    Scanner scan = new Scanner(System.in); //Scans in user input
    String stringIn; //Reads in strings
    String nameOne; //Player one's name
    String nameTwo; //Player two's name
    int index; //Holds the position of the ':' symbol
    Hand playerOne = new Hand(); //Hand for player one
    Hand playerTwo = new Hand(); //Hand for player two
    Card cards[] = new Card[5]; //Holds card array for players

    System.out.println("Enter player one's name and cards in the following format: ");
    System.out.println("Name: 2H 3D 5S 9C KD");
    stringIn = scan.nextLine();

    //Set up player one
    stringIn = stringIn.trim();
    index = stringIn.indexOf(":");
    if(index == -1)
    {
      System.out.println("ERROR: No colon (:) added to the input. Exiting program.");
      System.out.println("Please use a colon to separate the name from the cards.");
      System.exit(0);
    }
    nameOne = stringIn.substring(0, index);
    stringIn = stringIn.substring(index+1);

    stringIn = stringIn.trim();
    if(stringIn.length() != 14)
    {
      System.out.println("ERROR: Invalid card and/or card amount. Exiting program.");
      System.out.println("Please set your cards in the following format: ");
      System.out.println("2H 3D 5S 9C KD");
      System.exit(0);
    }

    for(int j = 0; j < 5; j++)
      {
        stringIn = stringIn.trim();
        char suit = stringIn.charAt(1);
        char value = stringIn.charAt(0);
        cards[j] = new Card(suit, value);
        stringIn = stringIn.substring(2);
      }//for
      playerOne = new Hand(cards);
      playerOne.sortCards();

      //Set up player two
      System.out.println("Enter player two's name and cards in the same format.");
      stringIn = scan.nextLine();

      stringIn = stringIn.trim();
      index = stringIn.indexOf(":");
      if(index == -1)
      {
        System.out.println("ERROR: No colon (:) added to the input. Exiting program.");
        System.out.println("Please use a colon to separate the name from the cards.");
        System.exit(0);
      }
      nameTwo = stringIn.substring(0, index);
      stringIn = stringIn.substring(index+1);

      for(int j = 0; j < 5; j++)
        {
          stringIn = stringIn.trim();
          char suit = stringIn.charAt(1);
          char value = stringIn.charAt(0);
          cards[j] = new Card(suit, value);
          stringIn = stringIn.substring(2);
        }//for
        playerTwo = new Hand(cards);
        playerTwo.sortCards();

        //Check for winning conditions
        playerOne.winner();
        playerTwo.winner();
        if(playerOne.getWinCon() > playerTwo.getWinCon())
        {
          System.out.println(nameOne + " wins. - with " + playerOne.printWin());
        }
        else if(playerOne.getWinCon() < playerTwo.getWinCon())
        {
          System.out.println(nameTwo + " wins. - with " + playerTwo.printWin());
        }

        //Tiebreakers
        else if(playerOne.getWinCon() == playerTwo.getWinCon())
        {
          if(playerOne.getWinCon() == 2 || playerOne.getWinCon() == 3)
          {
            if(playerOne.getHighPair() > playerTwo.getHighPair())
            {
              System.out.println(nameOne + " wins. - with two pair: " + playerOne.getHighPair());
              System.exit(0);
            }
            else if(playerOne.getHighPair() < playerTwo.getHighPair())
            {
              System.out.println(nameTwo + " wins. - with two pair: " + playerTwo.getHighPair());
              System.exit(0);
            }
            else if(playerOne.getLowPair() > playerTwo.getLowPair())
            {
              System.out.println(nameOne + " wins. - with two pair: " + playerOne.getHighPair());
              System.exit(0);
            }
            else if(playerOne.getLowPair() < playerTwo.getLowPair())
            {
              System.out.println(nameTwo + " wins. - with two pair: " + playerTwo.getHighPair());
              System.exit(0);
            }
            else
            {
              System.out.println("Tie.");
              System.exit(0);
            }
          }
          else
          {
            for(int i = 4; i >= 0; i--)
            {
              if(playerOne.hand[i].getValue() > playerTwo.hand[i].getValue())
              {
                System.out.println(nameOne + " wins. - with high card: " + playerOne.hand[i].getValue());
                System.exit(0);
              }
              else if(playerOne.hand[i].getValue() < playerTwo.hand[i].getValue())
              {
                System.out.println(nameTwo + " wins. - with high card: " + playerTwo.hand[i].getValue());
                System.exit(0);
              }
            }
              System.out.println("Tie.");
              System.exit(0);
          }
        }
        else
        {
          System.out.println("Tie.");
        }



  }//main

}//PokerHands
