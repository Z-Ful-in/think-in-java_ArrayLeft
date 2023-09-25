package arrays;

import java.util.*;
import util.*;

class CompTypeComparator implements Comparator<CompType>{
    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j<o2.j?-1:(o1.j==o2.j?0:1));
    }
}
public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a=Generated.array(new CompType[12],CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a,new CompTypeComparator());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
