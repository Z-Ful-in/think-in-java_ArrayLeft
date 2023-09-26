package arrays;

import java.util.*;
import util.*;
public class StringSorting {
    public static void main(String[] args) {
        String[] sa=Generated.array(new String[20],new RandomGenerator.String(5));
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa,Collections.reverseOrder());
        System.out.println("reverse sorting:");
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER);
        System.out.println("case-insensitive sorting:");
        System.out.println(Arrays.toString(sa));
    }
}
