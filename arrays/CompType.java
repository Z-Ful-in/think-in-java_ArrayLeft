package arrays;

import java.util.*;
import util.*;
public class CompType implements Comparable<CompType>{
    int i;
    int j;
    private static int counter=1;
    public CompType(int n1,int n2){
        i=n1;
        j=n2;
    }
    public String toString(){
        String result="[i = "+i+", j = "+j+"]";
        if(counter++%3==0)
            result+="\n";
        return result;
    }
    @Override
    public int compareTo(CompType o) {
        return (i<o.i?-1:(i==o.i?0:1));
    }
    private static Random rand=new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(rand.nextInt(100),rand.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a=Generated.array(new CompType[12],generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
