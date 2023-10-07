package containers;

import java.util.*;
import util.*;
public class SimpleHashSet<T> extends AbstractSet<T> {
    static final int SIZE=997;
    @SuppressWarnings("unchecked")
    LinkedList<T>[] buckets=new LinkedList[SIZE];
    public boolean add(T t){
        int index=Math.abs(t.hashCode())%SIZE;
        if(buckets[index]==null)
            buckets[index]=new LinkedList<T>();
        LinkedList<T> bucket=buckets[index];
        ListIterator<T> it=bucket.listIterator();
        boolean found=false;
        while(it.hasNext()){
            if(it.next().equals(t))
                found=true;
        }
        if(!found)
            buckets[index].add(t);
        return !found;
    }
    public boolean contains(Object o){
        int index=Math.abs(o.hashCode())%SIZE;
        if(buckets[index]==null) return false;
        for(T t: buckets[index])
            if(t.equals(o))
                return true;
        return false;
    }
    public boolean remove(Object o){
        int index=Math.abs(o.hashCode())%SIZE;
        if(buckets[index]==null) return false;
        for(T t: buckets[index])
            if(t.equals(o)){
                buckets[index].remove(o);
                return true;
            }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count;
            private boolean canRemove;
            private int index1,index2;
            @Override
            public boolean hasNext() {
                return count<size();
            }

            @Override
            public T next() {
                if(hasNext()){
                    canRemove=true;
                    ++count;
                    for(;;){
                        while(buckets[index1]==null)
                            index1++;
                        Iterator<T> it=buckets[index1].iterator();
                        T t=it.next();
                        if(!it.hasNext())
                            buckets[index1++]=null;
                        return t;
                    }
                }
                throw new NoSuchElementException();
            }
            public void remove(){
                if(canRemove){
                    canRemove=false;
                    buckets[index2].remove(--index1);
                }
                else
                    throw new IllegalStateException();
            }
        };
    }

    @Override
    public int size() {
        int sz=0;
        for(LinkedList<T> bucket: buckets)
            if(bucket!=null)
                sz+=bucket.size();
        return sz;
    }
}
