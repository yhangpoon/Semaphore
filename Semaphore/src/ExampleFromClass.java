import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example uses ReentrantLock from the library.
 * 
 * @author Yin
 */
public class ExampleFromClass {

    /**
     * Counter value.
     */
    private long counter = 0;

    /**
     * The lock.
     */
    private final Lock countLock = new ReentrantLock();

    /**
     * Condition One - Odd number.
     */
    private final Condition odd = countLock.newCondition();

    /**
     * Condition One - Multiple of ten.
     */
    private final Condition mul10 = countLock.newCondition();

    /**
     * Increment counter by a specific amount.
     * 
     * @param amount
     *            Specific number to add to counter
     */
    public void inc(long amount) {
        countLock.lock();
        try {
            counter += amount;
            if (counter % 2 == 1)
                odd.signalAll();
            if (counter % 10 == 0)
                mul10.signalAll();
        } finally {
            countLock.unlock();
        }
    }

    /**
     * Threads wait until counter is multiple of ten.
     */
    public void delay_until_10() { // similar for delay_until_odd
        countLock.lock();
        try {
            if (counter % 10 != 0)
                try {
                    mul10.await();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
        } finally {
            countLock.unlock();
        }
    }

    /**
     * Return counter number.
     * 
     * @return the counter
     */
    public long getCounter() {
        countLock.lock();
        long result = counter;
        countLock.unlock();
        return result;
    }
}