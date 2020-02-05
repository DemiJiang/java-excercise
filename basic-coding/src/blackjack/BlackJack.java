package blackjack;

public class BlackJack {
    private Hand player;
    private Hand dealer;

    public BlackJack(Hand player, Hand dealer) {
        this.player = player;
        this.dealer = dealer;
    }
    public BlackJack(){
    }

    public Hand getPlayer() {
        return player;
    }

    public Hand getDealer() {
        return dealer;
    }


    public String play(Hand player, Hand dealer){
        if(player.calculateHandValue() > 21 || ( dealer.calculateHandValue() <= 21 && dealer.calculateHandValue() > player.calculateHandValue()))
            return "Dealer wins!";
        else if(dealer.calculateHandValue() > 21 || (player.calculateHandValue() <= 21 && player.calculateHandValue() > dealer.calculateHandValue()))
            return "You beat the dealer!";
        return "Tie!";
    }

}
