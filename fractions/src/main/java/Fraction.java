public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int intergerValue) {
       this(intergerValue,1);
    }

    public Fraction(int numerator, int denominator) {
        final int gcd = NumberTheory.gcd(numerator,denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction plus(Fraction that) {
        if(this.denominator != that.denominator){
            return new Fraction(this.numerator * that.denominator + that.numerator * this.denominator,
                    this.denominator * that.denominator);
        } else {
            return new Fraction(this.numerator + that.numerator, denominator);
        }
    }


    @Override
    public boolean equals(Object other) {
        if(other instanceof Fraction){
            Fraction that = (Fraction) other;
            return this.numerator == that.numerator
                    && this.denominator == that.denominator;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return numerator * 19 + denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
