package Factory;

public class Serwer implements Komputer {
    String ram;
    String dysk;
    String typ;

    public Serwer(String ram, String dysk, String typ) {
        this.ram = ram;
        this.dysk = dysk;
        this.typ = typ;
    }

    public void kimJestem(){
        System.out.println("jestem serwerem");
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDysk() {
        return dysk;
    }

    public void setDysk(String dysk) {
        this.dysk = dysk;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
