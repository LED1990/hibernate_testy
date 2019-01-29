package Factory;

public class KomputerFaktory {

    public static Komputer createKomputer(String typ, String ram, String dysk){
        if (typ.equals("PCv2")){
            return new PC(ram, dysk, typ);
        }
        if (typ.equals("Server")){
            return new Serwer(ram, dysk, typ);
        }
        return null;
    }
}
