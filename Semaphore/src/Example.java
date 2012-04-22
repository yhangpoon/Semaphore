import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Example for testing purposes.
 * 
 * @author Yin
 */
public abstract class Example {

    /**
     * Counter value.
     */
    protected long counter = 0;

    /**
     * The lock.
     */
    protected Lock lock;

    /**
     * Condition One - Odd number.
     */
    protected Condition odd;

    /**
     * Condition One - Multiple of ten.
     */
    protected Condition mul10;

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
    public void delay_until_10() { // similar for delay_until_odd
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
