package Thready;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * korzystajac z klasy threadPoolexecution można obserwować wykopnywanie zadanie i watek
 */
public class PracujacyWatekObserwator implements Runnable {

    private ThreadPoolExecutor executor;
    private boolean run = true;

    public PracujacyWatekObserwator(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public void zakoncz(){
        this.run = false;
    }

    @Override
    public void run() {
        while (run){
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
