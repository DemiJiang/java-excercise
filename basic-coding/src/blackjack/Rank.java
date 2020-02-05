package blackjack;

public enum Rank {
    ACE(11),ONE(1),TWO(2);


    private final int value;

    Rank(int value) {
        this.value=value;
    }


    int getValue() {
        boolean x = Rank.ONE==Rank.ONE;
        return this.value;
    }

}
