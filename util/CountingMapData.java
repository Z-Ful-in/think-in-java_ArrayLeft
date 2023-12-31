package util;

import java.util.*;
public class CountingMapData
extends AbstractMap<Integer,String>{
    private int size;
    private static String[]chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    public CountingMapData(int size){
        this.size=Math.max(size,0);
    }
    private static class Entry
    implements Map.Entry<Integer,String>{
        int index;
        Entry(int index){ this.index=index; }
        public boolean equals(Object o){
            return Integer.valueOf(index).equals(o);
        }
        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index%chars.length]+Integer.toString(index/chars.length);
        }

        @Override
        public String setValue(String value) {// Read Only
            throw new UnsupportedOperationException();
        }
        public int hashCode(){
            return Integer.valueOf(index).hashCode();
        }
    }
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {//Entry has been override
        Set<Map.Entry<Integer,String>> entries=new LinkedHashSet<Map.Entry<Integer,String>>();
        for(int i=0;i<size;i++)
            entries.add(new Entry(i));
        return entries;
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
