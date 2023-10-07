package containers;

import java.util.*;
import util.*;
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys=new ArrayList<>();
    private List<V> values=new ArrayList<>();
    public V put(K key,V value){
        V oldValue=get(key);
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }
    public V get(Object key){
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        Iterator ki=keys.iterator();
        Iterator vi=values.iterator();
        while(ki.hasNext())
            set.add(new MapEntry<>((K)ki.next(),(V)vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m=new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
