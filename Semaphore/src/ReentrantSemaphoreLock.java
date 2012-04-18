import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Yin
 * 
 */
public class ReentrantSemaphoreLock implements Lock {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.locks.Lock#lock()
     */
    @Override
    public void lock() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.locks.Lock#lockInterruptibly()
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.locks.Lock#tryLock()
     */
    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.locks.Lock#tryLock(long,
     * java.util.concurrent.TimeUnit)
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.locks.Lock#unlock()
     */
    @Override
    public void unlock() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.locks.Lock#newCondition()
     */
    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }

}
