package blackjack;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BlackJackTests {

    @Test
    public void playerHasBlackJackTheyWin(){
        BlackJack blackJack = new BlackJack();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("KING", "DIAMOND"));
        cards.add(new Card("ACE", "SPADE"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(cards);

        Hand dealerHand = new Hand();
        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("You beat the dealer!", result);
    }

    @Test
    public void playerAndDealerBothHasBlackJackShouldBeATie(){
        BlackJack blackJack = new BlackJack();
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card("KING", "DIAMOND"));
        playerCards.add(new Card("ACE", "SPADE"));

        List<Card> dealerCards = new ArrayList<>();
        dealerCards.add(new Card("KING", "HEART"));
        dealerCards.add(new Card("ACE", "CLUB"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(playerCards);

        Hand dealerHand = new Hand();
        dealerHand.getCards().addAll(dealerCards);

        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("Tie!", result);
    }

    @Test
    public void dealerBustsAndPlayerNotBustsPlayerWins(){
        BlackJack blackJack = new BlackJack();
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card("KING", "DIAMOND"));
        playerCards.add(new Card("9", "SPADE"));

        List<Card> dealerCards = new ArrayList<>();
        dealerCards.add(new Card("KING", "HEART"));
        dealerCards.add(new Card("3", "CLUB"));
        dealerCards.add(new Card("9", "SPADE"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(playerCards);

        Hand dealerHand = new Hand();
        dealerHand.getCards().addAll(dealerCards);

        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("You beat the dealer!", result);
    }

    @Test
    public void playerBustsAndDealerNotBustsDealerWins(){
        BlackJack blackJack = new BlackJack();
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card("KING", "DIAMOND"));
        playerCards.add(new Card("8", "SPADE"));
        playerCards.add(new Card("4", "SPADE"));


        List<Card> dealerCards = new ArrayList<>();
        dealerCards.add(new Card("KING", "HEART"));
        dealerCards.add(new Card("3", "CLUB"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(playerCards);

        Hand dealerHand = new Hand();
        dealerHand.getCards().addAll(dealerCards);

        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("Dealer wins!", result);
    }

    @Test
    public void playerAndDealerBothNotBustsDealerWins(){
        BlackJack blackJack = new BlackJack();
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card("KING", "DIAMOND"));
        playerCards.add(new Card("3", "SPADE"));

        List<Card> dealerCards = new ArrayList<>();
        dealerCards.add(new Card("KING", "HEART"));
        dealerCards.add(new Card("9", "CLUB"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(playerCards);

        Hand dealerHand = new Hand();
        dealerHand.getCards().addAll(dealerCards);

        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("Dealer wins!", result);
    }

    @Test
    public void playerAndDealerBothNotBustsPlayerWins(){
        BlackJack blackJack = new BlackJack();
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card("KING", "DIAMOND"));
        playerCards.add(new Card("9", "SPADE"));

        List<Card> dealerCards = new ArrayList<>();
        dealerCards.add(new Card("KING", "HEART"));
        dealerCards.add(new Card("4", "CLUB"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(playerCards);

        Hand dealerHand = new Hand();
        dealerHand.getCards().addAll(dealerCards);

        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("You beat the dealer!", result);
    }

    @Test
    public void playerAndDealerBothNotBustHasEqualValueShouldBeATie(){
        BlackJack blackJack = new BlackJack();
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card("KING", "DIAMOND"));
        playerCards.add(new Card("9", "SPADE"));

        List<Card> dealerCards = new ArrayList<>();
        dealerCards.add(new Card("KING", "HEART"));
        dealerCards.add(new Card("9", "CLUB"));

        Hand playerHand = new Hand();
        playerHand.getCards().addAll(playerCards);

        Hand dealerHand = new Hand();
        dealerHand.getCards().addAll(dealerCards);

        String result = blackJack.play(playerHand, dealerHand);
        assertEquals("Tie!", result);
    }

}
