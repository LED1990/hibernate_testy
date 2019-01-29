package AbstraktFactory;

public class RobygFactory implements BlokFaktory {

    @Override
    public Blok stworzBlok() {
        return new Robyg("jam jest robyg");
    }
}
