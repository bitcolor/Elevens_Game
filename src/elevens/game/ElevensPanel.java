package elevens.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * Project ElevensGame
 * By Chris Bigge
 */
public class ElevensPanel extends JPanel
{
    ImageIcon win = new ImageIcon("src/elevens/game/cards/win.jpg");
    JToggleButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JButton submit,reset,info;
    ElevensTools tools = new ElevensTools();
    DeckOfCards deck;
    ArrayList<Card> cards = new ArrayList<Card>();
    ArrayList<Card> selectedCards = new ArrayList<Card>(); 
    boolean a1,a2,a3,a4,a5,a6,a7,a8,a9;
    int cardsLeft, winCount;
    public ElevensPanel() throws IOException
    {
        this.deck = new DeckOfCards();
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        info = new JButton();
        setLayout(new GridLayout(4,3));
        setBackground(Color.green);
        setSize(300,200);
    }
    
    public void start()
    {
        cardsLeft=52;
        deck.shuffle();
        deck.tostring();
        for(int i=0; i<9; i++)
        {
            cards.add(deck.deal());
        }
        
        b1 = new JToggleButton(cards.get(0).getIcon());
        b2 = new JToggleButton(cards.get(1).getIcon());
        b3 = new JToggleButton(cards.get(2).getIcon());
        b4 = new JToggleButton(cards.get(3).getIcon());
        b5 = new JToggleButton(cards.get(4).getIcon());
        b6 = new JToggleButton(cards.get(5).getIcon());
        b7 = new JToggleButton(cards.get(6).getIcon());
        b8 = new JToggleButton(cards.get(7).getIcon());
        b9 = new JToggleButton(cards.get(8).getIcon());
        info = new JButton("" + deck.size());
        submit.addActionListener(new SuperListener());
        reset.addActionListener(new SuperListener());
        b1.addActionListener(new SuperListener());
        b2.addActionListener(new SuperListener());
        b3.addActionListener(new SuperListener());
        b4.addActionListener(new SuperListener());
        b5.addActionListener(new SuperListener());
        b6.addActionListener(new SuperListener());
        b7.addActionListener(new SuperListener());
        b8.addActionListener(new SuperListener());
        b9.addActionListener(new SuperListener());
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(submit);
        add(reset);
        add(info);
    }
    
