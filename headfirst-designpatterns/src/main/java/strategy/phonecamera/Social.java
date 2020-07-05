package strategy.phonecamera;

public class Social implements ShareStrategy{
    @Override
    public void share() {
        System.out.println("I'm posting the photo on social media");
    }
}
