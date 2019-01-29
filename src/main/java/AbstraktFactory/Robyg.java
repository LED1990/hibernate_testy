package AbstraktFactory;

public class Robyg implements Blok {

    String robyg;

    public Robyg(String robyg) {
        this.robyg = robyg;
    }

    @Override
    public void jakiDeveloper() {
        System.out.println("ROBYG!!!!!");
    }

    @Override
    public String getPole() {
        return robyg;
    }

    public String getRobyg() {
        return robyg;
    }

    public void setRobyg(String robyg) {
        this.robyg = robyg;
    }
}
