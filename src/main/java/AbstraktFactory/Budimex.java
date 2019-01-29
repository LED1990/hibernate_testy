package AbstraktFactory;

public class Budimex implements Blok {

    String budimex;

    public Budimex(String budimex) {
        this.budimex = budimex;
    }

    @Override
    public void jakiDeveloper() {
        System.out.println("BUDIMEX!!!!!");
    }

    @Override
    public String getPole() {
        return budimex;
    }

    public String getBudimex() {
        return budimex;
    }

    public void setBudimex(String budimex) {
        this.budimex = budimex;
    }
}
