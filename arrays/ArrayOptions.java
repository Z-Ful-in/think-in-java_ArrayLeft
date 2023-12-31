package arrays;
import java.lang.reflect.Array;
import java.util.*;
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;  // Local uninitialized variable
        BerylliumSphere[] b=new BerylliumSphere[5];
        // the references inside the array are
        // automatically initialized to null:
        System.out.println("b: "+Arrays.toString(b));
        BerylliumSphere[]c=new BerylliumSphere[4];
        for (int i = 0; i < 4; i++) {
            if (c[i] == null) {// can test for null reference
                c[i]=new BerylliumSphere();
            }
        }
        // aggregate initialization:
        BerylliumSphere[]d={
                new BerylliumSphere(),new BerylliumSphere(), new BerylliumSphere()
        };
        // dynamic aggregate initialization:
        a= new BerylliumSphere[]{
                new BerylliumSphere(),new BerylliumSphere()
        };
        // (Trailing comma is optional in both cases)
        System.out.println("a: "+a.length);
        System.out.println("b: "+b.length);
        System.out.println("c: "+c.length);
        System.out.println("d: "+d.length);
        a=d;
        System.out.println("a: "+a.length);

        // Arrays of primitive
        int []e; //Null reference
        int[] f=new int[5];
        // The primitive inside the array are
        // automatically initialized to zero:
        System.out.println("f: "+ Arrays.toString(f));
        int []g=new int[4];
        for (int i = 0; i < 4; i++) {
            g[i]=i*i;
        }
        int []h={11,47,93};
        // Compile Error: variable e not initialized
        // !System.out.println("e.length: "+e.length);
        System.out.println("f.length="+ f.length);
        System.out.println("g.length="+ g.length);
        System.out.println("h.length="+ h.length);
        e=h;
        System.out.println("e.length="+ e.length);
        e=new int[]{1,2};
        System.out.println("e.length="+ e.length);
    }
}
