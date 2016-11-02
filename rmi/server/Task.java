package rmi;

/**
 * Provide a way to start the work.
 *
 * @param <T>
 */
public interface Task<T> {
    T execute();
}
