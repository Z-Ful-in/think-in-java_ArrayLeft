package util;
import java.util.*;
public class RandomGenerator {
    private static Random r=new Random(47);
    public static class
    Boolean implements Generator<java.lang.Boolean> {
        public java.lang.Boolean next(){
            return r.nextBoolean();
        }
    }
    public static class
    Byte implements Generator<java.lang.Byte>{
        public java.lang.Byte next(){ return (byte)r.nextInt(); }
    }
    static char[] chars=("abcdefghijklmnopqrstuvwxyz"+
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class
    Character implements Generator<java.lang.Character>{
        public java.lang.Character next(){
            return chars[r.nextInt(chars.length)];
        }
    }
    public static class
    String implements Generator<java.lang.String>{
        private int length=7;
        Generator<java.lang.Character> cg=new Character();
        public String(){}
        public String(int length){ this.length=length; }
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }
    public static class
    Short implements Generator<java.lang.Short>{
        public java.lang.Short next(){ return (short)r.nextInt(); }
    }
    public static class
    Integer implements Generator<java.lang.Integer>{
        private int mod=10000;
        public Integer(){}
        public Integer(int mod){ this.mod=mod; }
        public java.lang.Integer next(){ return r.nextInt(mod); }
    }
    public static class
    Long implements Generator<java.lang.Long>{
        private int mod=10000;
        public Long(){}
        public Long(int mod){ this.mod=mod; }

        @Override
        public java.lang.Long next() { return new java.lang.Long(r.nextInt(mod)); }
    }
    public static class
    Float implements Generator<java.lang.Float>{
        public java.lang.Float next(){
            int trimmed=Math.round(r.nextFloat()*100);
            return ((float)trimmed)/100;
        }
    }
    public static class
    Double implements Generator<java.lang.Double>{
        public java.lang.Double next(){
            long trimmed=Math.round(r.nextDouble()*100);
            return ((double)trimmed)/100;
        }
    }
}
