package blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HandTests {
    private static Card card1 = new Card("4", "DIAMOND");
    private static Card card2 = new Card("ACE", "HEART");
    private static List<Card> cards = new ArrayList<>();
    private static Hand hand = new Hand();

    @Before
    public void setup(){
        hand.getCards().add(card1);
        hand.getCards().add(card2);
    }

    @Test
    public void handShouldReturnCorrectValue(){
         int result = hand.calculateHandValue();
        assertEquals(15, result);
    }
}
