package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTests {
    private static Card card1 = new Card("8", "DIAMOND");
    private static Card card2 = new Card("JACK", "HEART");
    private static Card card3 = new Card("ACE", "HEART");
    private static Card card4 = new Card("ACE", "DIAMOND");

    @Test
    public void handValueShouldReturn18(){
        Hand hand = new Hand();
        hand.getCards().add(card1);
        hand.getCards().add(card2);
         int result = hand.calculateHandValue();
        assertEquals(18, result);
    }

    @Test
    public void handWithOneAceAs11ValueShouldReturn21(){
        Hand hand = new Hand();
        hand.getCards().add(card2);
        hand.getCards().add(card3);
        int result = hand.calculateHandValue();
        assertEquals(21, result);
    }

    @Test
    public void handWithOneAceAs1ValueShouldReturn19(){
        Hand hand = new Hand();
        hand.getCards().add(card1);
        hand.getCards().add(card2);
        hand.getCards().add(card3);
        int result = hand.calculateHandValue();
        assertEquals(19, result);
    }

    @Test
    public void handWithTwoAcesAs1ValueShouldReturn20(){
        Hand hand = new Hand();
        hand.getCards().add(card1);
        hand.getCards().add(card2);
        hand.getCards().add(card3);
        hand.getCards().add(card4);
        int result = hand.calculateHandValue();
        assertEquals(20, result);
    }
}
