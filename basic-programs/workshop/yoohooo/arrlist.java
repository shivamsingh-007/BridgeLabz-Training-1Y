package yoohooo;
import java.util.ArrayList;
import java.util.HashSet;

public class arrlist {
    public static void main(String[] args) {
        ArrayList<Integer> al =  new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(2);
        al.add(4);
            HashSet<Integer> hs = new HashSet<>(al);
            ArrayList<Integer> al2 = new ArrayList<>(hs);
        System.out.println(al2);
    

    }
    
}
