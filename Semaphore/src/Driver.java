import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Driver class to test ReentrantSemaphoreLock and ReentrantLock.
 * 
 * @author Yin
 */
public class Driver {

    /**
     * Main method to start the program.
     * 
     * @param args
     *            standard input arguments
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // Example from class

    private long counter = 0;
    private final Lock lock = new ReentrantSemaphoreLock();
    private final Condition odd = lock.newCondition();
    private final Condition mul10 = lock.newCondition();

    public void inc(long amount) {
        lock.lock();
        try {
            counter += amount;
            if (counter % 2 == 1)
                odd.signalAll();
            if (counter % 10 == 0)
                mul10.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void delay_until_10() {
        lock.lock();
        try {
            if (counter % 10 != 0)
                try {
                    mul10.await();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
        } finally {
            lock.unlock();
        }
    }
}
