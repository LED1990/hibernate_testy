package Thready;

import java.util.concurrent.Callable;

public class PracujacyWatekCallable implements Callable<String> {
    String command;

    public PracujacyWatekCallable(String command) {
        this.command = command;
    }

    @Override
    public String call() throws Exception {
        System.out.println("watek: " + Thread.currentThread().getName() + "start, command: " + command);
        Thread.sleep(500);
        System.out.println("watek: " + Thread.currentThread().getName() + " koniec");
        return command;
    }
}
