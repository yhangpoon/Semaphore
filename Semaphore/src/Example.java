import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Example from class lecture.
 * 
 * @author Yin
 */
public class Example {

    /**
     * Counter.
     */
    private long counter;

    /**
     * Lock.
     */
    private final Lock lock = new ReentrantSemaphoreLock();

    /**
     * Condition One - Odd number.
     */
    private final Condition odd = lock.newCondition();

    /**
     * Condition Two - Multiple of ten.
     */
    private final Condition mul10 = lock.newCondition();

    /**
     * Default Constructor.
     */
    public Example() {
        this.counter = 0;
    }

    /**
     * Increment counter by a specific amount.
     * 
     * @param amount
     *            Specific number to add to counter
     */
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

    /**
     * Threads wait until counter is multiple of ten.
     */
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

    /**
     * Return counter number.
     * 
     * @return the counter
     */
    public long getCounter() {
        return counter;
    }

}
