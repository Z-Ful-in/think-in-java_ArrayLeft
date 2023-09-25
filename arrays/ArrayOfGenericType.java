package arrays;

public class ArrayOfGenericType<T> {
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size){
        //! array=new T[size]; // Illegal
        array=(T[])new Object[size]; // "unchecked" Warning
    }
    // Illegal:
    /*! public <U> U[] makeArray){
        return (U[])new Object[size];
    }*/
}
