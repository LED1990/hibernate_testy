package Thready;

import java.util.concurrent.ThreadFactory;

public class MthreadFactory implements ThreadFactory {
    String nazwa;
    int licznik;

    public MthreadFactory(String nazwa) {
        licznik = 1;
        this.nazwa = nazwa;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, nazwa + "-watek-" + licznik);
        licznik++;
        return t;
    }
}
