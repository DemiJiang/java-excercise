package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public int calculateHandValue(){
        int handValue = 0;

        for(Card card:cards){
            handValue += calculateCardValue(card);
        }
        int noOfAces = numberOfAces();

        while(noOfAces >0) {
            if(handValue >21) {
                handValue -= 10;
                noOfAces -= 1;
            }
            if(handValue <= 21){
                break;
            }
        }

        return handValue;
    }

    public int numberOfAces(){
        int noOfAces = 0;
        for (Card card:cards){
            if(card.getRank().equals("ACE")){
                noOfAces += 1;
            }
        }
        return noOfAces;
    }

    private int calculateCardValue(Card card){
       int cardValue = 0;
       if(Constant.RANKS.contains(card.getRank())){
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
