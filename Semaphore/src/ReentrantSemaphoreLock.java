import java.util.Calendar;
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

    private final int SEMAPHOREPERMIT = 1;

    private Semaphore semaphore;

    /**
     * Default Constructor
     * 
     * @param permits
     *            The semaphore value
     */
    public ReentrantSemaphoreLock() {
        this.semaphore = new Semaphore(SEMAPHOREPERMIT, true);
    }

    /**
     * Acquires the lock.
     */
    @Override
    public void lock() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Acquires the lock unless the current thread is interrupted.
     * 
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        semaphore.acquire();
    }

    /**
     * Acquires the lock only if it is free at the time of invocation.
     */
    @Override
    public boolean tryLock() {
        return semaphore.tryAcquire();
    }

    /**
     * Acquires the lock if it is free within the given waiting time and the
     * current thread has not been interrupted.
     * 
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return semaphore.tryAcquire(time, unit);
    }

    /**
     * Releases the lock.
     */
    @Override
    public void unlock() {
        semaphore.release();
    }

    /**
     * Returns a new Condition instance that is bound to this Lock instance.
     */
    @Override
    public Condition newCondition() {
        return new SemaphoreCondition(this);
    }

    /**
     * Internal class SemaphoreCondition.
     */
    private class SemaphoreCondition implements Condition {

        /**
         * The associated lock.
         */
        private Lock lock;

        /**
         * The queue that handles the waiters.
         */
        private Semaphore semaphore;

        /**
         * Number of waiters in the semaphore queue.
         */
        private int waiters;

        /**
         * Default Constructor.
         */
        public SemaphoreCondition(ReentrantSemaphoreLock lock) {
            this.lock = lock;
            semaphore = new Semaphore(0, true);
            waiters = 0;
        }

        /**
         * Causes the current thread to wait until it is signaled or
         * interrupted.
         * 
         * @throws InterruptedException
         */
        @Override
        public void await() throws InterruptedException {
            lock.unlock();
            waiters++;
            semaphore.acquire();
            lock.lock();
        }

        /**
         * Causes the current thread to wait until it is signaled.
         */
        @Override
        public void awaitUninterruptibly() {
            lock.unlock();
            waiters++;
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            lock.lock();

        }

        /**
         * Causes the current thread to wait until it is signaled or
         * interrupted, or the specified waiting time elapses.
         * 
         * @throws InterruptedException
         */
        @Override
        public long awaitNanos(long nanosTimeout) throws InterruptedException {
            lock.unlock();
            waiters++;

            long startTime = System.nanoTime();
            semaphore.tryAcquire(nanosTimeout, TimeUnit.NANOSECONDS);
            long endTime = System.nanoTime();

            waiters--;
            return nanosTimeout - (endTime - startTime);
        }

        /**
         * Causes the current thread to wait until it is signaled or
         * interrupted, or the specified waiting time elapses.
         * 
         * @throws InterruptedException
         */
        @Override
        public boolean await(long time, TimeUnit unit) throws InterruptedException {
            lock.unlock();
            waiters++;
            boolean status = semaphore.tryAcquire(time, unit);
            waiters--;

            return status;
        }

        /**
         * Causes the current thread to wait until it is signaled or
         * interrupted, or the specified deadline elapses.
         * 
         * @throws InterruptedException
         */
        @Override
        public boolean awaitUntil(Date deadline) throws InterruptedException {
            lock.unlock();
            waiters++;

            Date currentDate = Calendar.getInstance().getTime();
            long timeout = deadline.getTime() - currentDate.getTime();
            boolean status = semaphore.tryAcquire(timeout, TimeUnit.MILLISECONDS);

            waiters--;
            return status;
        }

        /**
         * Wakes up one waiting thread.
         */
        @Override
        public void signal() {
            waiters--;
            semaphore.release();
        }

        /**
         * Wakes up all waiting threads.
         */
        @Override
        public void signalAll() {
            semaphore.release(waiters);
            waiters = 0;
        }

    } // SemaphoreCondition

} // ReentrantSemaphoreLock
