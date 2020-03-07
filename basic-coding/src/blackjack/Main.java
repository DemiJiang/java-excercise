package blackjack;

import blackjack.BlackJack;
import blackjack.Hand;
import java.util.*;
import blackjack.Deck;

public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();

        BlackJack blackJack = new BlackJack();

        Hand player = new Hand();
        Hand dealer = new Hand();

        player.getCards().add(deck.drawCard());
        player.getCards().add(deck.drawCard());
        dealer.getCards().add(deck.drawCard());
        dealer.getCards().add(deck.drawCard());

        Scanner scN = new Scanner(System.in);
        int option = 1;

        while(option == 1){
            System.out.println("Player are at currently at " + player.calculateHandValue() + " with the hand " + player);
            System.out.println("Hit or stay? (Hit = 1, Stay = 0)");
            option = playerIn(scN);
            if(option == 1){
                player.getCards().add(deck.drawCard());
            }
        }

        while(dealer.calculateHandValue()<17){
            dealer.getCards().add(deck.drawCard());
        }

        System.out.println("Dealer are at currently at " + dealer.calculateHandValue() + " with the hand " + dealer);
        System.out.println(blackJack.play(player, dealer));
    }

    public static int playerIn(Scanner scN){
        return scN.nextInt();
    }
}
