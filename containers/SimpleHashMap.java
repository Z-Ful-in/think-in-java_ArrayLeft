package containers;

import java.util.*;
import util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    // Choose a prime number for the hash table
    // SIZE, to achieve a uniform distribution:
    static final int SIZE=997;
    // you can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets=
            new LinkedList[SIZE];
    public V put(K key,V value){
        V oldValue=null;
        int index=Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null)
            buckets[index]=new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K,V>> bucket=buckets[index];
        MapEntry<K,V> pair=new MapEntry<K,V>(key,value);
        boolean found=false;
        ListIterator<MapEntry<K,V>> it=bucket.listIterator();
        while(it.hasNext()){
            MapEntry<K,V> iPair=it.next();
            if(iPair.getKey().equals(key)){
                oldValue=iPair.getValue();
                it.set(pair);// Replace old with new
                found=true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
        return oldValue;
    }
    public V get(Object key){
        int index=Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null) return null;
        for(MapEntry<K,V> entry: buckets[index])
            if(entry.getKey().equals(key))
                return entry.getValue();
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set=new HashSet<>();
        for(LinkedList<MapEntry<K,V>> bucket: buckets){
            if(bucket==null) continue;
            set.addAll(bucket);
        }
        return set;
    }
    public V remove(Object key){
        V oldValue=null;
        int index=Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null) return null;
        for(MapEntry<K,V> entry: buckets[index]){
            if(entry.getKey().equals(key)){
                oldValue=entry.getValue();
                buckets[index].remove(entry);
                break;
            }
        }
        return oldValue;
    }
    public void clear(){
        for(LinkedList<MapEntry<K,V>> bucket: buckets){
            if(bucket==null) continue;
            bucket.clear();
        }
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m=new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
