package elevens.game;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import elevens.game.Card;

/*
 * Project Elevens
 * By Chris Bigge
*/
public class ElevensTools 
{
    private ArrayList<Card> card;
    private DeckOfCards deck;
    private boolean isLegal = false;
    private boolean isLegal2 = false;
    
    public boolean isEmpty()
    {
        for(int i=0; i<card.size(); i++)
        {
            if(card.get(i)==null)
            {
                return true;
            }
        }
        return false;
    }
    
    public Card getCard(int pos)
    {
        return card.get(pos);
    }
    
    public void getNullLocations()
    {
        for(int i=0; i<card.size(); i++)
        {
            if(card.get(i)==null)
            {
                card.set(i, deck.deal());
            }
        }
    }
    
    public boolean addsToEleven(ArrayList<Card> cards)
    {
        if(cards.size()==2)
        {
            if(cards.get(0).getFace() + cards.get(1).getFace() == 11)
            {
                return true;
            }
        }
        return false;
        
    }
    
    public boolean JQKTriplet(ArrayList<Card> cards)
    {
        boolean king=false, queen=false, jack=false;
        if(cards.size()==3)
        {
            for(int i=0; i<cards.size(); i++)
            {
                switch(cards.get(i).getFace())
                {
                    case 11:
                        jack = true;
                        break;
                    case 12:
                        queen = true;
                        break;
                    case 13:
                        king = true;
                        break;
                    default:
                        isLegal2 = false;
                        return false;
                }
            }
        }
        if(king && queen && jack)
        {
            isLegal2 = true;
            return true;
        }
        isLegal2 = false;
        return false;
    }
    
    public boolean isLegal()
    {
        if(isLegal == true || isLegal2 == true)
        {
            return true;
        }
        return false;
    }
    
    public void reset(ArrayList a)
    {
        a.removeAll(a);
    }
    
    public void newGame(DeckOfCards c)
    {
        c.shuffle();
        for(int a=0; a<9; a++)
        {
            c.deal();
        }
    }
}
