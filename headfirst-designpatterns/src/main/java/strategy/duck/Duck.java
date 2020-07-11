package strategy.duck;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    abstract void display();

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }
}
