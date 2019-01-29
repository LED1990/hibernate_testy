package AbstraktFactory;

public class BlokFaktoryClass{

    public static Blok getBlok(BlokFaktory blokFaktory){
        return blokFaktory.stworzBlok();
    }
}
