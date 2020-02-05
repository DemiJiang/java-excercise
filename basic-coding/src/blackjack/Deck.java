package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9","10","JACK", "QUEEN", "KING", "ACE"};
    String[] suits = {"SPADE", "HEART", "DIAMOND", "CLUB"};

    public Deck() {
        for (int i=0;i<ranks.length;i++) {
            for (int j=0;j<suits.length;j++) {
                cards.add(new Card(ranks[i], suits[j]));
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card drawCard(){
        return cards.remove(0);
    }

    /* shuffle it manually
    public void shuffle()
    {
        Random random = new Random();
        Card temp;
        for(int i=0; i<200; i++)
        {
            int index1 = random.nextInt(deck.size()-1);
            int index2 = random.nextInt(deck.size()-1);
            temp = deck.get(index2);
            deck.set(index2, deck.get(index1));
            deck.set(index1, temp);
        }
    }
     */
}
