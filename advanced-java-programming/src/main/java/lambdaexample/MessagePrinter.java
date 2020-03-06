package lambdaexample;

@FunctionalInterface
public interface MessagePrinter {
    public abstract void greet(String name);
}
