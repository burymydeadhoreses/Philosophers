public class Philosopher extends Thread {

    private final Fork firstFork;
    private final Fork secondFork;

    private int EatCount;

    public Philosopher(Fork firstFork, Fork secondFork) {
        this.firstFork = firstFork;
        this.secondFork = secondFork;
    }

    @Override
    public void run() {
        while(EatCount < 3) {
            if(firstFork.use()) {
                if(secondFork.use()) {
                    eat();
                    secondFork.release();
                }
                firstFork.release();
            }

            think();
        }

        Main.countDownLatch.countDown();
    }

    private void eat() {
        try {
            Thread.sleep(300);
            EatCount++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void think() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
