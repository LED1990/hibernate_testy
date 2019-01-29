package Thready;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println("co robi główny proces przed?: " + Thread.currentThread()
                                                                    .getName());
        //        main.prostaThreadPool();
//        main.przykladThreadPoolEcexutor();
//        main.przykladThreadPoolEcexutorFutures();
        main.threadPoolZFactory();
        System.out.println("co robi główny proces po?: " + Thread.currentThread()
                                                                 .getName());

    }

    private void prostaThreadPool() {
        //todo prosty thread pool -> predefiniowany z Executors
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //        Executor executorService = Executors.newFixedThreadPool(5); //todo ten interfejs ma tylko jedna metodę która służy do uruchmiania watków.

        for (int i = 0; i < 10; i++) {
            executorService.execute(new PracujacyWatek("" + i));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        System.out.println("koniec wszystkich watków");
    }

    private void przykladThreadPoolEcexutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), new OdrzuconyWatekHandler());

        PracujacyWatekObserwator pracujacyWatekObserwator = new PracujacyWatekObserwator(threadPoolExecutor);
        Thread monitor = new Thread(pracujacyWatekObserwator);
        monitor.start();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new PracujacyWatek("zadanie " + i));//todo exeute nie pozwala na proste i czyste spawdzenie cxy wszystkie zadania zostały zakończone
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
        }
        pracujacyWatekObserwator.zakoncz();
        System.out.println("koniec wszystkich watków");
    }

    private void przykladThreadPoolEcexutorFutures() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), new OdrzuconyWatekHandler());
        List<Future<?>> futures = new ArrayList<Future<?>>();
        PracujacyWatekObserwator pracujacyWatekObserwator = new PracujacyWatekObserwator(threadPoolExecutor);
        Thread monitor = new Thread(pracujacyWatekObserwator);
        monitor.start();
        for (int i = 0; i < 10; i++) {
            //todo submit ma problem gdy jakies watki sa odrzucone
            Future<?> f = threadPoolExecutor.submit(new PracujacyWatekCallable("zadanie " + i));
            futures.add(f);
        }
        threadPoolExecutor.shutdown();//todo zawsze o tym pamietać!
        for (Future<?> f : futures) {
            try {
                System.out.println("futue: " + f.get());//todo blokuje glowny watek do zakonczenia watków uruchomionych
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("czy koniec "+f.isDone());//todo to nie blokuje glownego watku
        }
        pracujacyWatekObserwator.zakoncz();
        System.out.println("koniec wszystkich watków");
    }

    private void threadPoolZFactory(){
        MthreadFactory mthreadFactory = new MthreadFactory("edukacja");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),mthreadFactory, new OdrzuconyWatekHandler());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new PracujacyWatek("zadanie " + i));//todo exeute nie pozwala na proste i czyste spawdzenie cxy wszystkie zadania zostały zakończone
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
        }
        System.out.println("koniec wszystkich watków");
    }
}

