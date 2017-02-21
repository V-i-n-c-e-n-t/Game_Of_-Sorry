/**
 * Holds all the cards, and manages the following functions; draw, shuffle (current pile) and reset (fills pile)
 * 
 * @author (Oscar Ovind) 
 * @version (V.1 - 08/02/2017)
 */

import java.util.*;

public class Deck {
    
    List<Card> currentDeck = new ArrayList<Card>();
    
    public Deck() {
        Reset();
    }
    
    public Card Draw() {
        if (currentDeck.size() == 1) {
            System.out.println("--------- Only one card remains -------");
            return null;
        }
        
        Card drawnCard = currentDeck.get((int)(Math.random() * currentDeck.size() - 1));
        currentDeck.remove(drawnCard);
        System.out.println("The deck drew: " + drawnCard.getValue());
        return drawnCard;
    }
    
    public void Reset() {
        for (int a = 0; a < 13; a++) {
            for(int b = 0; b < 4; b++) {
                currentDeck.add(new Card(a));
            }
        }
        
        Shuffle();
    }
    
    public void Shuffle() {
        Collections.shuffle(currentDeck, new Random());
    }
}