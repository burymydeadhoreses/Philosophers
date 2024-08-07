import java.util.concurrent.CountDownLatch;

public class Main {
    public static CountDownLatch countDownLatch = new CountDownLatch(5);

    static final int count = 5;
    static Fork[] forks = new Fork[count];
    static Philosopher[] philosophers = new Philosopher[count];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++)
            forks[i] = new Fork();

        for (int i = 0; i < 5; i++)
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % count]);

        for (Philosopher philosopher : philosophers)
            philosopher.start();

        countDownLatch.await();
    }
}