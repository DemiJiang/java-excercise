package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    List<String> ranks = List.of("2", "3", "4", "5", "6", "7", "8", "9","10");

    public int calculateHandValue(){
        int handValue = 0;
        for(Card card:cards) {
            handValue += calculateCardValue(card);
        }
        return handValue;
    }

    private int calculateCardValue(Card card){
       int cardValue = 0;
       if(ranks.contains(card.getRank())){
            cardValue = Integer.parseInt(card.getRank());
       }
       else if(card.getRank().equals("ACE")){
           cardValue = 11;
        }
       else{
           cardValue = 10;
       }
       return cardValue;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
