package util;
import java.util.*;

public class Generated {
    // fill a existing array
    public static <T> T[] array(T[] a, Generator<T>gen){
        return new CollectionData<T>(gen,a.length).toArray(a);
    }
    // create a new array
    @SuppressWarnings("unchecked")
    public static<T> T[] array(Class<T>type,
                               Generator<T> gen, int size){
        T[] a=(T[]) java.lang.reflect.Array.newInstance(type,size);
        return new CollectionData<T>(gen,size).toArray(a);
    }
}
