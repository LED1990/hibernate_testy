package AbstraktFactory;

public class BudimexFactory implements BlokFaktory {
    @Override
    public Blok stworzBlok() {
        return new Budimex("jam jest budimex");
    }
}
