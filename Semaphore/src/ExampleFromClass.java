import java.util.concurrent.locks.ReentrantLock;

/**
 * Example uses ReentrantLock from the library.
 * 
 * @author Yin
 */
public class ExampleFromClass extends Example {

    public ExampleFromClass() {
        this.lock = new ReentrantLock();
        this.odd = lock.newCondition();
        this.mul10 = lock.newCondition();
    }

}