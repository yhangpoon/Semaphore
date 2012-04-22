/**
 * Example from class lecture.
 * 
 * @author Yin
 */
public class ExampleWithSemaphore extends Example {

    /**
     * Default Constructor.
     */
    public ExampleWithSemaphore() {
        this.lock = new ReentrantSemaphoreLock();
        this.odd = lock.newCondition();
        this.mul10 = lock.newCondition();
    }

}