    public class SuperListener extends ElevensTools implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource().equals(reset))
            {
                cardsLeft=52;
                selectedCards.clear();
                DeckOfCards newDeck = null;
                try {
                    newDeck = new DeckOfCards();
                } catch (IOException ex) {
                    Logger.getLogger(ElevensPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                deck = newDeck;
                deck.shuffle();
                deck.tostring();
                for(int i=0; i<9; i++)
                {
                    cards.set(i,newDeck.deal());
                }

                b1.setIcon(cards.get(0).getIcon());
                b2.setIcon(cards.get(1).getIcon());
                b3.setIcon(cards.get(2).getIcon());
                b4.setIcon(cards.get(3).getIcon());
                b5.setIcon(cards.get(4).getIcon());
                b6.setIcon(cards.get(5).getIcon());
                b7.setIcon(cards.get(6).getIcon());
                b8.setIcon(cards.get(7).getIcon());
                b9.setIcon(cards.get(8).getIcon());
                info.setText("" + deck.size());
                System.out.println(deck.size());
            }
            else
            {
                if(event.getSource().equals(b1))
                {
                    selectedCards.add(cards.get(0));
                    a1 = true;
                }
                if(event.getSource().equals(b2))
                {
                    selectedCards.add(cards.get(1));
                    a2 = true;
                }
                if(event.getSource().equals(b3))
                {
                    selectedCards.add(cards.get(2));
                    a3 = true;
                }
                if(event.getSource().equals(b4))
                {
                    selectedCards.add(cards.get(3));
                    a4 = true;
                }
                if(event.getSource().equals(b5))
                {
                    selectedCards.add(cards.get(4));
                    a5 = true;
                }
                if(event.getSource().equals(b6))
                {
                    selectedCards.add(cards.get(5));
                    a6 = true;
                }
                if(event.getSource().equals(b7))
                {
                    selectedCards.add(cards.get(6));
                    a7 = true;
                }
                if(event.getSource().equals(b8))
                {
                    selectedCards.add(cards.get(7));
                    a8 = true;
                }
                if(event.getSource().equals(b9))
                {
                    selectedCards.add(cards.get(8));
                    a9 = true;
                }
                
                else
                {
                    if(event.getSource().equals(submit))
                    {
                        //System.out.println(selectedCards.get(0));
                        //System.out.println(selectedCards.get(1));
                        b1.setSelected(false);
                        b2.setSelected(false);
                        b3.setSelected(false);
                        b4.setSelected(false);
                        b5.setSelected(false);
                        b6.setSelected(false);
                        b7.setSelected(false);
                        b8.setSelected(false);
                        b9.setSelected(false);
                        if(tools.JQKTriplet(selectedCards) || tools.addsToEleven(selectedCards))
                        {
                            if(cardsLeft>3)
                            {
                                cardsLeft-=selectedCards.size();
                            }
                            selectedCards.clear();
                            if((cardsLeft==3))
                            {
                                cards.clear();
                                b1.setIcon(win);
                                b2.setIcon(win);
                                b3.setIcon(win);
                                b4.setIcon(win);
                                b5.setIcon(win);
                                b6.setIcon(win);
                                b7.setIcon(win);
                                b8.setIcon(win);
                                b9.setIcon(win);
                                submit.setIcon(win);
                                reset.setIcon(win);
                                info.setIcon(win);
                                try {          
                                     File soundFile = new File("src/elevens/game/cards/sound.wav");
                                     AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
                                    
                                    Clip clip = AudioSystem.getClip();
                                    
                                    clip.open(audioIn);
                                    clip.start();
                                } 
                                catch (UnsupportedAudioFileException e) 
                                {
                                    e.printStackTrace();
                                } 
                                catch (IOException e) 
                                {
                                    e.printStackTrace();
                                } 
                                catch (LineUnavailableException e) 
                                {
                                    e.printStackTrace();
                                }
                                return;
                            }
                            if((cardsLeft==2))
                            {
                                cards.clear();
                                b1.setIcon(win);
                                b2.setIcon(win);
                                b3.setIcon(win);
                                b4.setIcon(win);
                                b5.setIcon(win);
                                b6.setIcon(win);
                                b7.setIcon(win);
                                b8.setIcon(win);
                                b9.setIcon(win);
                                submit.setIcon(win);
                                reset.setIcon(win);
                                info.setIcon(win);
                                try {          
                                     File soundFile = new File("src/elevens/game/cards/sound.wav");
                                     AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
                                    
                                    Clip clip = AudioSystem.getClip();
                                    
                                    clip.open(audioIn);
                                    clip.start();
                                } 
                                catch (UnsupportedAudioFileException e) 
                                {
                                    e.printStackTrace();
                                } 
                                catch (IOException e) 
                                {
                                    e.printStackTrace();
                                } 
                                catch (LineUnavailableException e) 
                                {
                                    e.printStackTrace();
                                }
                                return;
                            }
                            else 
                            {
                                if(a1)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b1.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(0, deck.deal());
                                        b1.setIcon(cards.get(0).getIcon());
                                        a1=false;
                                    }
                                }
                                if(a2)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b2.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(1, deck.deal());
                                        b2.setIcon(cards.get(1).getIcon());
                                        a2=false;
                                    }
                                }
                                if(a3)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b3.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(2, deck.deal());
                                        b3.setIcon(cards.get(2).getIcon());
                                        a3=false;
                                    }
                                }
                                if(a4)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b4.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(3, deck.deal());
                                        b4.setIcon(cards.get(3).getIcon());
                                        a4=false;
                                    }
                                }
                                if(a5)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b5.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(4, deck.deal());
                                        b5.setIcon(cards.get(4).getIcon());
                                        a5=false;
                                    }
                                }
                                if(a6)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b6.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(5, deck.deal());
                                        b6.setIcon(cards.get(5).getIcon());
                                        a6=false;
                                    }
                                }
                                if(a7)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b7.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(6, deck.deal());
                                        b7.setIcon(cards.get(6).getIcon());
                                        a7=false;
                                    }
                                }
                                if(a8)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b8.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(7, deck.deal());
                                        b8.setIcon(cards.get(7).getIcon());
                                        a8=false;
                                    }
                                }
                                if(a9)
                                {
                                    if(cardsLeft<=7)
                                    {
                                        cards.set(0, null);
                                        b9.setIcon(win);
                                    }
                                    else
                                    {
                                        cards.set(8, deck.deal());
                                        b9.setIcon(cards.get(8).getIcon());
                                        a9=false;
                                    }
                                }
                            }
                            info.setText(cardsLeft+"");
                            
                        }
                        else
                        {
                            selectedCards.clear();
                            a1=false;
                            a2=false;
                            a3=false;
                            a4=false;
                            a5=false;
                            a6=false;
                            a7=false;
                            a8=false;
                            a9=false;
                            Toolkit.getDefaultToolkit().beep();
                        }
                    }
                }
            }
        }
    }
}
