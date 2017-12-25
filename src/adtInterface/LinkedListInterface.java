package adtInterface;

/**
 *
 * @author ng li poh
 */
public interface LinkedListInterface<T> {

    public void add(T newEntry);

    public T getEntry(int position);

    public int getTotal();

    public boolean isEmpty();

    public T remove(int givenPosition);

}
