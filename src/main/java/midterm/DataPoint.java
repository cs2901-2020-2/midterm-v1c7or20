package midterm;

public class DataPoint<T, V> {
    private T index;
    private V value;

    public DataPoint(T ind, V val){
        index = ind;
        value = val;
    }

    public T getIndex() {
        return index;
    }

    public V getValue() {
        return value;
    }


}
