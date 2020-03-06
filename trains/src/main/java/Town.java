public class Town<T> {
    private String town;

    public Town(String town){
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getTown().equals(((Town<?>)obj).getTown());
    }

    @Override
    public int hashCode() {
        return this.getTown().hashCode();
    }

    @Override
    public String toString() {
        return "Town " + town;
    }
}
