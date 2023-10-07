package containers;

import java.util.*;

public class MapEntry<K,V>implements Map.Entry<K,V> {
    private K key;
    private V value;
    public MapEntry<K,V> next;

    public MapEntry() {
        next=null;
    }

    public MapEntry(K key, V value){
        this.key=key;
        this.value=value;
    }
    public MapEntry(K key,V value, MapEntry<K,V> next){
        this.key=key;
        this.value=value;
        this.next=next;
    }
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V result=this.value;
        this.value=value;
        return result;
    }
    public int hashCode(){
        return (key==null?0: key.hashCode())^
                (value==null?0:value.hashCode());
    }
    public boolean equals(Object o){
        if(!(o instanceof MapEntry)) return false;
        MapEntry me=(MapEntry)o;
        return
                (key==null?
                        me.getKey()==null:key.equals(me.getKey()))&&
                (value==null?
                        me.getValue()==null:value.equals(me.getValue()));
    }
    public String toString(){
        return key+"="+value;
    }

    public MapEntry<K, V> getNext() {
        return next;
    }

    public void setNext(MapEntry<K, V> next) {
        this.next = next;
    }
}
