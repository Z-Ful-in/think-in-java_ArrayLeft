package util;
import java.util.*;
public class CollectionData<T> {
    private ArrayList<T> list;
    public CollectionData(Generator<T> gen, int quantity) {
        list = new ArrayList<T>();
        for (int i = 0; i < quantity; i++) {
            list.add(gen.next());
        }
    }
    public T[] toArray(T[] a) {
        return list.toArray(a);
    }
}
