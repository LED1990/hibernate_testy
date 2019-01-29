package Thready;

public class PracujacyWatek implements Runnable {

    String command;

    public PracujacyWatek(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println("watek: " + Thread.currentThread().getName() + "start, command: " + command);
        zadanie();
        System.out.println("watek: " + Thread.currentThread().getName() + " koniec");
    }

    private void zadanie(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
