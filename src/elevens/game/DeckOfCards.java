package elevens.game;

import java.awt.Image;
import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DeckOfCards
{
    private ArrayList<Card> myDeck;
    Random rand = new Random();
    int cardCount = 52, dealtCard;
    int[] suits = {1,2,3,4};
    int[] faces = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    
    
    int currentCard = 0;
    public DeckOfCards() throws FileNotFoundException, IOException
    {
        myDeck = new ArrayList<Card>();
        int iconCount = 56;
        for(int i=0; i<13; i++)
        {
            for(int j=0; j<4; j++)
            {
                //InputStream is = new BufferedInputStream(new FileInputStream("./cards/" + iconCount + ".png"));
                myDeck.add(new Card(faces[i],suits[j],new ImageIcon(getClass().getResource("/cards/" + iconCount + ".png"))));
                iconCount--;
            }
        }
    }
    
    public void shuffle()
    {
        long seed = System.nanoTime();
        Collections.shuffle(myDeck, new Random(seed));
        Collections.shuffle(myDeck, new Random(seed));
        Collections.shuffle(myDeck, new Random(seed));
        Collections.shuffle(myDeck, new Random(seed));
    }
    
    public Card deal()
    {
        if(currentCard<myDeck.size())
        {
            return myDeck.get(currentCard++);
        }
        else
        {
            return null;
        }
    }

    public int size()
    {
        return cardCount;
    }

    public boolean isEmpty()
    {
        if(cardCount<=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void tostring()
    {
        for(int z=0; z<52; z++)
        {
            System.out.println("["+z+"] " + myDeck.get(z));
        }
    }
}
