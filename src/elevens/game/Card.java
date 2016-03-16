package elevens.game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Card 
{
   private int suit, face;
   private ImageIcon img;
   public int CLUBS = 4;
   public int SPADES = 3;
   public int HEARTS = 2;
   public int DIAMOND = 1;
   public int KING = 13;
   public int QUEEN = 12;
   public int JACK = 11;
   public int TEN = 10;
   public int NINE = 9;
   public int EIGHT = 8;
   public int SEVEN = 7;
   public int SIX = 6;
   public int FIVE = 5;
   public int FOUR = 4;
   public int THREE = 3;
   public int TWO = 2;
   public int ACE = 1;
   String[] suitsString = {"Diamond", "Hearts", "Spades", "Clubs"};
   String[] facesString = {"Ace", "Two", "Three", "Four", "Five", "Six"
            + "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
   public Card(int face, int suit, ImageIcon icon)
   {
      this.face = face;
      this.suit = suit;
      this.img = icon;
   }

    public int getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }
    
    public ImageIcon getIcon() {
        return img;
    }
    
    public void setIcon(String path) {
        img = new ImageIcon(path);
    }
    
    public String suitToString(int a)
    {
        switch(a)
        {
            case 1:
                return suitsString[0];
            case 2:
                return suitsString[1];
            case 3:
                return suitsString[2];
            case 4:
                return suitsString[3];
            default:
                return "Error";
        }
    }
    
    public String faceToString(int b)
    {
        switch(b)
        {
            case 1:
                return facesString[0];
            case 2:
                return facesString[1];
            case 3:
                return facesString[2];
            case 4:
                return facesString[3];
            case 5:
                return facesString[4];
            case 6:
                return facesString[5];
            case 7:
                return facesString[6];
            case 8:
                return facesString[7];
            case 9:
                return facesString[8];
            case 10:
                return facesString[9];
            case 11:
                return facesString[10];
            case 12:
                return facesString[11];
            case 13:
                return facesString[12];
            default:
                return "Error";
        }
    }

   public String toString() 
   { 
      return face + " of " + suit;
   }
}
