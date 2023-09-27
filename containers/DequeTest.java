package containers;

import util.*;
public class DequeTest {
    static void test(Deque<Integer> deque){
        for (int i = 20; i <27 ; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i <55 ; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di=new Deque<>();
        test(di);
        System.out.println(di);
        while (di.size()!=0){
            System.out.print(di.removeFirst()+" ");
        }
        System.out.println();
        test(di);
        while (di.size()!=0){
            System.out.print(di.removeLast()+" ");
        }
    }
}
