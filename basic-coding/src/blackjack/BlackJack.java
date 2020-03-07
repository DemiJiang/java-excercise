package blackjack;

public class BlackJack {

    public BlackJack(){
    }

    public String play(Hand player, Hand dealer){
        if(player.calculateHandValue() > 21 || ( dealer.calculateHandValue() <= 21 && dealer.calculateHandValue() > player.calculateHandValue()))
            return "Dealer wins!";
        else if(dealer.calculateHandValue() > 21 || (player.calculateHandValue() <= 21 && player.calculateHandValue() > dealer.calculateHandValue()))
            return "You beat the dealer!";
        return "Tie!";
    }

}
