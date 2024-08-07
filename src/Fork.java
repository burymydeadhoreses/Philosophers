import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    Lock lock = new ReentrantLock();

    public boolean use() {
        return lock.tryLock();
    }

    public void release() {
        lock.unlock();
    }
}
