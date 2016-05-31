package org.loveletter.Players;

import java.util.Set;

import org.loveletter.Card;
import org.loveletter.Player;

/**
 * Test Player
 */
public class LowCardHighProbability extends Player {
    
    /** Play low card */
    @Override
    public Card chooseCardtoPlay() {
        assert(card1 != null && card2 != null);
        
        return card1.value < card2.value ? playCard1() : playCard2(); 
    }
    
    /**
     * always returns a random other player
     */
    @Override
    public int getPlayerFor(int cardValue, Set<Integer> availablePlayerIds) {
        return getRandomPlayerId(availablePlayerIds);
    }

    /**
     * Guard: guess another player's card
     * @return value to guess (2-8). Guessing a Guard is not allowed
     */
    @Override
    public int guessCardValue() {
    	for (int i = Card.PRINCE; i > Card.GUARD; i--) {
    		if (getCardsLeft(i) == 2)
    				return i;
    	}
    	for (int i = Card.PRINCESS; i > Card.GUARD; i--) {
    		if (getCardsLeft(i) == 1)
    				return i;
    	}
    	
    	//It could be the case that only GUARDS are left -> guess nothing in this case.
    	return -1;
    }
    
    @Override
    public void otherPlayerHasCard(int id, Card card) {
        //empty. RandomPlayer doesn't remember any cards :-)
    }
    
    @Override
    public void cardPlayed(int id, Card card) {
        //empty. RandomPlayer does not remember any cards.
    }
    
    @Override
    public String toString() {
        return "LCHP["+card1+"]";
    }

}
