package Factory;

public class PC implements Komputer{

    String ram;
    String dysk;
    String typ;

    public PC(String ram, String dysk) {
        this.ram = ram;
        this.dysk = dysk;
    }

    public PC(String ram, String dysk, String typ) {
        this.ram = ram;
        this.dysk = dysk;
        this.typ = typ;
    }

    public void kimJestem(){
        System.out.println("jestem komputerem PC");
        dodatkowy();
    }

    private void dodatkowy(){
        System.out.println("HAHAHAHAHAHA");
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
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
}
