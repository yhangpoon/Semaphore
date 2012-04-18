import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * A reentrant mutual exclusion lock implemented using semaphore.
 * 
 * @author Yin Poon
 */
public class ReentrantSemaphoreLock implements Lock {

    private Semaphore lock;

    /**
     * Default Constructor
     * 
     * @param permits
     *            The semaphore value
     */
    public ReentrantSemaphoreLock(int permits) {
        this.lock = new Semaphore(permits);
    }

    /**
     * Acquires the lock.
     */
    @Override
    public void lock() {
        // TODO Auto-generated method stub

    }

    /**
     * Acquires the lock unless the current thread is interrupted.
     * 
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub

    }

    /**
     * Acquires the lock only if it is free at the time of invocation.
     */
    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Acquires the lock if it is free within the given waiting time and the
     * current thread has not been interrupted.
     * 
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Releases the lock.
     */
    @Override
    public void unlock() {
        // TODO Auto-generated method stub

    }

    /**
     * Returns a new Condition instance that is bound to this Lock instance.
     */
    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Internal class SemaphoreCondition.
     */
    private class SemaphoreCondition implements Condition {

        /**
         * Causes the current thread to wait until it is signaled or
         * interrupted.
         */
        @Override
        public void await() {

        }

        /**
         * Causes the current thread to wait until it is signalled.
         */
        @Override
        public void awaitUninterruptibly() {
            // TODO Auto-generated method stub

        }

        /**
         * Causes the current thread to wait until it is signalled or
         * interrupted, or the specified waiting time elapses.
         * 
         * @throws InterruptedException
         */
        @Override
        public long awaitNanos(long nanosTimeout) throws InterruptedException {
            // TODO Auto-generated method stub
            return 0;
        }

        /**
         * Causes the current thread to wait until it is signaled or
         * interrupted, or the specified waiting time elapses.
         * 
         * @throws InterruptedException
         */
        @Override
        public boolean await(long time, TimeUnit unit) throws InterruptedException {
            // TODO Auto-generated method stub
            return false;
        }

        /**
         * Causes the current thread to wait until it is signalled or
         * interrupted, or the specified deadline elapses.
         * 
         * @throws InterruptedException
         */
        @Override
        public boolean awaitUntil(Date deadline) throws InterruptedException {
            // TODO Auto-generated method stub
            return false;
        }

        /**
         * Wakes up one waiting thread.
         */
        @Override
        public void signal() {

        }

        /**
         * Wakes up all waiting threads.
         */
        @Override
        public void signalAll() {
            // TODO Auto-generated method stub

        }

    } // SemaphoreCondition

} // ReentrantSemaphoreLock
